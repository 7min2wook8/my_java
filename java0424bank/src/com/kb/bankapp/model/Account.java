package com.kb.bankapp.model;

// 계좌
public class Account {
	private String acNo;	// 계좌번호
	private String bName;	// 지점명
	private String cno;		// 고객번호
	
	public Account(String acNo, String bName, String cno) {
		super();
		this.acNo = acNo;
		this.bName = bName;
		this.cno = cno;
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
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
}
