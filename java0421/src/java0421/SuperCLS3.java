package java0421;

public class SuperCLS3 extends SuperCLS2 {

	
	public SuperCLS3() {
		System.out.println("SuperCLS3 기본 생성자");
	}
	
	public void SuperCLS(int i) {
		
		System.out.printf("SuperCLS3 생성자 %d\n",i);
	}
	
	public void SuperCLS(int i, int j) {
		
		System.out.printf("SuperCLS3 생성자 %d, %d\n",i,j);
	}

}
