package com.oracle.db;

import java.util.Scanner;

import com.oracle.Student.Student;
import com.oracle.UI.Menu;

public class OraclMainSingle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner =new Scanner(System.in);
		DbManager db = DbManager.getInstance();
		
		
		while (true) {
			
			
			String string = Menu.showMenu(scanner);
			
			switch (string) {
			case "1":
				System.out.println("--1. 테이블 생성 실행--");
				db.createTable();
				break;

			case "2":
				System.out.println("--2. 테이블 삭제 실행--");
				db.dropTable();
				break;
			case "3":
				System.out.println("--3. 데이터 삽입 실행--");
				db.insertTable(new Student("S001", "홍길동1", "010-0000-0000", "의적"));
				db.insertTable(new Student("S002", "홍길동2", "010-0000-0000", "의적"));
				db.insertTable(new Student("S003", "홍길동3", "010-0000-0000", "의적"));
				db.insertTable(new Student("S004", "홍길동4", "010-0000-0000", "의적"));
				db.insertTable(new Student("S005", "홍길동5", "010-0000-0000", "의적"));
				db.insertTable(new Student("S006", "홍길동6", "010-0000-0000", "의적"));
				break;
				
			case "4":
				System.out.println("--4.데이터 보기 실행--");
				db.showDB();
				break;
				
			case "0":
				db.close();
				System.out.println("--0. 종료--");
				System.exit(0);
				break;
				
			default:
				System.out.println("잘못된 입력입니다!!");
				break;
			}
			
		}
		
	}

}
