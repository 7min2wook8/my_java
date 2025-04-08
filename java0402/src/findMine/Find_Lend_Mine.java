package findMine;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
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
	
	
    final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};//선택한 버튼 주변 위치 좌표 지정
    final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	ArrayList<Isboom> isbooms = new ArrayList<Isboom>();
	Isboom selectCusorIsboom = null;
	
	
	int row = 0;
	int col = 0;
	boolean isdead = false;
	boolean isEnd = false;
	int maxBoom = 10;	//폭탄 개수
	int totalBlock = 0;	//총 블럭 개수
	int openBlock = 0;	//열린 블럭 개수
    
	public void myFrame(){
		setSize(800,900);
		setLocation(100, 100);		
		setVisible(true); // 먼저 보여줘야 getContentPane().getSize()가 정확함
		
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(10, 10));
		
		totalBlock = row * col;
		for (int i = 0; i < totalBlock; i++) {//10개  폭탄을 먼저 생성, btn이 지정되지않은 리스트 추가
			if (i < maxBoom) {
				isbooms.add(new Isboom("B",null));
			}else {
				isbooms.add(new Isboom("",null));
			}
			
		}
		
		Collections.shuffle(isbooms);		//리스트를 무작위로 섞음 서플
		
		
		//버튼을 만들어서 		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int index = i * row + j;//선택하는 버튼의 index값
				
				JButton btn = new JButton();
				
				btn.putClientProperty("index", index); // 버튼에 index 저장
				isbooms.get(index).setBtn(btn);
				
				btn.addActionListener(e -> {
					
					if (isdead) {
						System.out.println("주금");
						return;
					}else if(isEnd) {
						
					}
					
					
					JButton clickedBtn = (JButton) e.getSource();
		            int idx = (int) clickedBtn.getClientProperty("index");//버튼에 저장된 인덱스값 저장
					
		            //선택한 버튼이 폭탄이면 모든 버튼 비활성화, 폭탄은 붉은색으로 변경
		            if (isbooms.get(idx).getBoom() == "B") {
		    			//System.out.println("You die");	
		    			
		    			for (int k = 0; k < isbooms.size(); k++) {
		    				
		    				if (isbooms.get(k).getBoom() == "B") {
		    					isbooms.get(k).getBtn().setText("💣");
		    					isbooms.get(k).getBtn().setBackground(Color.red);
		    					isbooms.get(k).getBtn().setEnabled(false);
		    				}
		    				
		    			}
		    			isdead = true;
		    			return;
		    		}
		            
		            
					SelectBtn(idx);
					btn.setEnabled(false);
					

					
					System.out.println("열린 버튼 개수 : " + openBlock);
					
					if (openBlock == totalBlock - maxBoom) {
						System.out.println("다 찾음!!!");
						isEnd = true;
						return;
					}
					
				});
					
				pane.add(btn);
				
			}
		}
		
		pane.revalidate();
        pane.repaint();
		
	}
	
	private void SelectBtn(int idx) {
		int boomCount = 0;
		
		int x = idx / col;	//
        int y = idx % col;	//몇번째 줄인지 확인 
        
        //final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};//선택한 버튼 주변 위치 좌표 지정
        //final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        //주변 폭탄체크
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < row && ny < col) {
                int neighborIdx = nx * col + ny;
                
                if (isbooms.get(neighborIdx).getBoom() == "B") {
					boomCount++;
				}
            }
        }
        
        //만약 주변에 폭탄이 없으면, 버튼 비활성화  
        if (boomCount == 0) {
        	for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < row && ny < col) {
                    int neighborIdx = nx * col + ny;
                    
                    //체크한건 넘어가라
                    if (isbooms.get(neighborIdx).isCheck) {
						continue;
					}
                    
                    isbooms.get(neighborIdx).getBtn().setEnabled(false);
                    isbooms.get(neighborIdx).setEnable(true);
                    SelectBtn(neighborIdx);
                }
            }
		}else {//폭탄이 주변에 있으면 폭탄수 표시
			isbooms.get(idx).getBtn().setText(boomCount+"");
			isbooms.get(idx).getBtn().setEnabled(false);
		}
        
        openBlock++;
        System.out.println("인덱스 번호 좌표 : " + idx);
	}

	public FindBoom2(int row,int col) {
		this.row = row;
		this.col = col;
		
		myFrame();
		
	}

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