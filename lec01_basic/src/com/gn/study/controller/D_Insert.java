package com.gn.study.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class D_Insert {
	public static void main(String[] args) {
		// 1. JDBC 작업용 객체 미리 선언
		// Connection, Statement 등
		Connection conn = null;
		Statement stmt = null; 
		try {
			// 2. JDBC Driver 등록
			// 데이터베이스 연결을 위한 드라이버 불러오기
			Class.forName("org.mariadb.jdbc.Driver");
			// 3. Connection 객체 생성
			// 데이터베이스와의 연결 통로 만들기
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			// 4. Statement 객체 생성
			stmt = conn.createStatement();
			// 5. SQL문 실행하기
			// String sql ="INSERT INTO test(t_no ,t_name ,t_date) VALUES(5,'테스트5',NOW())";
			String sql ="INSERT INTO test(t_name) VALUES('테스트5')";
			int result = stmt.executeUpdate(sql);
			// 6. 결과 처리하기
			// 영향 받은 행의 개수를 받아서 처리
			if(result > 0) {
				System.out.println("성공적으로 추가되었습니다.");
			} else {
				System.out.println("추가중 오류가 발생했습니다.");
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			// 7. 자원 해제
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
