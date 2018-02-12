public class QueenBoard{
    private int[][] board;
    
    public QueenBoard(int size) {
	board = new int[size][size];
	for (int r = 0; r < size; r++) {
	    for (int c = 0; c < size; c++) {
		board[r][c] = 0;
	    }
	}
    }

    public String toString() {
	String ans = "";
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[0].length; c++) {
		if (board[r][c] != -1) {
		    ans += "_ ";
		}
		else {
		    ans += "Q ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
    public boolean addQueen(int r, int c){
	if (board[r][c] == 0) {
	    board[r][c] = -1;
	    for (int i = r+1; i < board.length; i++) {
		board[i][i] += 1;
	    }
	    int row = r+1;
	    int col = c+1;
	    while (row >= 0 && col < board.length) {
		board[row][col] += 1;
		row -= 1;
		col += 1;
	    }
	    for (int i = c+1; i < board[0].length; i++) {
		board[r][i] += 1;
	    }
	    for (int i = r+1; i < board.length; i++) {
		board[i][c] += 1;
	    }
	    return true;
	}
	return false;
    }
    public boolean removeQueen(int r, int c) {
	if (board[r][c] == -1) {
	    board[r][c] = 0;
	    for (int i = r; i < board.length; i++) {
		if (board[i][i] > 0) {
		    board[i][i] -= 1;
		}
	    }
	    int row = r+1;
	    int col = c+1;
	    while (row >= 0 && col < board.length) {
		if (board[row][col] > 0) {
		    board[row][col] -= 1;
		}
		row -= 1;
		col += 1;
	    }
	    for (int i = c; i < board.length; i++) {
		if (board[r][i] > 0) {
		    board[r][i] -= 1;
		}
	    }
	    for (int i = r+1; i < board.length; i++) {
		if (board[r][i] > 0) {
		    board[i][c] -= 1;
		}
	    }
	    return true;
	}
	return false;
    }
    public boolean solve() {
	return solveHelp (0,0);
    }
    public boolean solveHelp(int c,int r) {
	if (c < 0 || r >= board.length) {
	    return false;
	}
	for (int col = c; col < board.length; col++) {
	    boolean work = false;
	    for (int row = r; row < board.length; row++) {
		if (addQueen(row, col)) {
		    work = true;
		}
	    }
	    if (!work) {
		for (int i = 0; i < r; r++) {
		    if (board[c-1][i] == -1) {
			removeQueen(c-1, i);
		    }
		}
		return solveHelp(c-1, r+1);
	    }
	}
	return true;
    }
    public int countSolutions() {
	return 0;
    }
}
