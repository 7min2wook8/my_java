package java0402;

import java.util.Scanner;

public class Java0403_1 {

	public static void main(String[] args) {
		//금액을 입력 받아 1000, 500, 100, 50으로 교환하는 프로그램
		
		Scanner s = new Scanner(System.in);
		System.out.println("금액을 입력하세요");
		
		
		try {
			
			while (!s.hasNextInt()) { //값이 숫자인지 판별
                s.next();  //값이 숫자가 아니면 버린다.
                System.err.print("에러! 숫자가 아닙니다. \n재 선택 : ");
			}

			int getMoney = s.nextInt();
			
			String msg = checkMoney(getMoney);;
			
			System.out.println(msg);
			
//			if(getMoney >= 1000) {
//				msg += "1000원의 개수는 : " + getMoney / 1000 + " | ";
//				getMoney =  getMoney % 1000;
//			}
//			
//			if(getMoney >= 500) {
//				msg += "500원의 개수는 : " + getMoney / 500 + " | ";				
//				getMoney = getMoney % 500;
//			}
//			
//			if(getMoney >= 100) {
//				msg += "100원의 개수는 : " + getMoney / 100 + " | ";
//				getMoney = getMoney % 100;
//			}
//			
//			if(getMoney >= 50) {
//				msg += "50원의 개수는 : " + getMoney / 50 + " | ";				
//				getMoney = getMoney % 50;	
//			}
//				msg += "나머지 금액은 : " + getMoney;
//				System.out.println(msg);
//				
//				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		s.close();
		
	}
	
	
	
	static String checkMoney(int getMoney) {
		
		int unit = 50000;
		boolean is5unit = true;
		String msg = "";
		
		return CountMoney(getMoney, unit, is5unit, msg);
		
	}
	
	static String CountMoney(int getMoney, int unit, boolean is5unit, String msg) {
		
		if(unit < 50) {
			msg += "나머지 금액은 : " + getMoney;
			return msg;
		}
		
		if(getMoney >= unit) {
			msg += unit + "원의 개수는 : " + getMoney / unit + " | ";
			getMoney =  getMoney % unit;
		}
		
		if(is5unit) {
			unit = unit / 5;			
		}
		else {
			unit = unit / 2;	
		}
		
		is5unit = !is5unit;
		
		return CountMoney(getMoney, unit, is5unit, msg);
		
	}
}
