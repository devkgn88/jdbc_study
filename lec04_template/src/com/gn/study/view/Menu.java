package com.gn.study.view;

import java.util.List;
import java.util.Scanner;

import com.gn.study.controller.Controller;
import com.gn.study.model.vo.Car;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Controller controller = new Controller();
	
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
				case 2 : selectCarAll();break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
			}	
		}
	}
	
	public void selectCarAll() {
		System.out.println("*** 목록 조회 ***");
		List<Car> list = controller.selectCarAll();
		printList(list);	
	}
	
	public void printList(List<Car> list) {
		if(list.isEmpty()) {
			System.out.println("조회된 정보가 없습니다.");
		} else {
			for(Car c : list) {
				System.out.println(c);
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
		int result = controller.insertCarOne(modelName, price, date);
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
