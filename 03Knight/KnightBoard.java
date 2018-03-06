public class KnightBoard {
    int[][]board;
    int rows;
    int cols;
    int[] x = {1, 1, -1, -1, 2, 2, -2, -2};
    int[] y = {2, -2, 2, -2, 1, -1, 1, -1};
    public KnightBoard(int startingRows,int startingCols)  {
	rows = startingRows;
	cols = startingCols;
	if (rows < 0 || cols < 0) {
	    throw new IllegalArgumentException();
	}
	
	board = new int[startingRows][startingCols];

	for (int i = 0; i < rows; i++) {
	    for (int z = 0; z < cols; z++) {
		board[i][z] = 0;
	    }
	}
    }
    public String toString() {
	String ans = "";
	for (int i = 0; i < rows; i++) {
	    for (int z = 0; z < cols; z++) {
		if (board[i][z] == 0) {
		    ans += " _ ";
		}
		else if (board[i][z] >= 10) {
		    ans = ans + board[i][z] + " ";
		}
		else {
		    ans = ans + " " + board[i][z] + " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
    public boolean solve(int row, int col) {
	//System.out.println(board);
	for (int i = 0; i < board.length; i++) {
	    for (int z = 0; z < board[0].length; z++) {
		if (board[i][z] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	if (row < 0 || col < 0 || row >= rows || col >= cols) {
	    throw new IllegalArgumentException();
	}
	board[row][col] = 1;
	return solveH(row, col, 2);
    }
    public int countSolutions(int row, int col) {
	if (row < 0 || col < 0 || row >= rows || col >= cols) {
	    throw new IllegalArgumentException();
	}
	//board[row][col] = 1;
	if (board[row][col] == 0) {
	    board[row][col] = 1;
	}
	else {
	    throw new IllegalStateException();
	}
	return countSolve(row, col, 2, 0);
    }
    private boolean solveH(int row ,int col, int level) {
	if (level > rows*cols) {
	    return true;
	}
	for (int i = 0; i < 8; i++) {
	    if ((row+x[i]>=0&&row+x[i]<rows) && (col+y[i]>=0&&col+y[i]<cols) && (board[row+x[i]][col+y[i]]==0)) {
		board[row+x[i]][col+y[i]] = level;
		//clearTerminal();
		//System.out.println(go(1,1));
		//System.out.println(this);
		//wait(50); //adjust this delay
		if (solveH(row+x[i], col+y[i], level+1)) {
		    return true;
		}
		board[row+x[i]][col+y[i]] = 0;
	    }
	}
	board[row][col] = 0;
	return false;
    }
    private int countSolve(int row, int col, int lvl, int num) {
	if (lvl > rows*cols) {
	    return num+1;
	}
	    /*else {
		return 0;
		}*/
	
	for (int i = 0; i < 8; i++) {
	    if ((row + x[i] >= 0 && row + x[i] < rows) &&
		(col + y[i] >= 0 && col + y[i] < cols) &&
		(board[row+x[i]][col+y[i]]==0)) {
		
		board[row+x[i]][col+y[i]] = lvl;
	        num = countSolve(row+x[i], col+y[i], lvl+1, num);
		board[row+x[i]][col+y[i]] = 0;
	    }
	}
	board[row][col] = 0;
	return num;
    }
    public String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }
    public void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }
    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }
}
