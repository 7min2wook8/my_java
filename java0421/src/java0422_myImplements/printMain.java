package java0422_myImplements;

public class printMain {
	public static void main(String[] args) {
		String doc = "리포트 출력중...";
		
		Printable p1 = new LgPrinterDrv();
		p1.print(doc);		
		System.out.println("=================================");
		
		
		Printable p2 = new SprinterDrv();
		p2.print(doc);
		System.out.println("=================================");
		
		
		ColorPrintable p3 = new SComDrv();
		p3.printCMYK(doc);
		System.out.println("=================================");
		
	}
}
