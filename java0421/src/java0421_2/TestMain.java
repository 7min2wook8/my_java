package java0421_2;

import java.util.List;
import java.util.ArrayList;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Friend friend1 = new HighFriend("홍길동", "010-0000-0000", "개발팀");
		friend1.ShowInfo();
		
		Friend friend2 = new ComFriend("홍길동", "010-0000-0000", "삼성");
		friend2.ShowInfo();
		
		System.out.println("===========================================");
		
		List<Friend> list = new ArrayList<>();
		list.add(friend1);
		list.add(friend2);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			list.get(i).ShowInfo();
			System.out.println("=====================================");
		}
		
		
		Friend[] friends = new Friend[2]; 
		friends[0] = new ComFriend("홍길동", "010", "개발팀");
		friends[1] = new HighFriend("홍길동", "010", "3학년3반");
		
		for (int i = 0; i < friends.length; i++) {
			friends[i].ShowInfo();
		}
		
	}

}
