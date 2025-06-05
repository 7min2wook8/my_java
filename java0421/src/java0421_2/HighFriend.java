package java0421_2;

public class HighFriend extends Friend {
	private String myClass;

	
	
	
	public HighFriend(String name, String tel, String myClass) {
		super(name, tel);
		// TODO Auto-generated constructor stub
		this.myClass = myClass;
	}

	public String getMyClass() {
		return myClass;
	}

	public void setMyClass(String myClass) {
		this.myClass = myClass;
	}

	@Override
	public void ShowInfo() {
		// TODO Auto-generated method stub
		super.ShowInfo();
		
		System.out.println("학급 : " + myClass);
	}
	
	
	
}
