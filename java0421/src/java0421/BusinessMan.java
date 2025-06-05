package java0421;

public class BusinessMan extends Man {
	String company;
	String position;
	
	
	public BusinessMan(String _company ,String _position) {
		
		company = _company;
		position = _position;
		
		// TODO Auto-generated constructor stub
	}
	public BusinessMan(String _name , String _company ,String _position) {
		super(_name);		
		company = _company;
		position = _position;
		
		// TODO Auto-generated constructor stub
	}

	public void tellYourInfo() {
		tellYourName();
		System.out.println("회사 : " + company);
		System.out.println("직위 : " + position);
		
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
}
