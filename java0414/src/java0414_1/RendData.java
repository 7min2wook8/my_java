package java0414_1;

public class RendData {
	static String[] name = {"홍길동", "전우치", "김유신", "이순신", "유관순"};
	static int[] score =  {100, 90,80,70,60};
	
	
	public static String getRandName() {
		return name[(int) (Math.random()*5)];
	}
	
	public static int getRandScore() {
		return score[(int) (Math.random()*5)];
	}
	
}
