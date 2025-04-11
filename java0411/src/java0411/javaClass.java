package java0411;

public class javaClass {
	public void myStart() {
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(Person.CITY);
		// TODO Auto-generated method stub
		Person person0 = new Person("홍길동",380,"010-0000-0000","hong@naver.com");
		Person person1 = new Person("전우치",350,"010-1111-1111","jhen@naver.com");
		Person person2 = new Person("박혁거세",2000,"010-2222-2222","birthEgg@naver.com");
		Person person3 = new Person("이방원",500,"010-3333-3333","yeeBang1@naver.com");
		Person person4 = new Person("유재석",56,"010-4444-4444","youJeStone@naver.com");
		Person person5 = new Person("이광수",37,"010-5555-5555","yeeRightWalter@naver.com");
		
		
		person0.ShowInfo();
		person1.ShowInfo();
		person2.ShowInfo();
		person3.ShowInfo();
		person4.ShowInfo();
		person5.ShowInfo();
		
	
		
//		System.out.println(person0.toString());
//		System.out.println(person1.toString());
//		System.out.println(person2.toString());
//		System.out.println(person3.toString());
//		System.out.println(person4.toString());
//		System.out.println(person5.toString());
		
		
		
	}

}
