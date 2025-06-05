package java0421;

public class Student extends Man {
	private String school;
	private String year;
	
	
	public Student(String school, String year) {
		super();
		this.school = school;
		this.year = year;
	}

	//오버라이딩 부모의 메소드를 자식 클래스에서 재정의
	//@ : 어노테이션 : 컴파일러에게 보다 정확한 정보를 전달
	@Override
	public void tellYourName() {
		// TODO Auto-generated method stub
		super.tellYourName();
		System.out.println("학교" + school);
		System.out.println("학년 : " + year);
	}



	public void tellYourInfo() {
		
	}
}
