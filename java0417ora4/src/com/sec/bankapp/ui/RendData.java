package com.sec.bankapp.ui;

public class RendData {
	static String[] name = {"홍길동", "전우치", "김유신", "이순신", "유관순"};
	static String[] tel =  {"010-0000-0000", "010-1111-1111","010-2222-2222","010-3333-3333","010-4444-4444"};
	static String[] address = {"대구시 동구 신안 4동", 
			"서울시 동구 신안 4동",
			"부산시 동구 신안 4동",
			"인천시 동구 신안 4동",
			"광주시 동구 시안 4동"};

	public static String getRandName() {
		return name[(int) (Math.random()*name.length)];
	}
	
	public static String getRandTel() {
		return tel[(int)(Math.random()*tel.length)];
	}
	
	public static String getRandAdress() {
		return address[(int) (Math.random()*address.length)];
	}
}
