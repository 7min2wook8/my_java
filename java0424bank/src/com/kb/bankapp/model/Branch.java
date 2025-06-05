package com.kb.bankapp.model;

// 지점
public class Branch {
	private String bName;	// 지점명
	private String bCity;	// 도시
	private String bJasan;	// 자산
	private String beName; 	// 영문지점명
	private String bOpen; 	// 지점재설일
	private String bTel; 	// 전화
	
	public Branch(String bName, String bCity, String bJasan, 
		String beName, String bOpen, String bTel) {
		super();
		this.bName = bName;
		this.bCity = bCity;
		this.bJasan = bJasan;
		this.beName = beName;
		this.bOpen = bOpen;
		this.bTel = bTel;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbCity() {
		return bCity;
	}

	public void setbCity(String bCity) {
		this.bCity = bCity;
	}

	public String getbJasan() {
		return bJasan;
	}

	public void setbJasan(String bJasan) {
		this.bJasan = bJasan;
	}

	public String getBeName() {
		return beName;
	}

	public void setBeName(String beName) {
		this.beName = beName;
	}

	public String getbOpen() {
		return bOpen;
	}

	public void setbOpen(String bOpen) {
		this.bOpen = bOpen;
	}

	public String getbTel() {
		return bTel;
	}

	public void setbTel(String bTel) {
		this.bTel = bTel;
	}
}
