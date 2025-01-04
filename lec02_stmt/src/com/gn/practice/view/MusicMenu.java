package com.gn.practice.view;

import java.util.Scanner;

import com.gn.practice.controller.MusicController;

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
					case 1 : break;
					case 2 : break;
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
					case 1 : break;
					case 2 : break;
					case 3 : break;
					default : System.out.println("메인 메뉴로 돌아갑니다.");
				}	
			}
		} else {
			System.out.println("아이디 혹은 비밀번호가 잘못되었습니다.");
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
