package myPretice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



class monster1{
	
	private int hp = 100;
	private int x = 200, y = 300;
	
	private final int SPEED = 2;   // 이동 속도
   
	private final int GRAVITY = 2; // 중력 효과
    private int velocityY = 0; // 수직 속도 (점프 포함)
    
    private boolean isOnGround = false; // 바닥에 있는지 여부
    private boolean isJumping = false;  // 점프 중인지 여부  
    
    
    public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void leftMove() {
		x -= SPEED;
	}
	
	public void rightMove() {
		x += SPEED;
	}

	public void idle() {
		// TODO Auto-generated method stub
		
	}
	

	
}

public class GravityGame extends JPanel {
    private int x = 100, y = 100;  // 점 위치
    private final int SPEED = 5;   // 이동 속도
    private final int GRAVITY = 2; // 중력 효과
    private final int FLOOR_Y = 300; // 바닥 Y 좌표
    private int velocityY = 0; // 수직 속도 (점프 포함)
    private boolean isOnGround = false; // 바닥에 있는지 여부
    private boolean isJumping = false;  // 점프 중인지 여부    
    private final int MAX_JUMP_CHARGE = 20; // 최대 점프 충전량
    private int addJump = 0; // 수직 속도 (점프 포함)
    private final Set<Integer> pressedKeys = new HashSet<>();
    private Timer timer;

    //캐릭터가 보고있는 방향 1 오른쪽, -1 왼쪽
    private int direction = 1;
    
    
    ArrayList<monster1> monsters = new ArrayList();
    
    
    
    //사용자를 좆아오는 오브젝트 생성
    private void responeMoster() {
    	
    	monsters.add(new monster1());
    }
    
    public GravityGame() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
        	
            @Override
            public void keyPressed(KeyEvent e) {
                pressedKeys.add(e.getKeyCode());
                
                if(e.getKeyCode() == KeyEvent.VK_R) {
                	
                	responeMoster();
                }
                
                // 점프 (바닥에 있을 때만 가능)
                if (e.getKeyCode() == KeyEvent.VK_SPACE && isOnGround) {
                	velocityY = -15; // 위로 점프
                    isJumping = true;
                    isOnGround = false;
                    
                }
                
            }
            
            //키보드에서 때면
            @Override
            public void keyReleased(KeyEvent e) {
                pressedKeys.remove(e.getKeyCode());
                isJumping = false;
            }
        });

        // 16ms마다 화면 업데이트 (약 60FPS)
        timer = new Timer(16, e -> {
            move();
            attack();
            applyGravity();            
            repaint();
            monsterMove();
        });
        timer.start();
    }

    private void monsterMove() {
		// TODO Auto-generated method stub
    	for (int i = 0; i < monsters.size(); i++) {
    		int mosterX = monsters.get(i).getX();
    		if (x < mosterX) {
    			monsters.get(i).leftMove();
			}
    		else if(x > mosterX) {
    			monsters.get(i).rightMove();
    		}
    		else
    			monsters.get(i).idle();
    		
		}
	}

	private void move() {
        if (pressedKeys.contains(KeyEvent.VK_LEFT)) { 
        	x -= SPEED;
        	direction = -1;
        }
        if (pressedKeys.contains(KeyEvent.VK_RIGHT)) { 
        	x += SPEED;
        	direction = 1;
        }
        
        //점프 중이면서 땅위가 아니면
        if(isJumping && !isOnGround && addJump < MAX_JUMP_CHARGE) {
        	velocityY -= GRAVITY-1;
        	addJump++;
        }
    }
    
    
    private void attack() {
    	
    	if (pressedKeys.contains(KeyEvent.VK_Z)) {
    		if(direction == 1) {
    			x += (SPEED*5);
    		}else {
    			x -= (SPEED*5);
    		}
    	}
    }

    private void applyGravity() {
        // 중력 적용 (아래로 가속)
        velocityY += GRAVITY;
        y += velocityY;

        // 바닥 충돌 감지
        if (y >= FLOOR_Y) {
            y = FLOOR_Y; // 바닥에 닿으면 위치 고정
            velocityY = 0;
            isOnGround = true;
            isJumping = false;
            addJump = 0;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(x, y, 20, 20); // 캐릭터
        g.setColor(Color.BLACK);
        g.fillRect(0, FLOOR_Y + 20, getWidth(), 20); // 바닥
        
        for(int i = 0; i < monsters.size(); i++) {
        	g.fillOval(monsters.get(i).getX(), monsters.get(i).getY(), 20, 20); // 몬스터
            g.setColor(Color.red);
        }
        
        
        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gravity Game");
        GravityGame panel = new GravityGame();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}