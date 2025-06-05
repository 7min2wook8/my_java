package java0422_myAbstract;

public class TestMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		House house = new MyHouse();
		house.build();
		house.clean();
		
		//추상클래스는 객체 생성이 불가능!!!
		//House house2 = new House(); 불가능
	}

}

//추상클래스
abstract class House{
	public void build() {
		System.out.println("집을 짓는다.");
	}
	
	//추상클래스 정의
	public abstract void clean();
	
}

//부모의 추상클래스를 무조건 오버라이드(재정의) 해야함
class MyHouse extends House{

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		System.out.println("집을 청소한다.");
	}
	
}