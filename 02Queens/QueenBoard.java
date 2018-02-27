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
	    int column = c+1;
	    int rows = r+1;
	    while (rows < board.length && column < board.length) { //diagonal down
		board[rows][column] += 1;
		column += 1;
		rows += 1;
	    }
	    int row = r-1;
	    int col = c+1;
	    while (row >= 0 && col < board.length) { //diagonal up
		board[row][col] += 1;
		row -= 1;
		col += 1;
	    }
	    for (int i = c+1; i < board[0].length; i++) { //right
		board[r][i] += 1;
	    }
	    /*for (int i = r+1; i < board.length; i++) { //down
		board[i][c] += 1;
	    }
	    for (int i = r-1; i >= 0; i--) { //up
		board[i][c] += 1;
		}*/
	    return true;
	}
	return false;
    }
    public boolean removeQueen(int r, int c) {
	if (board[r][c] == -1) {
	    board[r][c] = 0;
	    int column = c+1;
	    int rows = r+1;
	    while (rows < board.length && column < board.length) { //diagonal down
		if (board[rows][column] > 0) {
		    board[rows][column] -= 1;
		}
		column += 1;
		rows += 1;
	    }
	    int row = r-1;
	    int col = c+1;
	    while (row >= 0 && col < board.length) {
		if (board[row][col] > 0) {
		    board[row][col] -= 1;
		}
		row -= 1;
		col += 1;
	    }
	    for (int i = c+1; i < board.length; i++) {
		if (board[r][i] > 0) {
		    board[r][i] -= 1;
		}
	    }
	    /*for (int i = r+1; i < board.length; i++) {
		if (board[r][i] > 0) {
		    board[i][c] -= 1;
		}
	    }
	    for (int i = r-1; i >= 0; i--) {
		if (board[i][c] > 0) {
		    board[i][c] -= 1;
		}
		}*/
	    return true;
	}
	return false;
    }
    public boolean solve() {
	if (board.length < 4) {
	    return false;
	}
	for (int i = 0; i < board.length; i++) {
	    for (int x = 0; x < board.length; x++) {
		if (board[i][x] != 0) {
		    throw new IllegalStateException();
		}
	    }
	}
	return solveHelp (0);
    }
    
    public boolean solveHelp(int c) {
	if (c >= board.length) {
	    return true;
	}
	for (int r = 0; r < board.length; r++) {
	    if (addQueen(r,c)) {
		/*System.out.println(go(1,1));
		System.out.println(this);
		wait(500); //adjust this delay*/
		if (solveHelp(c+1)) {
		    return true;
		}
		else {
		    removeQueen(r,c);
		}
	    }
	    //removeQueen(r, c);
	}
	return false;
    }
    public int countSolutions() {
	return countHelp(0, 0);
    }
    public int countHelp(int c, int total) {
	if (c >= board.length) {
	    return total;
	}
	for (int r = 0; r < board.length; r++) {
	    if (addQueen(r,c)) {
		/*System.out.println(go(1,1));
		System.out.println(this);
		wait(500); //adjust this delay*/
		if (solveHelp(c+1)) {
		    total = total+1;
		}
	        for (int i = 0; i < board.length; i++) {
		    for (int x = 0; x < board.length; x++) {
			board[i][x] = 0;
		    }
		}
	    }
	    //removeQueen(r, c);
	}
	return total+countHelp(c+1, total);
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
}
