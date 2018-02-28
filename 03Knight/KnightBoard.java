public class KnightBoard {
    int[][]board;
    int rows;
    int cols;
    int[] x = {1, 1, -1, -1, 2, 2, -2, -2};
    int[] y = {2, -2, 2, -2, 1, -1, 1, -1};
    public KnightBoard(int startingRows,int startingCols)  {
	board = new int[startingRows][startingCols];
	rows = startingRows;
	cols = startingCols;
	if (rows < 0 || cols < 0) {
	    throw new IllegalArgumentException();
	}
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
		    ans += "_ ";
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
	for (int i = 0; i < rows; i++) {
	    for (int z = 0; z < cols; z++) {
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
	int total = 0;
	for (int i = 0; i < rows; i++) {
	    for (int z = 0; z < cols; z++) {
		if (board[i][z] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	if (row < 0 || col < 0 || row >= rows || col >= cols) {
	    throw new IllegalArgumentException();
	}
	board[row][col] = 1;
        for (int i = 0; i < 8; i++) {
	    if (solveH(row, col, 2)) {
		total+= 1;
	    }
	}
	return total;
    }
    private boolean solveH(int row ,int col, int level) {
	if (level == row*col) {
	    return true;
	}
	for (int i = 0; i < 8; i++) {
	    if ((row+x[i]>=0&&row+x[i]<rows) && (col+y[i]>=0&&col+y[i]<cols) && (board[row+x[i]][col+y[i]]==0)) {
		board[row+x[i]][col+y[i]] = level;
		solveH(row+x[i], col+y[i], level+1);
	    }
	}
	return false;
    }
}
