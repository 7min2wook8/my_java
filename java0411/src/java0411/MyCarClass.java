package java0411;

public class MyCarClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mycar Mycar1 = new Mycar();
		Mycar Mycar2 = new Mycar("현대","빨강",5000,"아이오닉6");
		Mycar Mycar3 = new Mycar("제네시스","블루",3000,"G90");
		
		System.out.println(Mycar1.TITLE);
		
		Mycar1.showInfo();
		Mycar2.showInfo();
		Mycar3.showInfo();
		
		Mycar2.setCarColor("코토리베이지");
		Mycar2.setPrice(5500);
		Mycar2.showInfo();
	}

}
