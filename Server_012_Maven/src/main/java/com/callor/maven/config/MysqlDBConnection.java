package com.callor.maven.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDBConnection {

	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/root";
		String username = "root";
		String password = "!Biz1234";
		
		try {
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				dbConn = DriverManager.getConnection(url, username, password);
			}
			
			System.out.println("MySQL 접속 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			System.out.println("jdbcDriver 경로 오류");
			System.out.println("jdbcDriver : " + jdbcDriver);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("MySQL 접속 오류");
			System.out.println("url : " + url);
			System.out.println("username : " + username);
			System.out.println("password : " + password);
		}
		
		
	}
	
	public static Connection getConnection () {
		return dbConn;
	}
}
