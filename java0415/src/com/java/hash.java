package com.java;

import java.util.HashMap;

public class hash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		System.out.println("현재 맵 크기 : " + map.size() + "\n");
		
		map.put(0, "홍길동");
		map.put(1, "전우치");
		map.put(2, "이순신");
		
		System.out.println("현재 맵 크기 : " + map.size() + "\n");
		
		String str = map.get(0);
		System.out.println(str + "\n");
		
		
		map.put(0, "홍길똥");
		System.out.println("현재 맵 : " + map + "\n");
		
		
		map.remove(1);
		System.out.println("현재 맵 : " + map + "\n");
		
		
		map.clear();
		System.out.println("현재 맵 : " + map + "\n");
		
		boolean b = map.isEmpty();
		System.out.println("list is empty? : " + b + "\n");
	}

}
