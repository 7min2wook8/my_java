package java0422_myGenerics;

public class myGenerics2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBox<String,Integer> box = new DBox<>();
		
		box.setLR("사과", 30);
		System.out.println(box);
	}

}

class DBox<L, R>{
	
	private L left;
	private R right;
	
	public void setLR(L left, R right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return left + ":::" + right;
	}
	
	
	
}
