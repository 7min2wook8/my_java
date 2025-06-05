package java0422_myImplements;

public class LgPrinterDrv implements Printable {
	
	public LgPrinterDrv() {
		System.out.println("LG 프린터 드라이버 동작");
	}
	
	@Override
	public void print(String doc) {
		// TODO Auto-generated method stub
		System.out.println(doc);
	}

}
