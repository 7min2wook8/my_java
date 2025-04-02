package java0402;

import java.util.Scanner;

public class Java0402_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("이름 입력 : ");
		String name = s.next();
		System.out.println("입력한 이름 : " + name);
		
		
		System.out.println("나이 입력 : ");
		int age = s.nextInt();
		System.out.println("입력한 나이 : " + age);
		
		//s.nextLine(); 의 개행문자 처리용
		s.nextLine();
		System.out.println("주소 입력 : ");
		String addr = s.nextLine();
		System.out.println("입력한 주소 : " + addr);
		
		s.close();
		
	}

}
