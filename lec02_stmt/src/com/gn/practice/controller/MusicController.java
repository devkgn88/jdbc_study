package com.gn.practice.controller;

import java.util.List;

import com.gn.practice.model.dao.MusicDao;
import com.gn.practice.model.vo.Song;
import com.gn.practice.model.vo.User;

public class MusicController {
	
	private MusicDao md = new MusicDao();
	
	public int deleteUserOne(String id) {
		return md.deleteUserOne(id);
	}
	
	public int updateUserName(String id, String name) {
		return md.updateUserName(id,name);
	}
	
	public List<Song> selectMusicAllOrderByCnt(){
		return md.selectMusicAllOrderByCnt();
	}
	
	public int updatePlayCnt(int no) {
		return md.updatePlayCnt(no);
	}
	
	public Song selectSongOneByNo(int no) {
		return md.selectSongOneByNo(no);
	}
	
	public List<Song> selectMusicAll(){
		return md.selectMusicAll();
	}
	
	public int insertMusicOne(String title, String singer) {
		Song s = new Song(title, singer);
		int result = md.insertSongOne(s);
		return result;
	}
	
	public int isDuplicateMember(String id) {
		int cnt = md.selectMemberOneById(id);
		return cnt;
	}
	
	public int singInMember(String id, String pw, String name) {
		User u = new User(id,pw,name);
		int result = md.singInMember(u);
		return result;
	}
	
	public int loginMember(String id, String pw) {
		User u = new User(id,pw);
		int cnt = md.selectMemberOneByIdAndPw(u);
		return cnt;
	}
}
