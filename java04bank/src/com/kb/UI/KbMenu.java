package com.kb.UI;

import java.util.Scanner;

enum Bank_State{
	IDLE, CREATE_ACC, ADD_BRANCH, SHOW_ACC, DEPOSIT, EXIT_APP
}

public class KbMenu extends Menu {
	public static Bank_State state = Bank_State.IDLE;
	public static final int CREATE_ACC = 1;	// 계좌 생성
	public static final int ADD_BRANCH = 2;	// 지점 추가
	public static final int SHOW_ACC = 3;	// 계좌 보기
	public static final int DEPOSIT = 4;	// 입금
	public static final int EXIT_APP = 0;	// 종료
	
	@Override
	public int mainMenu(Scanner s) {
		// TODO Auto-generated method stub
		System.out.println("=======================");
		System.out.println("KB 인터넷뱅킹 App v1.0");
		System.out.println("=======================");
		System.out.println("1. 계좌 생성");
		System.out.println("2. 지점 추가");
		System.out.println("3. 계좌 보기");
		System.out.println("4. 입금");
		System.out.println("5. 종료");
		System.out.println("=======================");
		System.out.print("메뉴 선택:");
		int m = s.nextInt();
		return m;		
	}

	public MyState mainMenu2(Scanner s) {
		// TODO Auto-generated method stub
		System.out.println("=======================");
		System.out.println("KB 인터넷뱅킹 App v1.0");
		System.out.println("=======================");
		System.out.println("1. 계좌 생성");
		System.out.println("0. 종료");
		System.out.println("=======================");
		System.out.print("메뉴 선택:");
		int m = s.nextInt();
		
		return MyState.valueOf(m+"");		
	}
	
}
