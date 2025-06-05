package com.oracle.UI;

import java.util.Scanner;

public class Menu {
	
	public static String showMenu(Scanner s) {
		System.out.println("=========================");
		System.out.println("오라클 DB 학사관리 App v1.0");
		System.out.println("=========================");
		System.out.println("1. 테이블 생성");
		System.out.println("2. 테이블 삭제");
		System.out.println("3. 데이터 삽입");
		System.out.println("4. 데이터 보기");
		System.out.println("0. 종료");
		System.out.println("=========================");
		System.out.println("메뉴 선택");
		
		String menu = s.next();
		return menu;
	}
}