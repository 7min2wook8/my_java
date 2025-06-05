package com.kb.bankapp.model;

public class KbCust extends Customer {
	private String birth;

	public KbCust(String cno, String name, String tel, 
		String addr, String birth) {
		super(cno, name, tel, addr);
		this.birth = birth;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "KbCust [birth=" + birth + ", getCno()=" + getCno() + ", getName()=" + getName() + ", getTel()="
				+ getTel() + ", getAddr()=" + getAddr() + ", getClass()=" + getClass() + "]";
	}
	
	
}
