package com.callor.book.persistence;
/*
 * DB 연동을 위한 dbConnect 객체를 미리 생성해 두고,
 *  필요할때 사용할수 있도록 하는 클래스
 *  static class로 생성 
 *  클래스에 포함된 필드변수, 멤버 method 중
 *   1개라도 static 키워드가 부착되면 static class가 된다
 *   프로젝트가 Run 되는 순간 미리 객체로 생성되어
 *   준비되는 클래스
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
	private static Connection dbConn = null;
	
	// static으로 선언된 dbConn 객체를 초기화하는 코드
	// 무명 method로 dbConn 객체 초기화
	static {
		
		String jdbcDriver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "scUser";
		String password = "scUser";
		
		try {
			// Java 1.7이상에서는 사용하지 않아도 되는 코드
			Class.forName(jdbcDriver);
			
			// dbConn이 null일경우에만 생성
			if(dbConn == null) {
				dbConn 
					= DriverManager.getConnection(url,username,password);
			}
			System.out.println("오라클 접속 OK");
			
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 Driver를 찾을 수 없음");
			System.out.println("오라클 Ojdbc6.jar를 확인하세요");
		} catch (SQLException e) {
			
			System.out.println("=".repeat(30));
			System.out.println("오라클 DBMS 연결 실패");
			System.out.println("접속 정보를 확인하세요");
			System.out.println("URL : " + url);
			System.out.println("User :" + username);
			System.out.println("PW : " + password);
			System.out.println("=".repeat(30));
		}
	} // end static

	public static Connection getDBConnection() {
		return dbConn;
	}
}
