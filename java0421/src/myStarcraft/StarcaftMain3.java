package myStarcraft;

import java.util.List;
import java.util.ArrayList;

public class StarcaftMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Unit> list = new ArrayList<>();
		
		list.add(new Marine2());
		list.add(new Tank2());
		list.add(new Dropship2());
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).move(100, 200);
		}
		
		System.out.println("--------------------------------");
		
		for (Unit unit : list) {
			unit.move(100, 200);
		}
	}

}

