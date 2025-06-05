package com.kb.model;

public class Branch {
	
	private String bName;		
	private String bCity;
	private String bJasan;
	private String bEname;
	private String bOpen;
	private String bTel;
	
	
	
	public Branch(String bName, String bCity, String bJasan, String bEname, String bOpen, String bTel) {
		super();
		this.bName = bName;
		this.bCity = bCity;
		this.bJasan = bJasan;
		this.bEname = bEname;
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
	public String getbEname() {
		return bEname;
	}
	public void setbEname(String bEname) {
		this.bEname = bEname;
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
