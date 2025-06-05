package myStarcraft;

public class StarcaftMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marine marine = new Marine();
		Tank tank = new Tank();
		DropShip dropShip = new DropShip();
	}

}


abstract class Unit{
	int x, y;
	abstract void move(int x, int y);
	
	void stop() {};
	
}

class Marine2 extends Unit{

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.printf("x%d , %d 걸어서 이동 \n",x,y);
		
	}
	
	void marineFire() {/**/};
	
}


class Tank2 extends Unit{

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.printf("x%d , %d 무한궤도 이동 \n",x,y);
		
	}
	
	void tankFire() {/**/};
	
}


class Dropship2 extends Unit{

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		System.out.printf("x%d , %d 공중에서 이동 \n",x,y);
		
	}
	
	void dropshipFire() {/**/};
	
}
