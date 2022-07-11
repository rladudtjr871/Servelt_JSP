package com.test.toy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static Connection conn = null;
	
	public static Connection open() {
		
		
		//연결 문자열, Connection String > 접속 정보 문자열
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "java1234";

		try {
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			
			return conn;
			
			
		} catch (Exception e) {
			System.out.println("DBUtil.open");
			e.printStackTrace();
		}
		
		return null;
		
	}//open
	
	
	
	public static Connection open(String server, String id, String pw) {
		
		
		//연결 문자열, Connection String > 접속 정보 문자열
		String url = "jdbc:oracle:thin:@" + server + ":1521:xe";

		try {
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(url, id, pw);
			
			return conn;
			
			
		} catch (Exception e) {
			System.out.println("DBUtil.open");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
	
	public static void close() {
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
