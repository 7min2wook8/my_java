package com.kb.UI;

import java.util.Scanner;



public class Menu {
	public int mainMenu(Scanner s) {
		System.out.println("=======================");
		System.out.println("오라클 인터넷뱅킹 App v1.0");
		System.out.println("=======================");
		System.out.println("1. 입금");
		System.out.println("2. 출금");
		System.out.println("3. 계좌 만들기");
		System.out.println("4. 계좌 탈퇴");
		System.out.println("5. 랜덤데이터 추가");
		System.out.println("6. 데이터 수정");
		System.out.println("7. 데이터 삭제");
		System.out.println("0. 종료");
		System.out.println("=======================");
		System.out.print("메뉴 선택:");
		int m = s.nextInt();
		return m;
	}
	
	
	public int updateMenu(Scanner s) {
		System.out.println("=======================");
		System.out.println("수정 항목 선택");
		System.out.println("=======================");
		System.out.println("1. 이름");
		System.out.println("2. 전화");
		System.out.println("3. 주소");
		System.out.println("4. 메인메뉴");	
		System.out.println("=======================");
		System.out.print("메뉴 선택:");
		int m = s.nextInt();
		return m;
	}
}
