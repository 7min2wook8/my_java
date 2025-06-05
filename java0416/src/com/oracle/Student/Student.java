package com.oracle.Student;


public class Student {

	private String sno;		// 학번
	private String name;	// 이름
	private String tel;		// 전화
	private String major;	// 과목
	
	public Student(String sno, String name, 
		String tel, String major) {
		super();
		this.sno = sno;
		this.name = name;
		this.tel = tel;
		this.major = major;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
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

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	

}
