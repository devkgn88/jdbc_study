package com.gn.practice.model.vo;

public class Song {
	private int songNo;
	private String songTitle;
	private String songSinger;
	private int songCnt;
	
	public Song() {}
	
	public Song(String songTitle, String songSinger) {
		this.songTitle = songTitle;
		this.songSinger = songSinger;
	}

	public Song(int songNo, String songTitle, String songSinger, int songCnt) {
		this.songNo = songNo;
		this.songTitle = songTitle;
		this.songSinger = songSinger;
		this.songCnt = songCnt;
	}

	public int getSongNo() {
		return songNo;
	}

	public void setSongNo(int songNo) {
		this.songNo = songNo;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getSongSinger() {
		return songSinger;
	}

	public void setSongSinger(String songSinger) {
		this.songSinger = songSinger;
	}

	public int getSongCnt() {
		return songCnt;
	}

	public void setSongCnt(int songCnt) {
		this.songCnt = songCnt;
	}

	@Override
	public String toString() {
		return "[번호 : " + songNo 
				+ ", 제목 : " + songTitle 
				+ ", 가수 : " + songSinger 
				+ ", 재생 횟수 : "+ songCnt + "]";
	}
	
	
	
}
