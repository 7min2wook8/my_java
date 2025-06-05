package com.java0414_2.Student;

public class StudenMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Student[] ssArr = new Student[10];
		
		
		
		for (int i = 0; i < ssArr.length; i++) {
			ssArr[i] = new Student(
					RendData.getRandName(), 
					RendData.getRandAge(), 
					RendData.getRandgender(), 
					RendData.getRandAdress());
			
			ssArr[i].ShowStudentInfo(i);
			
		}
		
		
		
		Student lastChild = ssArr[ssArr.length-1];
		lastChild.setName("전우치");
		lastChild.setAge(24);
		lastChild.setGender('남');
		lastChild.setAddr("조선 한양 인근 두메골");
		
		lastChild.ShowStudentInfo();
		
		
		
	}

}
