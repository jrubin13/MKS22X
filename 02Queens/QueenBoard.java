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
	    return true;
	}
	return false;
    }
    public boolean removeQueen(int r, int c) {
	if (board[r][c] == -1) {
	    board[r][c] = 0;
	    for (int i = r; r < board.length; r++) {
		for (int x = c; c < board[0].length; x++) {
		    board[i][x] = board[i][x] - 1;
		}
	    }
	    for (int i = c; c < board.length; i++) {
		board[r][i] = board[r][i] - 1;
	    }
	    return true;
	}
	return false;
    }
    public boolean solve() {
	return true;
    }
}
