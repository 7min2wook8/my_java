package findMine;

import java.awt.Color;

import javax.swing.JButton;

enum BlockState {
    HIDDEN,			//숨겨진
    OPENED,			//열린
    FLAGGED			//유저 표시
}

public class Isboom {
	int index = 0;
	
	public Isboom(String boom, JButton btn){
		this.boom = boom;
		this.btn = btn;
	}
	
	public Isboom(boolean b, int index2) {
		// TODO Auto-generated constructor stub
	}

	String boom = "B";
	public String getBoom() {
		return boom;
	}
	
	
	BlockState state = BlockState.HIDDEN;
	public BlockState getState() {
		return state;
	}

	public void setState(BlockState state) {
		this.state = state;
	}

	JButton btn = null;
	public JButton getBtn() {
		return btn;
	}
	
	public void setBtn(JButton btn) {
		this.btn = btn;
	}
	
	//boolean isCheck = false;//체크 안하면 false, 체크하면 true;
	

	
	//boom의 값을 보고 이벤트 실행
	public boolean checkBoom() {
		
		if (boom == "B") {
			btn.setText("💣");
			btn.setBackground(Color.red);
			btn.setEnabled(false);
			return true;
		}
		
		return false;
		

	
	}
}