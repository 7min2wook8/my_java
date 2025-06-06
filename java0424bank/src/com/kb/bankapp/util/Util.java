package com.kb.bankapp.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {

	
	public static String getCurTime() {
		
		// 현재 날짜/시간        
		LocalDateTime now = LocalDateTime.now();         
		// 현재 날짜/시간 출력        
		//System.out.println(now); 
		// 2021-06-17T06:43:21.419878100          
		// 포맷팅        
		String formatedNow = 
				now.format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss"));         
		// 포맷팅 현재 날짜/시간 출력        
		System.out.println(formatedNow);  

		
		
		return formatedNow;
	}
}
