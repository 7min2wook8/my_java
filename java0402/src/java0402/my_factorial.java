package java0402;

public class my_factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 factorial(10);
	}
	
	
	public static int factorial(int num) {
		if (num == 1) {
			System.out.print(num);
			return 0;
		}
		System.out.print(num+"x");
		return factorial(num - 1);
	}
}
