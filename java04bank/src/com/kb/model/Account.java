package com.kb.model;

public class Account {
	private String acNo;
	private String bName;
	private String Cno;
	public Account(String acNo, String bName, String Cno) {
		super();
		this.acNo = acNo;
		this.bName = bName;
		this.Cno = Cno;
	}
	public String getAcNo() {
		return acNo;
	}
	public void setAcNo(String acNo) {
		this.acNo = acNo;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getCno() {
		return Cno;
	}
	public void setcNo(String Cno) {
		this.Cno = Cno;
	}
	
	
	
}
