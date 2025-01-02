package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Member;

public class MemberDao {
	
	public int deleteMember(String id) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		String sql = "DELETE FROM `member`"
				+ "WHERE m_id = '"+id+"'";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,user,pw);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		  
		return result;
	}
	
	public int updateMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		String sql = "UPDATE member "
				+ "SET m_name = '"+m.getMemberName()+"'"
				+ ",m_email = '"+m.getMemberEmail()+"'"
				+",m_phone = '"+m.getMemberPhone()+"' "
				+" WHERE m_id = '"+m.getMemberId()+"'";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,user,pw);
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Member selectByMemberIdPw(String mId,String mPw) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member m = null;
		String sql = "SELECT * FROM member "
				+ "WHERE m_id = '"+mId+"'"
				+"AND m_pw = '"+mPw+"'";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,user,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				m = new Member(rs.getInt("m_no")
						,rs.getString("m_id")
						,rs.getString("m_pw")
						,rs.getString("m_name")
						,rs.getString("m_email")
						,rs.getString("m_phone")
						,rs.getString("m_gender")
						,rs.getTimestamp("reg_date").toLocalDateTime()
						,rs.getTimestamp("mod_date").toLocalDateTime());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	
	
	public List<Member> selectByMemberName(String name){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member where m_name LIKE '%"+name+"%'";
		List<Member> resultList = new ArrayList<Member>();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,user,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Member m = new Member(rs.getInt("m_no")
						,rs.getString("m_id")
						,rs.getString("m_pw")
						,rs.getString("m_name")
						,rs.getString("m_email")
						,rs.getString("m_phone")
						,rs.getString("m_gender")
						,rs.getTimestamp("reg_date").toLocalDateTime()
						,rs.getTimestamp("mod_date").toLocalDateTime());
				resultList.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}
	
	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0; 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,user,pw);
			String sql = "INSERT INTO member (m_id, m_pw, m_name, m_email, m_phone, m_gender) VALUES"
					+ "	('"+m.getMemberId()+"', '"+m.getMemberPw()+"', '"+m.getMemberName()
					+"', '"+m.getMemberEmail()+"', '"+m.getMemberPhone()+"', '"+m.getMemberGender()+"')";
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<Member> selectMemberAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Member> resultList = new ArrayList<Member>();
		String sql = "SELECT * FROM member";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,user,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Member m = new Member(rs.getInt("m_no")
						,rs.getString("m_id")
						,rs.getString("m_pw")
						,rs.getString("m_name")
						,rs.getString("m_email")
						,rs.getString("m_phone")
						,rs.getString("m_gender")
						,rs.getTimestamp("reg_date").toLocalDateTime()
						,rs.getTimestamp("mod_date").toLocalDateTime());
				resultList.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultList;
	}
	
	public Member selectByMemberId(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member m = null;
		String sql = "SELECT * FROM member where m_id = '"+id+"'";
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url,user,pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				m = new Member(rs.getInt("m_no")
						,rs.getString("m_id")
						,rs.getString("m_pw")
						,rs.getString("m_name")
						,rs.getString("m_email")
						,rs.getString("m_phone")
						,rs.getString("m_gender")
						,rs.getTimestamp("reg_date").toLocalDateTime()
						,rs.getTimestamp("mod_date").toLocalDateTime());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				rs.close();
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
}
