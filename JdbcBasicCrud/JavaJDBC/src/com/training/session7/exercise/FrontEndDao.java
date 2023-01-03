package com.training.session7.exercise;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.training.session1.DBConnectionFactory;

public class FrontEndDao {
	
	private static FrontEndDao backendDao = new FrontEndDao();
	
	private FrontEndDao(){ }

	public static FrontEndDao getInstance(){
		return backendDao;
	}
	
	/**
	 * 前臺顧客登入查詢
	 * @param identificationNo
	 * @return Member
	 */
	public Member queryMemberByIdentificationNo(String identificationNo){
		Member member = null;
		String querySQL = "SELECT * FROM BEVERAGE_MEMBER WHERE IDENTIFICATION_NO = ?";
		
				try (Connection conn = DBConnectionFactory.getLocalDBConnection();
					
					PreparedStatement stmt = conn.prepareStatement(querySQL)){
					stmt.setString(1, identificationNo);
					try (ResultSet rs = stmt.executeQuery()){
						while(rs.next()) {
							String IdentificationNo = rs.getString("IDENTIFICATION_NO");
							String password = rs.getString("PASSWORD");
							String customerName = rs.getString("CUSTOMER_NAME");
							member =new Member();
							member.setIdentificationNo(IdentificationNo);
							member.setPassword(password);
							member.setCustomerName(customerName);
						}	
					} catch (SQLException e) {
						throw e;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return member;
	}
	
	/**
	 * 前臺顧客瀏灠商品
	 * @param searchKeyword
	 * @param startRowNo
	 * @param endRowNo
	 * @return Set(Goods)
	 */
	public Set<Goods> searchGoods(String searchKeyword, int startRowNo, int endRowNo) {
		Set<Goods> goods = new LinkedHashSet<>();
		String lowerCaseSearchKeyword = searchKeyword.toLowerCase();//searchKeyword轉小寫
		String querySQL = "SELECT * FROM "
				+ "(SELECT BEVERAGE_GOODS.*, "
				+ "ROWNUM RN FROM BEVERAGE_GOODS WHERE LOWER(GOODS_NAME) LIKE ?)"
				+ "WHERE RN BETWEEN ? AND ?";
				//WHERE RN > ? AND RN< ?
	
				try (Connection conn = DBConnectionFactory.getLocalDBConnection();
					 
					 PreparedStatement stmt = conn.prepareStatement(querySQL)){
				
					stmt.setString(1, "%" +lowerCaseSearchKeyword+ "%");
					stmt.setInt(2, startRowNo+1);
					stmt.setInt(3, endRowNo-1);
					try (ResultSet rs = stmt.executeQuery()){
						
						while(rs.next()) {
							Goods good=new Goods();
							good.setGoodsID(rs.getBigDecimal("GOODS_ID"));
							good.setGoodsName(rs.getString("GOODS_NAME"));
							good.setGoodsPrice(rs.getInt("PRICE"));
							good.setGoodsQuantity(rs.getInt("QUANTITY"));
							good.setGoodsImageName(rs.getString("IMAGE_NAME"));
							good.setStatus(rs.getString("STATUS"));
							goods.add(good);
							
						}	
					} catch (SQLException e) {
						throw e;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
		return goods;
	}

	/**
	 * 查詢顧客所購買商品資料(價格、庫存)
	 * @param goodsIDs
	 * @return Map(BigDecimal, Goods)
	 */
	public Map<BigDecimal, Goods> queryBuyGoods(Set<BigDecimal> goodsIDs) {
		// key:商品編號、value:商品
		Map<BigDecimal, Goods> goods = new LinkedHashMap<>();
		List<BigDecimal> goodsIDsList = new ArrayList<>(goodsIDs);
		Collections.reverse(goodsIDsList);
		String querySQL = "SELECT GOODS_ID,GOODS_NAME,PRICE,QUANTITY FROM " 
							+ "BEVERAGE_GOODS WHERE GOODS_ID = ?";
		   try (Connection conn = DBConnectionFactory.getLocalDBConnection();
			         PreparedStatement stmt = conn.prepareStatement(querySQL)) {
			        for (BigDecimal goodsID : goodsIDsList) {
			            stmt.setBigDecimal(1, goodsID);
			            try (ResultSet rs = stmt.executeQuery()) {
			                if (rs.next()) {
			                    Goods good = new Goods();
			                    good.setGoodsID(rs.getBigDecimal("GOODS_ID"));
			                    good.setGoodsName(rs.getString("GOODS_NAME"));
			                    good.setGoodsPrice(rs.getInt("PRICE"));
			                    good.setGoodsQuantity(rs.getInt("QUANTITY"));
			                    goods.put(goodsID, good);
			                }
			            }
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			    return goods;
			}
	
	/**
	 * 交易完成更新扣商品庫存數量
	 * @param goods
	 * @return boolean
	 */
	public boolean batchUpdateGoodsQuantity(Set<Goods> goods){
		boolean updateSuccess = false;
		
//		// Step1:取得Connection
		try (Connection conn = DBConnectionFactory.getLocalDBConnection()){
			
			conn.setAutoCommit(false);			
			
			String updateSql = "UPDATE BEVERAGE_GOODS SET GOODS_NAME = ?,"
					+ "PRICE = ?,QUANTITY= ? WHERE GOODS_ID = ?";			
			
			try (PreparedStatement stmt = conn.prepareStatement(updateSql)){
				for (Goods good : goods) {
			
				stmt.setString(1,good.getGoodsName());
				stmt.setInt(2,good.getGoodsPrice() );
				stmt.setInt(3, good.getGoodsQuantity());
				stmt.setBigDecimal(4, good.getGoodsID());
				stmt.addBatch();
			}
					
				stmt.executeBatch();
				conn.commit();	
				updateSuccess=true;
			} catch (SQLException e) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateSuccess;
	}
	
	/**
	 * 建立訂單資料
	 * @param customerID
	 * @param goodsOrders【訂單資料(key:購買商品、value:購買數量)】
	 * @return boolean
	 */
	public boolean batchCreateGoodsOrder(String customerID, Map<Goods,Integer> goodsOrders) {
	    boolean insertSuccess = false;
	    String insert_stmt = "INSERT INTO BEVERAGE_ORDER (ORDER_ID,ORDER_DATE,"
	    		+ "CUSTOMER_ID,GOODS_ID,GOODS_BUY_PRICE,BUY_QUANTITY) "
	    		+ "VALUES (BEVERAGE_ORDER_seq.NEXTVAL,?, ?, ?, ?, ?)";
	  
	    for (Map.Entry<Goods, Integer> entry : goodsOrders.entrySet()) {
	    	Goods goods = entry.getKey();
	        Integer quantity = entry.getValue();
	        try (Connection con = DBConnectionFactory.getLocalDBConnection();
	             PreparedStatement pstmt = con.prepareStatement(insert_stmt)) {
	        	
	        	   Date currentTime = new Date();
	               Timestamp timestamp = new Timestamp(currentTime.getTime());
	               pstmt.setTimestamp(1, timestamp);
	            
	            pstmt.setString(2, customerID);
	            pstmt.setBigDecimal(3,goods.getGoodsID());
	            pstmt.setInt(4, goods.getGoodsPrice());
	            pstmt.setInt(5,quantity);
	            pstmt.executeUpdate();
	            insertSuccess = true;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	    }
	    return insertSuccess;
	}

}
