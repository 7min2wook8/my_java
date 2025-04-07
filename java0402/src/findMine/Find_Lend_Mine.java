package findMine;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Container;

import java.awt.GridLayout;
import java.awt.Label;
import java.lang.Character;

public class Find_Lend_Mine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//findLend_1Line lend1 = new findLend_1Line();
		//findLend_3Line lend3 = new findLend_3Line();
		//FindBoom findBoom = new FindBoom();
		FindBoom2 findBoom2 = new FindBoom2(10,10);
		
	}
	
}

class FindBoom2 extends JFrame{
	
	
	ArrayList<Isboom> isbooms = new ArrayList<Isboom>();
	final char Boom = 'B';
	
	int row = 0;
	int col = 0;
	boolean isdead = false;
	
	int i = 0;
	int j = 0;
	public void myFrame(){
		setSize(800,900);
		setLocation(100, 100);		
		setVisible(true); // 먼저 보여줘야 getContentPane().getSize()가 정확함
		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(10, 10));
        
		Random randomValue = new Random();
		
		
		//버튼을 만들어서 		
		for (i = 0; i < row; i++) {
			for (j = 0; j < col; j++) {
				int index = i * row + j;
				
				if(randomValue.nextInt(2) == 1) {
					isbooms.add(new Isboom(true,index));
				}else {
					isbooms.add(new Isboom(false,index));
				}
				
				JButton btn = new JButton();
				
				btn.putClientProperty("index", index); // 버튼에 index 저장
				
				btn.addActionListener(e -> {
					
					JButton clickedBtn = (JButton) e.getSource();
		            int idx = (int) clickedBtn.getClientProperty("index");
					btn.setEnabled(false);
					
					Boolean isBoom = isbooms.get(idx).getBoom();
					//btn.setText(isbooms.get(index).getBoom() +"");
					
					if (isBoom) {
						System.out.println("You die");
						btn.setText("B");
						return;
					}
					
					checkBoom(idx);
					
					//주변 체크
				});
					
				
				pane.add(btn);
				
			}
		}
		
		
		
		pane.revalidate();
        pane.repaint();
		
	}
	private void checkBoom(int index) {
		if (index < 0 || index >= isbooms.size()) {
			return;
		}
		
		//왼쪽확인
		int cusor = index - 1;	
		if (cusor > -1 && isbooms.get(cusor).boom) {
			isdead = true;
			return;
		}
		
		//오른쪽 확인
		cusor = index + 1;
		if (cusor < isbooms.size() && isbooms.get(cusor).boom) {
			isdead = true;
			return;
		}
		
		//위확인
		cusor = index - row;	
		if (cusor > -1 && isbooms.get(cusor).boom) {
			isdead = true;
			return;
		}
	}
	
	
	
	public FindBoom2(int row,int col) {
		this.row = row;
		this.col = col;
		//SetMyArrays();
		myFrame();
		
	}

	
//	private void SetMyArrays() {
//		Random randomValue = new Random();
//		for (int i = 0; i < row; i++) {
//			
//			for (int j = 0; j < col; j++) {
//				//System.out.println(randomValue.nextInt(2));
//				//0~1.9999999... 사이의 숫자를 int형으로 변화 
//				if(randomValue.nextInt(2) == 1) {
//					isbooms.add(new Isboom('B',i,j));
//				}else {
//					isbooms.add(new Isboom('X',i,j));
//				}
//			}
//		}
//	}
	
}


class FindBoom{
	
	
	char[][] view_lend = 	{
			{'0','0','0','0','0','0','0','0','0','0'},
			{'0','0','0','0','0','0','0','0','0','0'},
			{'0','0','0','0','0','0','0','0','0','0'}
			};
	
	int[][] boom_lend = {
			{0,1,0,1,1,1,0,0,1,0},
			{1,0,0,0,1,1,0,0,1,1},
			{1,1,0,0,1,0,1,0,1,1}
			};
	
	ArrayList<SelectNum> selectNums = new ArrayList<SelectNum>();
	Scanner scanner = new Scanner(System.in);
	
	
	boolean isAlive = true;
	
	int leftNum = 0;
	int rightNum = 0;
	int topNum = 0;
	int bottomNum = 0;
	
	int boomCount = 0;
	
	public FindBoom(){
		while (isAlive) {
			
			view_Lend();
			System.out.printf("row 번호를 입력하세요. 0 ~ %s : ",(view_lend.length - 1));
			int row = scanner.nextInt();
			
			System.out.printf("col 번호를 입력하세요.0 ~ %s : ", (view_lend[0].length - 1));
			int col = scanner.nextInt();
		    if(CheckSelectNumbers(row, col)) {
		    	System.out.println("선택한 번호 입니다. 다시 선택해주세요.");
		    }else
		    	selectLend(row ,col);
		}
	}
	
	//일치하는게 하나라도 있으면 true, 없으면 false;
	private boolean CheckSelectNumbers(int row,int col) {
		
		for (int i = 0; i < selectNums.size(); i++) {
			if(selectNums.get(i).CheckNums(row, col)) {
				return true;				
			}
		}
		
		return false;
	}
	
	private void view_Lend() {
		for (int i = 0; i < view_lend.length; i++) {
			System.out.print("|");
			for (int j = 0; j < view_lend[i].length; j++) {
				System.out.print("\t" +view_lend[i][j]);
				System.out.print("\t|");
				
			}
			
			System.out.println();
		}
	}
	
	private void selectLend(int row ,int col) {
		
		if (boom_lend[row][col] == 1) {
			view_lend[row][col] = '1';
			view_Lend();
			System.out.println("you died");
			isAlive= false;
			
			return;
		}
		
		boomCount = 0;		
		leftNum = col-1;
		rightNum = col+1;
		topNum = row-1;
		bottomNum = row+1;
		
		//왼쪽 값 확인
		if (leftNum >= 0) {
			if(boom_lend[row][leftNum] > 0) {
				boomCount++;
			}
		}
		
		//오른쪽 값 확인
		if (rightNum < boom_lend[row].length) {
			if(boom_lend[row][rightNum] > 0) {
				boomCount++;
			}
		}
		
		//위 값 확인
		if (topNum >= 0) {
			if(boom_lend[topNum][col] > 0) {
				boomCount++;
			}
		}
		
		//아래 값 확인
		if (bottomNum < boom_lend.length) {
			if(boom_lend[bottomNum][col] > 0) {
				boomCount++;
			}
		}
		
		
		//좌상
		if (leftNum >= 0 && topNum >= 0) {
			if(boom_lend[topNum][leftNum] > 0) {
				boomCount++;
			}
			
		}
		
		//우상
		if (rightNum < boom_lend[row].length && topNum >= 0) {
			if(boom_lend[topNum][rightNum] > 0) {
				boomCount++;
			}
		}
		
		//좌하
		if (leftNum >= 0 && bottomNum < boom_lend.length) {
			if(boom_lend[bottomNum][leftNum] > 0) {
				boomCount++;
			}
		}
		
		//우하
		if (rightNum < boom_lend[row].length && bottomNum < boom_lend.length) {
			if(boom_lend[bottomNum][rightNum] > 0) {
				boomCount++;
			}
		}
			
		
		System.out.println("주변 폭탄 개수 : " + boomCount);
		view_lend[row][col] = Character.forDigit(boomCount, 10);
		boomCount = 0;
		selectNums.add(new SelectNum(row, col));
	}
}



class findLend_3Line{
	
	int[][] lend = 	{
					{0,1,0,1,1,1,0,0,1,0},
					{1,0,0,0,1,1,0,0,1,1},
					{1,1,0,0,1,0,1,0,1,1}
					};
	
	
	
	public findLend_3Line(){
		int boomCount = 0;
		//현재 위치를 기준으로 자신과 상하좌우, 대각선에 지뢰가 있으면 지뢰 개수 만큼로 변경
		//i 는 위 아레, j 는 좌우 판별
		for (int i = 0; i < lend.length; i++) {
			
			for (int j = 0; j < lend[i].length; j++) {
				
				//현재 위치 폭탄 판별
				if(lend[i][j] > 0) {
					boomCount++;
				}
				
				
				int leftNum = j-1;
				int rightNum = j+1;
				int topNum = i-1;
				int bottomNum = i+1;
				
				//왼쪽 값 확인
				if (leftNum >= 0) {
					if(lend[i][leftNum] > 0) {
						boomCount++;
					}
				}
				
				//오른쪽 값 확인
				if (rightNum < lend[i].length) {
					if(lend[i][rightNum] > 0) {
						boomCount++;
					}
				}
				
				//위 값 확인
				if (topNum >= 0) {
					if(lend[topNum][j] > 0) {
						boomCount++;
					}
				}
				
				//아래 값 확인
				if (bottomNum < lend.length) {
					if(lend[bottomNum][j] > 0) {
						boomCount++;
					}
				}
				
				
				//좌상
				if (leftNum >= 0 && topNum >= 0) {
					if(lend[topNum][leftNum] > 0) {
						boomCount++;
					}
					
				}
				
				//우상
				if (rightNum < lend[i].length && topNum >= 0) {
					if(lend[topNum][rightNum] > 0) {
						boomCount++;
					}
				}
				
				//좌하
				if (leftNum >= 0 && bottomNum < lend.length) {
					if(lend[bottomNum][leftNum] > 0) {
						boomCount++;
					}
				}
				
				//좌상
				if (rightNum < lend[i].length && bottomNum < lend.length) {
					if(lend[bottomNum][rightNum] > 0) {
						boomCount++;
					}
				}
				
				
				System.out.print(boomCount);
				boomCount = 0;
			}
			
			System.out.println();
		}
	}
	
}

class findLend_1Line {
	
	int[] lend = {0,1,0,1,1,1,0,0,1,0,1,0,0};
	int beforeLend = 0 ;
	
	
	public findLend_1Line(){
		//현제 위치를 기준으로 자신과 좌우에 지뢰가 있으면 지뢰 개수 만큼로 변경
		for (int i = 0; i < lend.length; i++) {
			int nowValue = lend[i];
			int nextNumber = i+1;
			int serch = 0;
			
			if (beforeLend > 0) {
				serch += 1;
			}
			
			if(nowValue > 0) {//
				serch += 1;
			}
			
			if (nextNumber != lend.length) {
				if (lend[nextNumber] > 0) {
					serch += 1;
				}
			}
			
			beforeLend = lend[i];
		
			System.out.print(serch);
		}
	}
	
}