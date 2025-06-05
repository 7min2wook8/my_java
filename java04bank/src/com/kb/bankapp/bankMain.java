package com.kb.bankapp;

import java.util.Scanner;

import com.kb.UI.KbMenu;
import com.kb.UI.MyState;
import com.kb.db.DbManager;
import com.kb.db.MyDB;
import com.kb.model.Account;
import com.kb.model.Customer;
import com.kb.model.KbCust;



public class bankMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDB db = MyDB.getInst();
		Scanner s = new Scanner(System.in);
		KbMenu mKbMenu = new KbMenu();
		
		
		while (true) {
			//state = mKbMenu.mainMenu(s)
			switch (mKbMenu.mainMenu(s)) {
			case KbMenu.CREATE_ACC:
				System.out.println("=========");
				System.out.println("계좌생성");
				System.out.println("=========");
				System.out.println("이름 : ");
				String name = s.next();
				System.out.println("전화 : ");
				String tel = s.next();
				s.nextLine();
				System.out.println("주소 : ");
				String addr = s.next();
				s.nextLine();
				System.out.println("생일(yyyy/mm/dd) : ");
				String birth = s.next();
				s.nextLine();
				
				String custNo = db.getLastCno();
				KbCust customer = new KbCust(custNo, name, tel, addr, birth);
				db.insertDb(customer);
				
				//지점명 출력하고 그 중 하나라도 맞으면 db입력
				System.out.println("지점명 : ");
				String jname = s.next();
				String AcNo = db.getAcNo();
				Account account = new Account(AcNo, jname, custNo);
				db.insertDb(account);
				break;
				
			case KbMenu.ADD_BRANCH:
				
				break;
				
			case KbMenu.EXIT_APP:
				s.close();
				db.dbClose();
				System.out.println("프로그램 종료!!!");
				System.exit(0);
				break;
			default:
				System.out.println("잘못된 메뉴 선택!!!");
				break;
			}
			
		}
	}

}
