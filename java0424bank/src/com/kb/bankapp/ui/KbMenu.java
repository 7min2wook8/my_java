package com.kb.bankapp.ui;

import java.util.Scanner;

import com.kb.bankapp.ui.myState.BankState;

public class KbMenu extends Menu {
	public BankState state = BankState.OTHER;
	public static final String IN_MONEY = "입금";
	public static final String OUT_MONEY = "출금";
	public static final int CREATE_ACC = 1;	// 계좌 생성
	public static final int ADD_BRANCH = 2;	// 지점 추가
	public static final int SHOW_ACC = 3;	// 계좌 보기
	public static final int DEPOSIT = 4;	// 입금
	public static final int WITHDRAW = 5;	// 출금
	public static final int TRANSTER_ACC = 6;	// 출금
	public static final int TRANSTER_INFO = 7;	// 내역출력 
	public static final int EXIT_APP = 0;	// 종료
	
	@Override
	public int mainMenu(Scanner s) {
		System.out.println("=======================");
		System.out.println("KB 인터넷뱅킹 App v1.0");
		System.out.println("=======================");
		System.out.println("1. 계좌 생성");
		System.out.println("2. 지점 추가");
		System.out.println("3. 계좌 보기");
		System.out.println("4. 입금");
		System.out.println("5. 출금");
		System.out.println("6. 이체하기");
		System.out.println("7. 거래내역");
		System.out.println("0. 종료");
		System.out.println("=======================");
		System.out.print("메뉴 선택:");
		int m = s.nextInt();
		return m;
	}
	
	public BankState mainMenu2(Scanner s) {
		switch (mainMenu(s)) {
		case 1: {
			state = BankState.CREATE_ACC;
			break;
		}
		case 2: {
			state = BankState.ADD_BRANCH;	
			break;
				}
		case 3: {
			state = BankState.SHOW_ACC;
			break;
		}
		case 4: {
			state = BankState.DEPOSIT;
			break;
		}
		case 5: {
			state = BankState.TRANSFER_ACC;
			break;
		}
		case 6: {
			state = BankState.TRANSFER_INFO;
			break;
		}
		case 0: {
			state = BankState.EXIT_APP;
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + s);
		}
		return state;
	}
}
