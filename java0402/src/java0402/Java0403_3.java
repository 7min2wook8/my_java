package java0402;

import java.util.Scanner;

public class Java0403_3 {

	public static void main(String[] args) {
		//윤년을 구하는 프로그램
		
		Scanner s = new Scanner(System.in);
		
		int res = 0;
		
		
		try {
			System.out.println("첫번째 숫자를 입력하세요.");
			while (!s.hasNextInt()) { //값이 숫자인지 판별
                s.next();  //값이 숫자가 아니면 버린다.
                System.err.print("에러! 숫자가 아닙니다. \n재 선택 : ");
			}
			int num1 = s.nextInt();

			System.out.println("두번째 숫자를 입력하세요.");
			while (!s.hasNextInt()) { //값이 숫자인지 판별
                s.next();  //값이 숫자가 아니면 버린다.
                System.err.print("에러! 숫자가 아닙니다. \n재 선택 : ");
			}
			int num2 = s.nextInt();
			
			
			System.out.println("연산자를 입력하세요.");
			//에러 : 연산자를 문자로 인식 못하는중....
			while (!s.hasNextShort()) { //값이 문자인지 판별
                s.next();  //값이 문자가 아니면 버린다.
                System.err.print("에러! 숫자를 입력하였습니다. \n재 선택 : ");
			}
			
			boolean isTrue = true;
			while(isTrue) {
				String op = s.next();
				
				switch (op) {
					case "+": {
						res = num1 +  num2;
						isTrue = false;
						break;
						
					}
					case "-": {
						res = num1 -  num2;
						isTrue = false;
						break;
						
					}
					case "*": {
						res = num1 *  num2;
						isTrue = false;
						break;
						
					}
					case "/": {
						res = num1 /  num2;
						isTrue = false;
						break;
						
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + "잘못된 문자를 입력");
				}
				
			}
			
			System.out.println("결과 : " + res);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		s.close();
		
	}

}
