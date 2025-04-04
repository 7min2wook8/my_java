package java0402;

public class Find_Lend_Mine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//findLend_1Line lend1 = new findLend_1Line();
		findLend_3Line lend3 = new findLend_3Line();
	}
	
}
class findLend_3Line{
	
	int[][] lend = 	{
					{0,1,0,1,1,1,0,0,1,0},
					{1,0,0,0,1,1,0,0,1,1},
					{1,1,0,0,1,0,1,0,1,1}
					};
	
	
	public findLend_3Line(){
		
		//현재 위치를 기준으로 자신과 상하좌우, 대각선에 지뢰가 있으면 지뢰 개수 만큼로 변경
		for (int i = 0; i < lend.length; i++) {
			
			for (int j = 0; j < lend[i].length; j++) {
				int boomCount = 0;
				//현재 위치
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
				
				
				
				
				System.out.print(boomCount);
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