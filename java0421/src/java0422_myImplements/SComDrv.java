package java0422_myImplements;

public class SComDrv extends SprinterDrv implements ColorPrintable {

	public SComDrv() {
		System.out.println("삼성 복합기 드라이버 동작");
	}

	@Override
	public void printCMYK(String doc) {
		// TODO Auto-generated method stub
		System.out.println("컬러출력 : " + doc);
	}

	@Override
	public void print(String doc) {
		// TODO Auto-generated method stub
		System.out.println("흑백출력 : " + doc);
	}
	
//	@Override
//	public void print(String doc) {
//		// TODO Auto-generated method stub
//		System.out.println("흑백출력 : " + doc);
//	}
//
//	@Override
//	public void printCMYK(String doc) {
//		// TODO Auto-generated method stub
//		System.out.println("컬러출력 : " + doc);
//
//	}

}
