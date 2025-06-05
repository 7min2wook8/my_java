package java0421;

public class SuperCLS2 extends SuperCLS1 {

	
	public SuperCLS2() {
		System.out.println("SuperCLS2 기본 생성자");
	}
	
	public void SuperCLS(int i) {
		
		System.out.printf("SuperCLS2 생성자 %d\n",i);
	}
	
	public void SuperCLS(int i, int j) {
		
		System.out.printf("SuperCLS2 생성자 %d, %d\n",i,j);
	}
}
