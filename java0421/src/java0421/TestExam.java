package java0421;

public class TestExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SuperObj a = new SubObj();
		a.paint();
		a.draw();
	}

}

class SuperObj{
	
	public void draw() {
		System.out.println("A");
		draw();
	}
	
	public void paint() {
		System.out.println("B");
		this.draw();//오버라이딩 되어있을 경우 자식의 draw 호출
	}
	
}


class SubObj extends SuperObj{
	
	public void paint() {
		super.paint();
		System.out.println("C");
		draw();
	}
	
	public void draw() {
		System.out.println("D");
	}
	
}