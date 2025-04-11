package findMine;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.Component;
=======
>>>>>>> parent of 310e8a86 (qew)
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Character;


public class Find_Lend_Mine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//findLend_1Line lend1 = new findLend_1Line();
		//findLend_3Line lend3 = new findLend_3Line();
		//FindBoom findBoom = new FindBoom();
		//FindBoom2 findBoom2 = new FindBoom2(10,10);
		
		SwingUtilities.invokeLater(() -> new FindBoomTitle2());
		
	}
	
}


class FindBoomTitle2 extends JFrame{
	
	public FindBoomTitle2(){
		setTitle("🔥 Find the Mine 🔥");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 화면 중앙 정렬
        setResizable(false);

        // 메인 패널
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // 게임 제목
        JLabel titleLabel = new JLabel("Find The Mine");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        titleLabel.setForeground(Color.black);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 시작 버튼
        JButton startButton = new JButton("게임 시작");
        startButton.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setFocusPainted(false);

        // 종료 버튼
        JButton exitButton = new JButton("게임 종료");
        exitButton.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setFocusPainted(false);

        // 버튼 간격
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 60)));
        mainPanel.add(startButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(exitButton);

        add(mainPanel);
        setVisible(true);

        // 버튼 액션
        startButton.addActionListener(e -> {
            // 여기서 게임 화면으로 전환하면 됩니다
            System.out.println("게임 시작!");
            dispose(); // 타이틀 화면 닫기

            // 예: FindBoom2 game = new FindBoom2(10, 10);
            new FindBoom2(10, 10); 
        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });
	}
}

class FindBoom2 extends JFrame{
	
	
	ArrayList<Isboom> isbooms = new ArrayList<Isboom>();
	final char Boom = 'B';
	
	int row = 0;
	int col = 0;
	boolean isdead = false;
	
<<<<<<< HEAD
	int maxBoom = 10;	//폭탄 개수
	int totalBlock = 0;	//총 블럭 개수
	int openBlock = 0;	//열린 블럭 개수
    
=======
	int i = 0;
	int j = 0;
>>>>>>> parent of 310e8a86 (qew)
	public void myFrame(){
		setTitle("🔥 Find the Mine 🔥");
		setSize(500,600);
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
<<<<<<< HEAD
				isbooms.get(index).setBtn(btn);			//리스트에 버튼 지정
				
				btn.addActionListener(e -> {
					
					if (isdead) {
						return;
					}
					
					JButton clickedBtn = (JButton) e.getSource();
		            int idx = (int) clickedBtn.getClientProperty("index");//버튼에 저장된 인덱스값 저장
					
		            //선택한 버튼이 폭탄이면 모든 버튼 비활성화, 폭탄은 붉은색으로 변경
		            if (isbooms.get(idx).checkBoom()) {
		            	System.out.println("주금");
		            	GameEnd(false);
		    			return;
		    		}
		            //선택한 버튼 주변에 관한 이벤트 실행
		            //폭탄이 주변에 있으면 폭탄수를 표시
		            //폭탄이 없으면
					SelectBtn(idx);
					
					//다 찾으면 게임 끝냄
					if (openBlock == totalBlock - maxBoom) {
						System.out.println("다 찾음!!!");
						GameEnd(true);
=======
				
				btn.addActionListener(e -> {
					
					JButton clickedBtn = (JButton) e.getSource();
		            int idx = (int) clickedBtn.getClientProperty("index");
					btn.setEnabled(false);
					
					Boolean isBoom = isbooms.get(idx).getBoom();
					//btn.setText(isbooms.get(index).getBoom() +"");
					
					if (isBoom) {
						System.out.println("You die");
						btn.setText("B");
>>>>>>> parent of 310e8a86 (qew)
						return;
					}
					
					checkBoom(idx);
					
					//주변 체크
				});
				
				
				btn.addMouseListener(new MouseAdapter() {
					
<<<<<<< HEAD
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        if (SwingUtilities.isRightMouseButton(e)) {
				        	if (isdead) {
								return;
							}
				            // 여기에 원하는 기능 넣기 (예: 깃발 표시)
				            
							JButton clickedBtn = (JButton) e.getSource();
				            int idx = (int) clickedBtn.getClientProperty("index");//버튼에 저장된 인덱스값 저장
							
				            //열리지 않은 버튼을 오른쪽 클릭시 X표시
				            if (isbooms.get(idx).getState() == BlockState.HIDDEN) {
				            	//System.out.println("우클릭");
				            	clickedBtn.setText("X");
				            	isbooms.get(idx).setState(BlockState.FLAGGED);
				            	return;
				            	
				            //깃발표시인 것을 오른쪽 클릭하면 다시 숨긴걸로 표시
				            }else if (isbooms.get(idx).getState() == BlockState.FLAGGED) {
				            	clickedBtn.setText("");
				            	isbooms.get(idx).setState(BlockState.HIDDEN);
				            	return;
							}
				        }
				    }
				});
				
=======
>>>>>>> parent of 310e8a86 (qew)
				
				pane.add(btn);
				
			}
		}
		
<<<<<<< HEAD
		pane.revalidate(); //변경된 좌표를 다시 계산해서 표시하는 메소드이다.
        pane.repaint();
		
	}
	
	private void GameEnd(boolean isVictory) {
		
		for (int k = 0; k < isbooms.size(); k++) {
			
			isbooms.get(k).checkBoom();
				
		}
		isdead = true;
		
		JLabel resultLabel = new JLabel("", SwingConstants.CENTER);
		
		resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		resultLabel.setForeground(Color.RED);
		resultLabel.setOpaque(true);			//바탕 보이기 설정
		resultLabel.setBackground(Color.white);
		resultLabel.setVisible(true);

		// 프레임에 오버레이처럼 붙이기 (레이아웃에 따라 조절 필요)
		getLayeredPane().add(resultLabel, JLayeredPane.PALETTE_LAYER);
		resultLabel.setBounds(0, 300, 500, 100);  // 위치와 크기 조절
		
		if (isVictory) {
			
			resultLabel.setText("승리! 모든 지뢰를 찾았습니다!");
			resultLabel.setVisible(true);
		
		}else {
			
			resultLabel.setText("게임 오버! 지뢰를 밟았습니다!");
			resultLabel.setVisible(true);
		
		}
		
		JButton restartButton = new JButton("다시 시작");
		restartButton.setFont(new Font("맑은 고딕", Font.BOLD, 24));
		restartButton.setBackground(Color.LIGHT_GRAY);
		restartButton.setFocusPainted(true);	//버튼 테두리 설정
		restartButton.setBounds(150, 400, 200, 60); // 위치 조절
		restartButton.setVisible(true); 

		getLayeredPane().add(restartButton, JLayeredPane.PALETTE_LAYER);
		restartButton.addActionListener(e -> {
		    dispose(); // 현재 창 닫기
		    new FindBoom2(row, col); // 새 게임 시작
		});

//		if (isVictory) {
//			JOptionPane.showMessageDialog(this, "게임 종료! 승리했습니다! 🎉");
//		}else {
//			JOptionPane.showMessageDialog(this, "게임 종료! 패배했습니다!");
//		}
		
        

	}
	
	
	private void SelectBtn(int idx) {
		
		//체크한건 넘어가라
        if (isbooms.get(idx).getState() == BlockState.OPENED){
			return;
		}
        
        isbooms.get(idx).getBtn().setEnabled(false);//버튼 비활성화
        isbooms.get(idx).setState(BlockState.OPENED);;			//선택됨
        openBlock++;
       
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
                    SelectBtn(neighborIdx);
                }
            }
		}else {//폭탄이 주변에 있으면 폭탄수 표시
			isbooms.get(idx).getBtn().setText(boomCount+"");
			isbooms.get(idx).getBtn().setEnabled(false);
		}
        
        
        //System.out.println("인덱스 번호 좌표 : " + idx);
=======
		
		
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
>>>>>>> parent of 310e8a86 (qew)
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