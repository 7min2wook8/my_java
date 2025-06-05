package java0421_2;

public class Friend {

	protected String name;
	protected String tel;
	
	public Friend(String name, String tel) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void ShowInfo() {
		System.out.println("name : " + name);
		System.out.println("tel : " + tel);
	}
	
}
