package findMine;

public class Isboom {
	int index = 0;
	
	boolean boom = false;
	
	public Isboom(boolean boom, int index){
		this.boom = boom;
		this.index = index;
	}

	public boolean getBoom() {
		return boom;
	}

	public void setBoom(boolean boom) {
		this.boom = boom;
	}
	
}
