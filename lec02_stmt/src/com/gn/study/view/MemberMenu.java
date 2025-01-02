package com.gn.study.view;

import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.MemberController;
import com.gn.study.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController controller = new MemberController();
	public void mainMenu() {
		while(true) {
			System.out.println("=== 회원 관리 프로그램 ===");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디 검색");
			System.out.println("4. 회원 이름으로 키워드 검색");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : createMember(); break;
				case 2 : controller.selectMemberAll(); break;
				case 3 : selectByMemberId(); break;
				case 4 : selectByMemberName();break;
				case 5 : updateMember(); break;
				case 6 : deleteMember(); break;
				case 0 : System.out.println("이용해주셔서 감사합니다.");return;
				default : System.out.println("메뉴를 잘못 입력하셨습니다. 다시 입력해주세요.");
			}	
		}
	}
	
	public void deleteMember() {
		System.out.println("=== 회원 탈퇴 === ");
		System.out.println("회원 탈퇴를 하시려면 아이디, 비밀번호를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		Member m = controller.selectByMemberIdPw(id,pw);
		if(m == null) {
			displayFail("회원 탈퇴");
		}else {
			controller.deleteMember(id);
		}
	}
	
	public void updateMember() {
		System.out.println("=== 회원 정보 수정 === ");
		System.out.println("회원 정보를 수정하시려면 아이디, 비밀번호를 입력하세요.");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		
		Member m = controller.selectByMemberIdPw(id,pw);
		if(m == null) {
			displayFail("회원 정보 수정");
		}else {
			displayMember(m);
			System.out.print("이름 수정 : ");
			String name = sc.nextLine();
			System.out.print("이메일 수정 : ");
			String email = sc.nextLine();
			System.out.print("전화번호 수정(-제외) : ");
			String phone = sc.nextLine();
			controller.updateMember(id,name,email,phone);
		}
	}
	
	public void selectByMemberName() {
		System.out.println("=== 이름 키워드 검색 ===");
		System.out.print("키워드 : ");
		String name = sc.nextLine();
		controller.selectByMemberName(name);	
	}
	
	public void createMember() {
		
		System.out.println("=== 회원 정보 입력 ===");
		
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		
		System.out.print("이메일 : ");
		String memberEmail = sc.nextLine();
		
		System.out.print("전화번호(-빼고 입력) : ");
		String memberPhone = sc.nextLine();
		
		System.out.print("성별(M/F) : ");
		String memberGender = sc.nextLine().toUpperCase();

		controller.insertMember(memberId,memberPwd,memberName,memberEmail,memberPhone,memberGender);
	}
	
	public void selectByMemberId() {
		System.out.println("=== 회원 아이디 검색 ===");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		controller.selectByMemberId(id);
	}
	
	public void displaySuccess(String work) {
		System.out.println("요청하신 "+work+"을(를) 성공적으로 수행하였습니다.");
	}
	public void displayFail(String work) {
		System.out.println("요청하신 "+work+" 수행중 오류가 발생하였습니다.");
	}
	public void displayNoData() {
		System.out.println("조회된 결과가 없습니다.");
	}
	public void displayMemberList(List<Member> list) {
		System.out.println("조회된 결과는 다음과 같습니다.");
		for(Member m : list) {
			System.out.println(m);
		}
	}
	
	public void displayMember(Member m) {
		System.out.println("조회된 결과는 다음과 같습니다.");
		System.out.println(m);
	}
}
