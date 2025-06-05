package java0422_myImplements;

public class SprinterDrv implements Printable {

	public SprinterDrv() {
		System.out.println("삼성 프린터 드라이버 동작");
	}
	
	@Override
	public void print(String doc) {
		System.out.println(doc);

	}

}
