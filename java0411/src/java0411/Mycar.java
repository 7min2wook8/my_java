package java0411;

public class Mycar {
	public static final String TITLE ="동대구 영업소";	

	private String createCom = "";
	private String carColor = "";
	private int price = 0;
	private String modelName = "";
		
	public Mycar() {
		super();
		this.createCom = "기아";
		this.carColor = "블랙";
		this.price = 4500;
		this.modelName = "k7";
	}
	
	public Mycar(String createCom, String carColor, int price, String modelName) {
		super();
		this.createCom = createCom;
		this.carColor = carColor;
		this.price = price;
		this.modelName = modelName;
	}
	
	
	public String getCreateCom() {
		return createCom;
	}
	public void setCreateCom(String createCom) {
		this.createCom = createCom;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	
	public void showInfo() {
		System.out.printf("제조사 - %s \t| 색상 - %s \t| 이름 - %s \t| 가격 - %d만원 \t|",createCom,carColor, modelName,price);
		System.out.println();
	}
	
}
