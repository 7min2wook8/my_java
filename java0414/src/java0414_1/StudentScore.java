package java0414_1;

public class StudentScore {
	String name = "";		
	int hap = 0;
	int avg = 0;
	int hakjum = 0;
	
	public StudentScore(String name, int hap, int avg, int hakjum) {
		super();
		this.name = name;
		this.hap = hap;
		this.avg = avg;
		this.hakjum = hakjum;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHap() {
		int _hap = hap + hap + hap;
		return _hap;
	}
	public void setHap(int hap) {
		this.hap = hap;
	}
	public double getAvg() {
		double _avg = (hap + hap + hap) / 3;
		
		return _avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public String getHakjum() {
		
		if (hakjum > 90) {
			return "A";
		}
		else if (hakjum > 80) {
			return "B";
		}
		else if (hakjum > 70) {
			return "C";
		}
		else if (hakjum > 60) {
			return "D";
		}
		else{
			return "F";
		}
		
	}
	public void setHakjum(int hakjum) {
		this.hakjum = hakjum;
	}
	
}
