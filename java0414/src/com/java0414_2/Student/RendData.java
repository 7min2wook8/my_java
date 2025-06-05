package com.java0414_2.Student;

public class RendData {
	static String[] name = {"홍길동", "전우치", "김유신", "이순신", "유관순"};
	//static int[] age =  {100, 90,80,70,60};
	static char[] gender = {'남', '여'};
	static String[] address = {"대구시 동구 신안 4동", 
			"서울시 동구 신안 4동",
			"부산시 동구 신안 4동",
			"인천시 동구 신안 4동",
			"광주시 동구 시안 4동"};
	
	
	public static String getRandName() {
		return name[(int) (Math.random()*name.length)];
	}
	
	public static char getRandgender() {
		return gender[(int) (Math.random()*2)];
	}
	
	public static int getRandAge() {
		return (int) ((Math.random()*10) + 10);
	}
	
	public static String getRandAdress() {
		return address[(int) (Math.random()*address.length)];
	}
}
