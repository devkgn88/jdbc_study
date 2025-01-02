package com.gn.study.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class E_Insert_Transaction {
	public static void main(String[] args) {
		// 1. JDBC 작업용 객체 미리 선언 : Connection, Statement
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 2. JDBC Driver 등록 : 데이터베이스 드라이버 불러오기
			Class.forName("org.mariadb.jdbc.Driver");
			// 3. Connection 객체 생성 : 데이터베이스와 연결
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			// 4. AutoCommit 끄기 : `setAutoCommit(false);` 메소드 호출
			conn.setAutoCommit(false);
			// 5. Statement 객체 생성 : SQL문을 실행하기 위한 객체 생성
			stmt = conn.createStatement();
			// 6. SQL문 실행하기 : 순차적으로 SQL문 실행
			String tName = "테스트6";
			String sql1 = "SELECT COUNT(*) AS cnt"
					+ " FROM test"
					+ " WHERE t_name ='"+tName+"'";
			rs = stmt.executeQuery(sql1);
			int cnt = 0;
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			// 7. 결과 확인하기 : 모든 작업이 성공했는지 확인
			if(cnt == 0) {
				String sql2 = "INSERT INTO test(t_name) "
						+ "VALUES('"+tName+"')";
				cnt = stmt.executeUpdate(sql2);
				// 8. insert 결과 출력하기
				if(cnt > 0) {
					System.out.println("성공적으로 추가되었습니다.");
				} else {
					System.out.println("추가중 오류가 발생했습니다.");
				}
			} else {
				System.out.println("중복되는 이름이 있습니다.");
			}
			// 9. Commit  호출 : 작업 성공시 변경 사항 저장	
			conn.commit();
		} catch(Exception e) {
			try {
				// 10. Rollback 호출 : 실행 중 오류 발생시 변경 사항 취소
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
//		11. 자원 해제 : 모든 객체 닫기
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
