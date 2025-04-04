package myPretice;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GravityGame extends JPanel {
	
	private int hp = 300;
    private int x = 100, y = 100;  // 점 위치
    private int velocityY = 0; // 수직 속도 (점프 포함)
    private int addJump = 0; // 수직 속도 (점프 포함)
  
    
    
    private boolean isOnGround = false; // 바닥에 있는지 여부
    private boolean isJumping = false;  // 점프 중인지 여부   
    private boolean isHit = false;
    
    private final int SPEED = 5;   // 이동 속도
    private final int GRAVITY = 2; // 중력 효과
    private final int FLOOR_Y = 300; // 바닥 Y 좌표
    private final int hitDeley = 300; // 피격 딜레이
    
    
    
    private final int MAX_JUMP_CHARGE = 20; // 추가 점프 최대 높이
    
    private final Set<Integer> pressedKeys = new HashSet<>();
    private Timer timer;

    //캐릭터가 보고있는 방향 1 오른쪽, -1 왼쪽
    private int direction = 1;
    private boolean isAttack = false;
    
    
    private long hitStartTime = 0;//피격 시작 시간
    private long hitNowTime = 0;//피격되고 지나간 시간
    
    private long attackStartTime = 0;//공격 시작 시간
    private long attackNowTime = 0;//공격 이후 지나간 시간
    
    private final int ATTACK_DELEY = 500;//공격 (ms)
    private final int attackActionTime = 300;
    
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
                
                
                if (pressedKeys.contains(KeyEvent.VK_Z) && !isAttack) {
                	isAttack = true;
                	attackStartTime =  System.currentTimeMillis();
                	
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
        	
        	PlayerMove();
            Playerattack();
            applyGravity();            
            repaint();
            monsterMove();
        });
        timer.start();
    }

	private void monsterMove() {
		// TODO Auto-generated method stub
    	
    	 // 공격 범위 설정
        Rectangle hitBox = new Rectangle(x, y, 21, 21); 
        
    	for (int i = 0; i < monsters.size(); i++) {
    		monster1 m = monsters.get(i);
    		int mosterX = m.getX();    		
    		if (x < mosterX) {
    			m.leftMove();
			}
    		else if(x > mosterX) {
    			m.rightMove();
    		}
    		else
    			m.idle();
    		
    		//공격 상태가 아니고 피격 가능 시간이 아닐 때 피격시
    		if (hitBox.intersects(m.getBounds()) && !isAttack&& !isHit) {//교차 여부 판별
                isHit = true;         
            }
    		
    		
		}
	}

	private void PlayerMove() {
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
        
        //피격 딜레이 시간 설정해야함
        
        //피격시 피 감소
        
        if (isHit) {
        	
        	if (hitStartTime == 0) {
       	
    			hp -= 10;			
    			System.out.println("아파용! " + hp);
    			hitStartTime = System.currentTimeMillis();
			}
        	else if(hitStartTime > 0) {
        		hitNowTime = System.currentTimeMillis() - hitStartTime;
        	}
        	
        	if(hitNowTime > hitDeley) {
        		isHit = false;
        		hitStartTime = 0;
        		hitNowTime = 0;
        	}

			
			
			if (hp <= 0) {
				timer.stop();
				System.out.println("죽었어용");
			}
		}
    }
    
    
    private void Playerattack() {
    	if(isAttack) {   	
    		attackNowTime = System.currentTimeMillis() - attackStartTime;
    		if(attackNowTime < attackActionTime)//공격 액션 실행 시간
    		{
		    	if(direction == 1) {//플레이어 방향 확인
					x += (SPEED*2);
				}else {
					x -= (SPEED*2);
				}
		    	
    		}
    		
    		
	    	if(attackNowTime > ATTACK_DELEY) {//공격 쿨타임
	    		
	    		isAttack = false;
	    	}
	    	
	    	 // 공격 범위 설정
            Rectangle attackBox;
            if (direction == 1)
                attackBox = new Rectangle(x + 20, y, 20, 20); // 오른쪽 공격
            else
                attackBox = new Rectangle(x - 20, y, 20, 20); // 왼쪽 공격
            
            
            for (int i = monsters.size()-1; i >= 0; i--) {
            	monster1 m = monsters.get(i);
                if (attackBox.intersects(m.getBounds())) {//교차 여부 판별
                    m.takeDamage(30); // 데미지 30
                    
                    // 죽은 몬스터 제거
                    if (m.isDead()) {
                        monsters.remove(i);
                        System.out.println("몬스터 처치!");
                    }
                }
                else {
					m.setDamage(false);
				}
                
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
        
        if(isAttack) {
        	g.setColor(Color.blue);
        }
        g.fillOval(x, y, 20, 20); // 캐릭터
        g.setColor(Color.BLACK);
        g.fillRect(0, FLOOR_Y + 20, getWidth(), 20); // 바닥
        
        for(int i = 0; i < monsters.size(); i++) {
        	g.setColor(Color.red);
        	g.fillOval(monsters.get(i).getX(), monsters.get(i).getY(), 20, 20); // 몬스터
            
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



class monster1{
	
	private int hp = 100;
	private int x = 200, y = 300;
	
	private final int SPEED = 2;   // 이동 속도
   
	private final int GRAVITY = 2; // 중력 효과
    private int velocityY = 0; // 수직 속도 (점프 포함)
    
    private boolean isOnGround = false; // 바닥에 있는지 여부
    private boolean isJumping = false;  // 점프 중인지 여부  
    private boolean isDamage = false;
    
    
	public void setDamage(boolean isDamage) {
		this.isDamage = isDamage;
	}

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
	
	public void takeDamage(int dmg) {
		if (isDamage) {
			return;
		}
			isDamage = true;
	        hp -= dmg;
	        System.out.println("몬스터 피격! HP: " + hp);
	}
	
	public boolean isDead() {
        return hp <= 0;
    }
	
	public Rectangle getBounds() {//피격 범위
        return new Rectangle(x, y, 20, 20);
    }
	
}