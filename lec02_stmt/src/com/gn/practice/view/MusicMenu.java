package com.gn.practice.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gn.practice.controller.MusicController;
import com.gn.practice.model.vo.Song;

public class MusicMenu {
	
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 워터멜론 뮤직에 오신것을 환영합니다. ===");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : signIn(); break;
				case 2 : login(); break;
				case 0 : System.out.println("이용해주셔서 감사합니다.");return;
				default : System.out.println("메뉴를 잘못 입력하셨습니다.");
			}	
		}
	}
	
	public void login() {
		System.out.println("=== 로그인 ===");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		int cnt = mc.loginMember(id,pw);
		if(cnt > 0) {
			if(id.equals("admin")) {
				System.out.println("*** 관리자 메뉴 ***");
				System.out.println("1. 음악 추가");
				System.out.println("2. 음악 인기 순위 조회");
				int menu = sc.nextInt();
				sc.nextLine();
				switch(menu) {
					case 1 : addMusic(); break;
					case 2 : selectMusicAllOrderByCnt();break;
					default : System.out.println("메인 메뉴로 돌아갑니다.");
				}	
			} else {
				System.out.println("*** 사용자 메뉴 ***");
				System.out.println("1. 음악 재생");
				System.out.println("2. 개인 정보 수정");
				System.out.println("3. 회원 탈퇴");
				int menu = sc.nextInt();
				sc.nextLine();
				switch(menu) {
					case 1 : playMusic();break;
					case 2 : break;
					case 3 : break;
					default : System.out.println("메인 메뉴로 돌아갑니다.");
				}	
			}
		} else {
			System.out.println("아이디 혹은 비밀번호가 잘못되었습니다.");
		}
		
	}
	
	public void selectMusicAllOrderByCnt() {
		System.out.println("*** 음악 인기 순위 조회 ***");
		List<Song> list = new ArrayList<Song>();
		list = mc.selectMusicAllOrderByCnt();
		if(list.isEmpty()) {
			System.out.println("음악 목록을 찾을 수 없습니다.");
		} else {
			int num = 1;
			for(Song s : list) {
				System.out.println(num++ +"순위 "+s.toString());
			}
		}
	}
	
	public void playMusic() {
		System.out.println("*** 음악 재생 ***");
		System.out.println("전체 음악 목록을 확인하시여, 재생할 음악 번호를 입력하세요.");
		List<Song> list = new ArrayList<Song>();
		list = mc.selectMusicAll();
		if(list.isEmpty()) {
			System.out.println("재생할 수 있는 음악 목록이 없습니다.");
		} else {
			for(Song s : list) {
				System.out.println(s);
			}
			System.out.print("번호 : ");
			int num = sc.nextInt();
			Song s = mc.selectSongOneByNo(num);
			if(s != null) {
				System.out.println(s.getSongSinger()+"의"
			+s.getSongTitle()+"을 재생합니다.");
				int cnt = mc.updatePlayCnt(s.getSongNo());
				if(cnt > 0) {
					System.out.println(s.getSongTitle()+" 재생횟수가 증가되었습니다.");
				} else {
					System.out.println("음악 재생중 문제가 발생하였습니다.");
				}
				
			} else {
				System.out.println("잘못된 번호입니다.");
			}
		}
	}
	
	public void addMusic() {
		System.out.println("*** 음악 추가 ***");
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("아티스트명 : ");
		String singer = sc.nextLine();
		int result = mc.insertMusicOne(title,singer);
		if(result > 0) {
			System.out.println("음악이 추가되었습니다.");
		} else {
			System.out.println("음악 추가중 오류가 발생했습니다");
		}
	}
	
	public void signIn() {
		System.out.println("=== 회원가입 ===");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		int cnt = mc.isDuplicateMember(id);
		if(cnt > 0) {
			System.out.println("이미 존재하는 아이디입니다.");
		} else {
			System.out.println("사용가능한 아이디입니다.");
			System.out.println("회원가입 진행중...");
			int result = mc.singInMember(id,pw,name);
			if(result > 0) {
				System.out.println("성공적으로 회원가입이 완료되었습니다.");
			}else {
				System.out.println("회원가입중 오류가 발생하였습니다.");
			}
		}
		
	}
}
