package java0421;

public class Man {
	private String name;
	
	
	public Man() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Man(String name) {
		super();
		// TODO Auto-generated constructor stub
		this.name = name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void tellYourName() {
		System.out.println("My name is " + name);
	}
}
