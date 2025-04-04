package java0402;

import java.util.ArrayList;
import java.util.Scanner;





class Coffee {
	
	String name;
	int amount;
	
	public Coffee(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}

	public int getAmount() {
		return amount;
	}
}


public class Java0403_4 {
	
	static ArrayList<Coffee> coffees;
	static Scanner s;
	
	
	public static void main(String[] args) {
		coffees = new ArrayList<>();
		s = new Scanner(System.in);
		addCoffee();
		selectCoffee();
		
	}
	
	
	//커피 메뉴 추가
	static void addCoffee() {
		
		
		String text = "";
		coffees.add(new Coffee("아메리카노",1500));
		coffees.add(new Coffee("라때",2500));
		coffees.add(new Coffee("카푸치노",3500));
		coffees.add(new Coffee("에스프레소",1000));
		coffees.add(new Coffee("스틱커피",500));
		System.out.println("기본 메뉴를 추가하였습니다.");
		
		boolean isExit = false;
		while(!isExit) {
			System.out.println("메뉴를 추가하겠습니까? yes or no");		
			text = s.next();
			
			switch (text) {
			case "yes":
				
				System.out.println("메뉴 이름을 입력해주세요.");
				String name = s.next();
				
				System.out.println("금액을 입력해주세요. (숫자를 입력)");
				int incom = s.nextInt();
				
				coffees.add(new Coffee(name,incom));
				break;
				
			case "no":
				
				isExit = true;
				break;
				
			default:
				System.out.println("입력이 잘못되었습니다.");
				break;
			}
		}
	}
	
	
	static void selectCoffee() {
		
			Coffee selectcoffee = null;
			int res = 0;
			boolean isExit = false;
			
			while(!isExit) {
				selectcoffee = null;
				res = 0;
				
				try {
					System.out.println("커피 자판기 v1.0");
					for (int i = 0; i < coffees.size(); i++) {
						
						System.out.println((i+1)+". " + coffees.get(i).name +" " + coffees.get(i).amount+"원");
					}
					
					System.out.print("커피를 선택하세요. => ");
					int selectNum =  s.nextInt();
					System.out.println();
					
					
					if(selectNum < 0 || selectNum > coffees.size()) {
						System.out.println("잘못 입력 하였습니다.");
						continue;
					}
					
					selectcoffee = coffees.get(selectNum-1);
					
					
					System.out.print("결제 금액을 입력하세요. => ");
					int inMoney =  s.nextInt();
					
					
					
					res = inMoney - selectcoffee.getAmount();
					if(res < 0) {
						
						System.out.println("금액이 부족합니다.");
					}
					else {
						
						System.out.println("선택한 커피는 : " + selectcoffee.getName());
						System.out.println("잔액은 : " + res +"원 입니다.");
						System.out.println("");
						
						boolean c = true;
						while(c) {					
							System.out.println("추가 주문 하시겠습니까?");
							System.out.println("yes or no");
							String txt = s.next();
							switch (txt) {
							case "yes":
								isExit = false;
								c = false;
								break;
							case "no":
								isExit = true;
								c= false;
								break;
							default:
								System.out.println("입력이 틀렸습니다. 다시 입력해주세요.");
								break;
							}
						}
						
					}
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
			
			
			s.close();
			System.out.println("감사합니다.");
			
		}
	

}


