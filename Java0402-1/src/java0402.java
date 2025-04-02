
public class java0402 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name1 = "홍길동";
		String str1 = "안녕하세요";
		
		String msg1 = String.format("%s님 %s", name1, str1 );
		
		System.out.println(msg1);
		
		
		//2. StringBuilder
		String name2 = "전우치";
		String str2 = "안녕하세요";
		
		StringBuilder stb = new StringBuilder(name2).append("님, ").append(str2);
		System.out.println(stb);
	}

}
