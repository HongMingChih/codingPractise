package com.training.session7.exercise;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import com.training.session1.DBConnectionFactory;

public class BackEndDao {
	
	private static BackEndDao backendDao = new BackEndDao();
	
	private BackEndDao(){ }

	public static BackEndDao getInstance(){
		return backendDao;
	}
	
	/**
	 * 後臺管理商品列表
	 * @return Set(Goods)
	 */
	public Set<Goods> queryGoods() {
	    Set<Goods> goods = new LinkedHashSet<>(); 

	    String querySQL = "SELECT * FROM BEVERAGE_GOODS";

	    try (Connection conn = DBConnectionFactory.getLocalDBConnection();
	         PreparedStatement stmt = conn.prepareStatement(querySQL);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Goods good = new Goods();
	            good.setGoodsID(rs.getBigDecimal("GOODS_ID"));
	            good.setGoodsName(rs.getString("GOODS_NAME"));
	            good.setGoodsPrice(rs.getInt("PRICE"));
	            good.setGoodsQuantity(rs.getInt("QUANTITY"));
	            good.setGoodsImageName(rs.getString("IMAGE_NAME"));
	            good.setStatus(rs.getString("STATUS"));

	            goods.add(good);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return goods;
	}

	
	/**
	 * 後臺管理新增商品
	 * @param goods
	 * @return int(商品編號)
	 */
	public int createGoods(Goods goods){
		int goodsID = 0;
		String insert_stmt = "INSERT INTO BEVERAGE_GOODS "
				+ "(GOODS_ID,GOODS_NAME,PRICE,QUANTITY,IMAGE_NAME,STATUS) "
				+ "VALUES (BEVERAGE_GOODS_seq.NEXTVAL, ?, ?, ?, ?, ?)";
		String cols[] = { "GOODS_ID" };
		
		try (Connection con = DBConnectionFactory.getLocalDBConnection();
				PreparedStatement pstmt = con.prepareStatement(insert_stmt, cols)) {
			pstmt.setString(1, goods.getGoodsName());
			pstmt.setInt(2, goods.getGoodsPrice());
			pstmt.setInt(3, goods.getGoodsQuantity());
			pstmt.setString(4, goods.getGoodsImageName());
			pstmt.setString(5, goods.getStatus());
			pstmt.executeUpdate();
			
			ResultSet rsKeys = pstmt.getGeneratedKeys();
			ResultSetMetaData rsmd = rsKeys.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rsKeys.next()) {
				for (int i = 1; i <= columnCount; i++) {
					rsKeys.getString(i);					
					goodsID=rsKeys.getInt(i);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodsID;
	}
	
	/**
	 * 後臺管理更新商品
	 * @param goods
	 * @return boolean
	 */
	public boolean updateGoods(Goods goods) {
		boolean updateSuccess = false;

		String updateSql = "UPDATE BEVERAGE_GOODS SET GOODS_NAME = ?, PRICE = ?, "
				+ "QUANTITY = ? , IMAGE_NAME = ? , STATUS = ? WHERE GOODS_ID = ?";
		try (Connection conn = DBConnectionFactory.getLocalDBConnection();
				 PreparedStatement stmt = conn.prepareStatement(updateSql)) {
				conn.setAutoCommit(false);
				stmt.setString(1, goods.getGoodsName());
				stmt.setInt(2, goods.getGoodsPrice());
				stmt.setInt(3, goods.getGoodsQuantity());
				stmt.setString(4, goods.getGoodsImageName());
				stmt.setString(5, goods.getStatus());
				stmt.setBigDecimal(6, goods.getGoodsID());
				stmt.executeUpdate();
				conn.commit();
				updateSuccess = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return updateSuccess;
	}

	/**
	 * 後臺管理刪除商品
	 * @param goodsID
	 * @return boolean
	 */
	public boolean deleteGoods(BigDecimal goodsID) {
		boolean deleteSuccess = false;
		String deleteSql = "DELETE FROM BEVERAGE_GOODS WHERE GOODS_ID = ?";
		try (Connection conn = DBConnectionFactory.getLocalDBConnection();
			 PreparedStatement stmt = conn.prepareStatement(deleteSql)) {
			conn.setAutoCommit(false);
			stmt.setBigDecimal(1, goodsID);
			stmt.executeUpdate();
			conn.commit();
			deleteSuccess = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteSuccess;
	}
	
	/**
	 * 後臺管理顧客訂單查詢
	 * @param queryStartDate
	 * @param queryEndDate
	 * @return Set(SalesReport)
	 */
	public Set<SalesReport> queryOrderBetweenDate(String queryStartDate, String queryEndDate) {
		Set<SalesReport> reports = new LinkedHashSet<>();
		String querySQL = "SELECT o.ORDER_ID, m.CUSTOMER_NAME, o.ORDER_DATE, g.GOODS_NAME,"
                + "g.PRICE, o.BUY_QUANTITY, g.PRICE, o.BUY_QUANTITY*g.PRICE buyAmount FROM BEVERAGE_ORDER o "
                + "JOIN BEVERAGE_MEMBER m ON o.CUSTOMER_ID = m.IDENTIFICATION_NO "
                + "JOIN BEVERAGE_GOODS g ON o.GOODS_ID = g.GOODS_ID "
                + "WHERE o.ORDER_DATE "
                + "BETWEEN TO_DATE(?, 'YYYY-mm-DD HH24:MI:SS') AND TO_DATE(?, 'YYYY-mm-DD HH24:MI:SS') "
                + "ORDER BY o.ORDER_ID";
		
				try (Connection conn = DBConnectionFactory.getLocalDBConnection();
					PreparedStatement stmt = conn.prepareStatement(querySQL)){
					stmt.setString(1, queryStartDate + " 00:00:00");
					stmt.setString(2, queryEndDate + " 23:59:59");
					try (ResultSet rs = stmt.executeQuery()){
						while(rs.next()) {
							Long orderID=rs.getLong("ORDER_ID");
							String customerName = rs.getString("CUSTOMER_NAME");
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String orderDateStr = rs.getString("ORDER_DATE");
							Date orderDate = sdf.parse(orderDateStr);
							String formattedOrderDate = sdf.format(orderDate);
							
							String goodsName = rs.getString("GOODS_NAME");
							int goodsBuyPrice = rs.getInt("PRICE");
							int buyQuantity = rs.getInt("BUY_QUANTITY");
							int buyAmount = rs.getInt("BUYAMOUNT");

							SalesReport salesReport = new SalesReport();
							salesReport.setOrderID(orderID);
							salesReport.setCustomerName(customerName);
							salesReport.setOrderDate(formattedOrderDate);
							salesReport.setGoodsName(goodsName);
							salesReport.setGoodsBuyPrice(goodsBuyPrice);
							salesReport.setBuyQuantity(buyQuantity);
							salesReport.setBuyAmount(buyAmount);
							reports.add(salesReport);
						}	
					} catch (SQLException e) {
						throw e;
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return reports;
	}
	
}
