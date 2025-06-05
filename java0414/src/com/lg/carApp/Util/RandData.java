package com.lg.carApp.Util;

public class RandData {
	
	static String name[] = {"홍길동", "김길동", "박길동", "이길동", "최길동"};
	static String tel[] = {"010-1234-5678", "010-4321-5678", "010-3478-1278","010-4523-1978", "010-7890-2134"};
	static	String address[] = {"대구시 동구 신암4동", "서울시 동구 신암4동",  "부산시 동구 신암4동", "인천시 동구 신암4동", "광주시 동구 신암4동"};
	static	String model[] = {"SM6", "쏘나타", "싼타페", "K7", "그랜져"};
	static	String color[] = {"블랙", "은색", "흰색", "회색", "빨강"};
	static	int year[] = {2016, 2017, 2016, 2017, 2016};
	static	String company[] = {"삼성르노", "현대", "현대", "기아", "현대"};
	
	
	public static String getName(int i) {
		return name[i];
	}
	public static String getName() {
		return name[(int)(Math.random() * name.length)];
	}

	public static String getTel(int i) {
		return tel[i];
	}

	public static String getTel() {
		return tel[(int)(Math.random() * tel.length)];
	}
	
	public static String getAddress(int i) {
		return address[i];
	}

	public static String getAddress() {
		return address[(int)(Math.random() * address.length)];
	}
	
	public static String getModel(int i) {
		return model[i];
	}

	public static String getModel() {
		return model[(int)(Math.random() * model.length)];
	}
	
	public static String getColor(int i) {
		return color[i];
	}

	public static String getColor() {
		return color[(int)(Math.random() * color.length)];
	}
	
	public static int getYear(int i) {
		return year[i];
	}

	public static int getYear() {
		return year[(int)(Math.random() * year.length)];
	}
	
	public static String getCompany(int i) {
		return company[i];
	}
	
	public static String getCompany() {
		return company[(int)(Math.random() * company.length)];
	}
	
}
