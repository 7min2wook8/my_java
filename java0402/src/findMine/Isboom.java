package findMine;

import javax.swing.JButton;

public class Isboom {
	
	String boom = "B";
	JButton btn = null;
	

	boolean isCheck = false;//체크 안하면 false, 체크하면 true;
	
	public JButton getBtn() {
		return btn;
	}
	
	public void setBtn(JButton btn) {
		this.btn = btn;
	}
	
	public Isboom(String boom, JButton btn){
		this.boom = boom;
		this.btn = btn;
	}
	
	public boolean isCheck() {
		return isCheck;
	}

	public void setEnable(boolean isEnable) {
		this.isCheck = isEnable;
	}

	public String getBoom() {
		return boom;
	}

	public void setBoom(String boom) {
		this.boom = boom;
	}
	
}
