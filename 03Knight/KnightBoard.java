public class KnightBoard {
    int[][]board;
    public KnightBoard(int startingRows,int startingCols)  {
	board = int[startingRows][startingCols];
    }
    public String toString() {
	String ans = "";
	for (int i = 0; i < startingRows; i++) {
	    for (int x = 0; x < startingCols;x++) {
		if (board[i][x] == 0) {
		    ans += "_ ";
		}
		else if (board[i][x] >= 10) {
		    ans = ans + board[i][x] + " ";
		}
		else {
		    ans = ans + " " + board[i][x] + " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
    public boolean solve(int row, int col) {
	for (int i = 0; i < startingRows; i++) {
	    for (int x = 0; x < startingCols;x++) {
		if (board[i][x] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	if (row <= 0 || col <= 0) {
	    throw new IllegalArgumentException();
	}
	return solveH(row, col, 1);
    }
    private boolean solveH(int row ,int col, int level) {

    }
}
