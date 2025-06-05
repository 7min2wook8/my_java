package com.lg.carApp.customer;

import com.lg.carApp.car.Car;

public class Customer {
	String name;
	String tel;
	String address;
	Car myCar;
	

	public Customer() {
		super();
		this.name = "홍길동";
		this.tel = "010-0000-0000";
		this.address = "대한민국";
		this.myCar = new Car();
	}

	public Customer(String name, String tel, String address, Car myCar) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.myCar = myCar;
	}
	
	public Car getMyCar() {
		return myCar;
	}
	public void setMyCar(Car myCar) {
		this.myCar = myCar;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public void ShowInfo() {
		// TODO Auto-generated method stub
		
		System.out.println("고객 이름 : " + getName());
		System.out.println("고객 전화번호 : " + getTel());
		System.out.println("고객 주소 : " + getAddress());
		System.out.println("고객 차량 정보 : "); 
		getMyCar().showCar();
		
		System.out.println("---------------------------------------------------------------");
		
	}
	
}
