package com.lg.carApp;

import com.lg.carApp.Util.RandData;
import com.lg.carApp.car.Car;
import com.lg.carApp.customer.Customer;

public class CarAppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer[] customer = new Customer[10];
		//System.out.println(customer[0]);
		for (int i = 0; i < customer.length; i++) {
			customer[i] = new Customer();
			customer[i].setName(RandData.getName());
			customer[i].setMyCar(new Car(RandData.getModel(),RandData.getColor(),RandData.getYear(),RandData.getCompany()));
			customer[i].setAddress(RandData.getAddress());
			customer[i].setTel(RandData.getTel());
			
			customer[i].ShowInfo();
		}
		
	}
//https://blog.naver.com/hack4ork/221670752134 자료 주소
}
