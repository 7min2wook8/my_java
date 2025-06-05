package com.sec.bankapp;

import java.util.Scanner;

import com.sec.bankapp.db.DbManager;
import com.sec.bankapp.model.Customer;
import com.sec.bankapp.ui.Menu;

public class BankMain {
	public static void main(String[] args) {
		DbManager db = DbManager.getInst();
		Scanner s = new Scanner(System.in);
		while (true) {
			int m = Menu.mainMenu(s);
			if (m == 1) {
				db.createTable();
			}
			else if (m == 2) {
				db.dropTable();
			}
			else if (m == 3) {
				
				System.out.print("고객 이름 입력:");
				String name = s.next();
				System.out.println();
				
				System.out.print("고객 전화번호 입력:");
				String tel = s.next();
				System.out.println();
				s.nextLine();
				System.out.print("고객 주소 입력:");
				String addr = s.nextLine();
				System.out.println();
				
				Customer customer = new Customer("", name, tel, addr);
//				Customer customer = new Customer("", "홍길", "010-0000-0000", "대한민국");
				db.insertDb(customer);
				
			}
			else if (m == 4) {
				db.showAllDb();
			}
			else if (m == 5) {
				db.insertRendomData();
			}	
			else if (m == 6) {
				int updateMenu = 0;
				boolean checkNum = false;
				while (!checkNum) {
					updateMenu = Menu.updateMenu(s);
					switch (updateMenu) {
					case 1: 
					case 2: 
					case 3:
					case 4:
						checkNum = true;
						break;
					default:
						System.out.println("**********************");
						System.out.println("번호를 잘못 선택하였습니다.");
						System.out.println("**********************");
						//throw new IllegalArgumentException("Unexpected value: " + updateMenu);
					}
				}
				if (updateMenu == 4) {
					continue;
				}
				//cno 입력
				System.out.print("수정할 cno를 입력해주세요.");
				String cno = s.next();
				
				//변경할 값 입력
				System.out.print("바꿀 내용을 입력해주세요.");
				String text = s.next();
				db.updateData(updateMenu, cno, text);
			}	
			
			else if (m == 7) {
				System.out.print("삭제할 cno를 입력해주세요.");
				String cno = s.next();
				db.deleteData(cno);
			}	
			else if (m == 0) {
				s.close();
				db.dbClose();
				System.out.println("프로그램 종료!!!");
				break;
			}
		}
	}
}
