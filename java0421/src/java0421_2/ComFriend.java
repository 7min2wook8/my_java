package java0421_2;

public class ComFriend extends Friend {
	private String department;
	
	public ComFriend(String name, String tel, String department) {
		super(name, tel);
		this.department = department;
		// TODO Auto-generated constructor stub
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public void ShowInfo() {
		// TODO Auto-generated method stub
		super.ShowInfo();
		System.out.println("부서 : " + department);
	}

	
	
}
