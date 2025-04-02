package java0402;

public class hellowold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello World");
		}
		System.out.println();
		Car car = new Car(0, "자바 ㅎㅎ", 200);
		Car car2 = new Car(0, "자바 ㅎㅎ;; ㅋㅋ;;", 200);
		System.out.println(car.toString());
		System.out.println(car2.toString());
		System.out.println(car.oil());
	}

}


