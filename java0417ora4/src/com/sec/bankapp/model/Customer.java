package com.sec.bankapp.model;

public class Customer {
	private String cno;
	private String name;
	private String tel;
	private String addr;
	
	public Customer(String cno, String name, String tel, String addr) {
		super();
		this.cno = cno;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
