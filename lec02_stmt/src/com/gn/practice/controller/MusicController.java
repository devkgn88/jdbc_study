package com.gn.practice.controller;

import com.gn.practice.model.dao.MusicDao;
import com.gn.practice.model.vo.Song;
import com.gn.practice.model.vo.User;

public class MusicController {
	
	private MusicDao md = new MusicDao();
	
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
