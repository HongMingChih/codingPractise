package com.training.session1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDBConnection {
	public static void main(String[] args) {
		// JDBC 4.0 之前
		createConnection();
		// JDBC 4.0 之後
//		createConnection2();
		// MS SQL
//		createConnection3();
	}
	
	private static void createConnection(){
		// JDBC 4.0 之前必須指定資料庫的驅動程式類別為何,因此就有可能類別字串寫錯
		// 方式一：透過Class.forName註冊資料庫驅動
		// 方式二：於指令列裡指定 -Djdbc.drivers=com.mysql.jdbc.Driver
		// Run As -> Run Configurations -> VM arguments
        try {
        	Class.forName("oracle.jdbc.OracleDriver");
//			Class.forName("oracle.jdbc.OracleDriver").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
		// Create Connection
		Connection conn = null;
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String user = "LOCAL";
	    String passwd = "root";
		try {
			conn = DriverManager.getConnection(url, user, passwd);
	        if(!conn.isClosed()) {
	            System.out.println("資料庫連接已開啟…");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 資料庫連線需手動關閉(否則將佔用DB連線)
			if(conn != null){
				try {
					if(!conn.isClosed()){
						conn.close();
						System.out.println("資料庫連接已關閉…");
					}				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private static void createConnection2(){
		// JDBC 4.0 之後因為驅動程式類別已經註記在JAR中,所以就不需要額外在程式碼中指定
		// ojdbc6.jar -> META-INF -> services -> java.sql.Driver
		Connection mySqlConn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String user = "LOCAL";
	    String passwd = "root";
	    // JDK7 try-with-resource
		try(Connection conn = DriverManager.getConnection(url, user, passwd)){
			mySqlConn = conn;
	        if(!mySqlConn.isClosed()) {
	            System.out.println("資料庫連接已開啟…");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	private static void createConnection3(){
		String url = "jdbc:mysql://localhost:3306/LOCAL_DB";		
	    String user = "root";
	    String passwd = "root";
	    // JDK7 try-with-resource
		try(Connection conn = DriverManager.getConnection(url, user, passwd)){
	        if(!conn.isClosed()) {
	            System.out.println("資料庫連接已開啟…");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
}
