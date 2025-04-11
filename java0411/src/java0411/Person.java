package java0411;

public class Person {
	
	
	private String name;
	private int age;
	private String tel;
	private String eMail;
	
	public Person(String name, int age, String tel, String eMail) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.eMail = eMail;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", tel=" + tel + ", eMail=" + eMail + "]";
	}
	
	public void ShowInfo() {
		
		System.out.printf("이름 : %s \t| 나이 : %d \t| 전화번호 %s \t| 이메일 : %s",name,age,tel,eMail);
		System.out.println();
	}
}
