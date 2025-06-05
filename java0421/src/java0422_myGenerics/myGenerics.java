package java0422_myGenerics;

public class myGenerics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box<Apple> apple = new Box<>();
		apple.setObj(new Apple());
		System.out.println(apple.getObj());
		
		Box<Orange> orange = new Box<>();
		orange.setObj(new Orange());
		System.out.println(orange.getObj());
	}

}

//제네릭 클래스 :
//1. 클래스 내부에 사용할 데이터 타입을 외부에서 결정
//2. 클래스의 범용성을 유지하고 특정 데이터 형식과 관련 없는 작업을 캡슐화
class Box<T>{
	
	private T obj;
	
	public T getObj() {
		return obj;
		
	}
	
	public void setObj(T obj) {
		
		this.obj = obj;
	}
	
}

class Apple{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "사과";
	}
	
}


class Orange{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "오렌지";
	}
	
}
