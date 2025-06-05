package com.kb.model;

public class KbCust extends Customer {

	private String birth;

	public KbCust(String cno, String name, String tel, String addr, String birth) {
		super(cno, name, tel, addr);
		this.birth = birth;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
	

}
