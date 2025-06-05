package com.kb.bankapp;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.kb.bankapp.db.MyDB;
import com.kb.bankapp.model.Account;
import com.kb.bankapp.model.Branch;
import com.kb.bankapp.model.KbCust;
import com.kb.bankapp.model.SavingAcc;
import com.kb.bankapp.ui.KbMenu;
import com.kb.bankapp.util.Util;

public class BankMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDB db = MyDB.getInst();
		Scanner s = new Scanner(System.in);
		KbMenu m = new KbMenu();
		
		while (true) {
			m.mainMenu2(s);
			switch(m.state) {
			case CREATE_ACC:
				System.out.println("===============");
				System.out.println("계좌 생성 정보");
				System.out.println("===============");
				System.out.print("이름:");
				String name = s.next();
				System.out.print("전화:");
				String tel = s.next();
				s.nextLine();
				System.out.print("주소:");
				String addr = s.nextLine();
				System.out.print("생일(yy/mm/dd):");
				String birth = s.next();
				String custNo = db.getCno();
				db.insertDb(new KbCust(custNo, name, tel, addr, birth));
				
				// 계좌정보 객체 DB 추가
				System.out.print("계좌를 개설할 지점:");
				//db.showDb();
				String jname = s.next();
				db.insertDb(new Account(db.getAcNo(), jname, custNo));
				System.out.println("고객 계좌가 개설되었습니다.");
				break;
			case ADD_BRANCH:
				System.out.println("===============");
				System.out.println("지점 추가 입력");
				System.out.println("===============");
				System.out.print("지점명(예:KB신천점):");
				String bName = s.next();
				System.out.print("도시:");
				String bCity = s.next();
				System.out.print("자산:");
				String bJasan = s.next();
				System.out.print("지점영문명:");
				String bEName = s.next();
				System.out.print("지점개설일:");
				String bOpen = s.next();
				System.out.print("전화:");
				String bTel = s.next();
				db.insertDb(
					new Branch(bName, bCity, bJasan, bEName, bOpen, bTel));
				System.out.println("지점 정보가 추가되었습니다.");
				break;
				
			case SHOW_ACC:
				Map<String, List> map = db.getAccount();
				List<KbCust> cuList = map.get("customer");
				List<Account> acList = map.get("account");
				List<Branch> brList = map.get("branch");
				for (int i=0; i<cuList.size(); i++) {
					System.out.println("번호:" + (i+1));
					System.out.println("이름:" + cuList.get(i).getName());
					System.out.println("전화:" + cuList.get(i).getTel());
					System.out.println("주소:" + cuList.get(i).getAddr());
					System.out.println("--------------------");
					System.out.println("계좌:" + acList.get(i).getAcNo());
					System.out.println("--------------------");
					System.out.println("지점명:" + brList.get(i).getbName());
					System.out.println("지점전화:" + brList.get(i).getbTel());
					System.out.println("####################");
				}
				break;
			case DEPOSIT:
				
				String acno = "";
				
				int deposit = 0;
				
			 	KbCust kb =	null;
				Account ac = null;
				SavingAcc sa = null;
				
				while (true) {
					System.out.print("입금할 계좌번호:");
					acno = s.next();
					System.out.print("입금할 금액:");
					deposit = s.nextInt();
					
				 	kb = db.getKbCust(acno);
					ac = db.getAccount(acno);
					sa = db.getSavingAcc(acno, kb, ac);
					if (kb == null || ac == null || sa == null) {
						System.out.println("데이터를 찾을 수 없습니다.");
					}else {
						break;
					}
				}
				
				SavingAcc saObj = new SavingAcc(
					db.getSaNo(), 
					kb, 
					ac, 
					Util.getCurTime(), 
					KbMenu.IN_MONEY, 
					deposit, 
					sa.getSaJango(), 
					acno);
				
				db.insertDb(saObj);
				System.out.print("입금이 완료되었습니다.");
				break;
			case EXIT_APP:
				System.out.println("프로그램 종료!!!");
				s.close();
				db.dbClose();
				System.exit(0);
				break;
			default:
				System.out.println("잘못된 메뉴 선택!!!");
			}
			
		}
	}

}
