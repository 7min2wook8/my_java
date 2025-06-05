package com.lg.carApp.car;

import java.awt.Color;

public class Car {
	String modelName = "";
	String carColor = "";
	int year = 2000;
	String company = "";
	
	
	
	public Car() {
		super();
		
		this.modelName = "재네식스";
		this.carColor = "검정";
		this.year = 2016;
		this.company = "현대";
	}
	
	
	public Car(String modelName, String carColor, int year, String company) {
		super();
		this.modelName = modelName;
		this.carColor = carColor;
		this.year = year;
		this.company = company;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public void showCar() {
		System.out.println("모델 : " + getModelName());
		System.out.println("색상 : " + getCarColor());
		System.out.println("연식 : " + getYear());
		System.out.println("회사명 : " + getCompany());
	}
}
