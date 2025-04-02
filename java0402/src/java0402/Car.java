package java0402;

public class Car {
	int number;
	String carName;
	float maxSpeed;
	
	public String oil() {
		
		return "기름이다 개쉣기야";
		
	}
	
	
	@Override
	public String toString() {
		return "Car [number=" + number + ", carName=" + carName + ", maxSpeed=" + maxSpeed + "]";
	}

	
	public Car(int number, String carName, float maxSpeed) {
		super();
		this.number = number;
		this.carName = carName;
		this.maxSpeed = maxSpeed;
	}

	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getCarName() {
		return carName;
	}


	public void setCarName(String carName) {
		this.carName = carName;
	}


	public float getMaxSpeed() {
		return maxSpeed;
	}


	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	

}
