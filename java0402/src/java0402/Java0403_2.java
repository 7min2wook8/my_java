package java0402;

import java.util.Scanner;

public class Java0403_2 {

	public static void main(String[] args) {
		//윤년을 구하는 프로그램
		
		Scanner s = new Scanner(System.in);
		System.out.println("년도를 입력하세요");
		
		
		try {
			
			while (!s.hasNextInt()) { //값이 숫자인지 판별
                s.next();  //값이 숫자가 아니면 버린다.
                System.err.print("에러! 숫자가 아닙니다. \n재 선택 : ");
			}

			int getYear = s.nextInt();
			
			String msg = "";
			
			
			if((getYear % 4 == 0 && getYear % 100 != 0) || getYear % 400 == 0) {
				msg = getYear + "은/는 윤년입니다.";		
			}
				msg = getYear + "은/는 윤년이 아닙니다.";
			System.out.println(msg);
			
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		s.close();
		
	}

}
