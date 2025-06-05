package java0414_1;

public class ScoreMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		StudentScore[] ssArr = new StudentScore[10];
		
		
		
		for (int i = 0; i < ssArr.length; i++) {
			ssArr[i] = new StudentScore(RendData.getRandName(), 
					RendData.getRandScore(), 
					RendData.getRandScore(), 
					RendData.getRandScore());
			
			System.out.println("번호 : " + (i+1));
			System.out.println("이름 : " + ssArr[i].getName());
			System.out.println("총점 : " + ssArr[i].getHap());
			System.out.println("평균 : " + ssArr[i].getAvg());
			System.out.println("학점 : " + ssArr[i].getHakjum());
			System.out.println("-------------------------------------------------");
			
		}
		
		
		
	}

}
