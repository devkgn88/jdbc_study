package com.gn.study.view;

import java.util.Scanner;

import com.gn.study.controller.Controller;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Controller c = new Controller();
	
	public void mainMenu() {
		while(true) {
			System.out.println("=== 자동차 정보 관리 ===");
			System.out.println("1. 추가");
			System.out.println("2. 목록 조회");
			System.out.println("3. 단일 조회");
			System.out.println("4. 수정");
			System.out.println("5. 삭제");
			
			System.out.print("메뉴 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
				case 1 : insertCarOne();break;
				case 2 : break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
			}	
		}
	}
	
	public void insertCarOne() {
		String process = "추가";
		System.out.println("*** "+process+" ***");
		System.out.println("모델명, 가격, 출시일을 입력하세요.");
		System.out.println("출시일은 반드시 OOOO-OO-OO 양식에 맞춰서 입력해주세요.");
		System.out.print("모델명 : ");
		String modelName = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("출시일 : ");
		String date = sc.nextLine();
		int result = c.insertCarOne(modelName, price, date);
		printResult(result,process);
	}
	
	public void printResult(int result, String process) {
		if(result > 0) {
			System.out.println(process+"가 정상적으로 완료되었습니다.");
		} else {
			System.out.println(process+"중 오류가 발생하였습니다.");
		}
	}
	
}
