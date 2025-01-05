package com.gn.practice.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.gn.practice.model.vo.Song;
import com.gn.practice.model.vo.User;


public class MusicDao {
	
	public int insertSongOne(Song s) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			String sql = "INSERT INTO wm_song"
					+ "(title,singer)"
					+ "VALUES ('"+s.getSongTitle()
					+ "','" + s.getSongSinger()+ "')";
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int selectMemberOneByIdAndPw(User u) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			String sql = "SELECT COUNT(*) "
					+ "FROM wm_user "
					+ "WHERE user_id = '"+u.getUserId()+"' "
					+ "AND user_pw = '"+u.getUserPw()+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
	
	public int singInMember(User u) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			String sql = "INSERT INTO wm_user (user_id,user_pw,user_name)"
					+ "VALUES ('"+u.getUserId()
					+ "','" + u.getUserPw()
					+ "','" + u.getUserName() + "')";
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int selectMemberOneById(String id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/watermelon_music";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			String sql = "SELECT COUNT(*) "
					+ "FROM wm_user "
					+ "WHERE user_id = '"+id+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
}
