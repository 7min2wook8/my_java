package findMine;

public class SelectNum{
	int row, col;

	public SelectNum(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	
	//같으면 true, 다르면 false
	public boolean CheckNums(SelectNum num) {
		
		if (num.row == this.row && num.col == this.col) {
			return true;
		}
		
		return false;
		
	}
	
	//같으면 true, 다르면 false
		public boolean CheckNums(int row, int col) {
			
			if (row == this.row && col == this.col) {
				return true;
			}
			
			return false;
			
		}

		
}