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
import com.kb.bankapp.ui.Menu;
import com.kb.bankapp.util.Util;

public class BankMain {
	public static void main(String[] args) {
		MyDB db = MyDB.getInst();
		Scanner s = new Scanner(System.in);
		Menu m = new KbMenu();
				
		while (true) {
			switch(m.mainMenu(s)) {
			case KbMenu.CREATE_ACC:
			{
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
			}
			case KbMenu.ADD_BRANCH:
			{
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
			}
			case KbMenu.SHOW_ACC:
			{
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
			}
			case KbMenu.DEPOSIT:
			{
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
				
				System.out.print(deposit + "금액이 입금되었습니다.");
				break;
			}
			case KbMenu.WITHDRAW:
			{
				String acno = "";
				int deposit = 0;
				
			 	KbCust kb =	null;
				Account ac = null;
				SavingAcc sa = null;
				
				while (true) {
					System.out.print("출금할 계좌번호:");
					acno = s.next();
					System.out.print("출금할 금액:");
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
				
				SavingAcc saObj1 = new SavingAcc(
					db.getSaNo(), 
					kb, 
					ac, 
					Util.getCurTime(), 
					KbMenu.OUT_MONEY, 
					deposit, 
					sa.getSaJango(), 
					acno);
				
				db.insertDb(saObj1);
				System.out.print("출금이 완료되었습니다.");
				break;
			}
			case KbMenu.TRANSTER_ACC:
			{
				//String sano = db.getSaNo();
				String send_acno = "";
				String recv_acno = "";
				int money = 0;
				
			 	KbCust send_kb =	null;
				Account send_ac = null;
				SavingAcc send_sa = null;
				
				KbCust recv_kb =	null;
				Account recv_ac = null;
				SavingAcc recv_sa = null;
				
				while (true) {
					System.out.print("보내는 계좌번호:");
					send_acno = s.next();
					
					System.out.print("받는 계좌번호:");
					recv_acno = s.next();
					
					System.out.print("보내는 금액:");
					money = s.nextInt();
					
					send_kb = db.getKbCust(send_acno);
					send_ac = db.getAccount(send_acno);
					send_sa = db.getSavingAcc(send_acno, send_kb, send_ac);
					
					
					recv_kb = db.getKbCust(recv_acno);
					recv_ac = db.getAccount(recv_acno);
					recv_sa = db.getSavingAcc(recv_acno, recv_kb, recv_ac);
					if (recv_kb == null || recv_ac == null || recv_sa == null) {
						System.out.println("받는 고객 데이터를 찾을 수 없습니다.");
						
					}else if (send_kb == null || send_ac == null || send_sa == null) {
						System.out.println("보내는 고객 데이터를 찾을 수 없습니다.");
						
					}else {
						
						break;
					}
					
				}
				System.out.println("처리중.........");
				//보내는 고객 정보
				SavingAcc saObj1 = new SavingAcc(
					db.getSaNo(), 
					send_kb, 
					send_ac, 
					Util.getCurTime(), 
					KbMenu.OUT_MONEY, 
					money, 
					send_sa.getSaJango(), 
					recv_acno);
				
				db.insertDb(saObj1);
				System.out.printf("%,d원 출금되었습니다. \n", money);
				
				//받는 고객 정보
				SavingAcc saObj2 = new SavingAcc(
						db.getSaNo(), 
						recv_kb, 
						recv_ac, 
						Util.getCurTime(), 
						KbMenu.IN_MONEY, 
						money, 
						recv_sa.getSaJango(), 
						send_acno);
				
				db.insertDb(saObj2);
				System.out.printf("%,d원 입금되었습니다. \n", money);
				
				break;
			}
			
			case KbMenu.TRANSTER_INFO:
			{
				String str = s.next();
				List<SavingAcc> cuList = db.getSavingAcc(str);
				
				for (int i=0; i<cuList.size(); i++) {
					System.out.println("번호:" + (i+1));
					System.out.println("계좌번호:" + cuList.get(i).getSano());
					System.out.println("고객 정보:" + cuList.get(i).getKbcu());
					System.out.println("날짜:" + cuList.get(i).getSadate());
					System.out.println("--------------------");
					System.out.println("입출금:" + cuList.get(i).getSaInOut());
					System.out.println("--------------------");
					System.out.println("잔고:" + cuList.get(i).getSaJango());
					System.out.println("거래 금액:" + cuList.get(i).getSaMoney());
					System.out.println("거래자:" + cuList.get(i).getTransfer());
					System.out.println("####################");
				}
				break;
			}
			
			case KbMenu.EXIT_APP:
			{
				System.out.println("프로그램 종료!!!");
				s.close();
				db.dbClose();
				System.exit(0);
			}
			default:
				System.out.println("잘못된 메뉴 선택!!!");
			}
		}
	}
}
