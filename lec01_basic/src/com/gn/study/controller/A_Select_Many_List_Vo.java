package com.gn.study.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Test;

public class A_Select_Many_List_Vo {
	public static void main(String[] args) {
		// 1. JDBC 작업용 객체 미리 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 2. JDBC Driver 등록
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 3. Connection 객체 생성
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,id,pw);
			
			// 4. Statement 객체 생성
			stmt = conn.createStatement();
			
			// 5. SQL문 실행해서 결과 전달 받기
			String sql = "SELECT t_no ,t_name ,t_date FROM test";
			rs = stmt.executeQuery(sql);
			
			// 6. ResultSet에 있는 데이터 추출해서 List<Test>에 담기
			List<Test> list = new ArrayList<Test>();
			while(rs.next()) {
				Test t = new Test();
				t.setTestNo(rs.getInt("t_no"));
				t.setTestName(rs.getString("t_name"));
				t.setTestDate(rs.getTimestamp("t_date").toLocalDateTime());
				list.add(t);
			}
			// 7. 조회된 결과 출력
			if(list.isEmpty()) {
				System.out.println("조회된 결과가 없습니다.");
			} else {
				for(int i = 0 ; i < list.size() ; i++) {
					System.out.println(list.get(i));
				}
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 8. 사용한 객체 close
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
