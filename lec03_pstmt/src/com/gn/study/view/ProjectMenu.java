package com.gn.study.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.ProjectController;
import com.gn.study.model.vo.ProjectVo;

public class ProjectMenu {
	private Scanner sc = new Scanner(System.in);
	private ProjectController pc = new ProjectController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== (주)ABC 프로젝트 관리 시스템 ===");
			System.out.println("1. 프로젝트 추가");
			System.out.println("2. 프로젝트 전체 조회");
			System.out.println("3. 프로젝트 이름 검색");
			System.out.println("4. 프로젝트 담당자 검색");
			System.out.println("5. 프로젝트 정보 수정");
			System.out.println("6. 프로젝트 삭제");
			System.out.println("0. 종료");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : createProject();break;
				case 2 : showProjectList();break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				case 0 : System.out.println("이용해주셔서 감사합니다.");return;
				default : System.out.println("메뉴를 잘못 입력하셨습니다.");
			}	
		}
	}
	
	public void showProjectList() {
		System.out.println("*** 프로젝트 전체 조회 ***");
		List<ProjectVo> list = pc.selectProjectAll();
		if(list.isEmpty()) {
			System.out.println("조회된 프로젝트 정보가 없습니다.");
		} else {
			for(ProjectVo vo : list) {
				System.out.println(vo);
			}
		}
	}
	
	public void createProject() {
		System.out.println("*** 프로젝트 추가 ***");
		System.out.println("프로젝트명과 담당자 사번을 입력하세요.");
		System.out.print("프로젝트명 : ");
		String name = sc.nextLine();
		System.out.print("담당자 : ");
		int manager = sc.nextInt();
		
		int result = pc.insertProjectOne(name,manager);
		if(result > 0) {
			System.out.println("정상적으로 프로젝트가 추가되었습니다.");
		} else {
			System.out.println("프로젝트 추가중 오류가 발생하였습니다.");
		}
		
	}
}
