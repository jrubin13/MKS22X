import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!

      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: print a meaningful error and exit the program.
    */
    public Maze(String filename){
	try {
	    File text = new File(filename);// can be a path like: "/full/path/to/file.txt"
	    
	    //inf stands for the input file
	    Scanner inf = new Scanner(text);
	    int cols = 0;
	    int rows = 0;
	    String str = "";
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		if (rows != 0) {
		    str+= "\n";
		}
		//cols = line.length();
		rows += 1;
		str += line;
	    }
	    //System.out.println(str);
	    //System.out.println(str.length());
	    //System.out.println(rows);
	    cols = ((str.length()-rows+1) / rows);
	    maze = new char[rows][cols];
	    int x = 0;
	    int y = 0;
	    for (int i = 0; i < str.length(); i++) {
		if (y != cols) {
		    maze[x][y] = str.charAt(i);
		    y+=1;
		}
		else {
		    x += 1;
		    y = 0;
		    maze[x][y] = str.charAt(i);
		}
	    }
	    int e = 0;
	    int s = 0;
	    for (int r = 0; r < maze.length; r++) {
		for (int c = 0; c < maze[0].length; c++) {
		    if (maze[r][c] == 'E') {
			e += 1;
		    }
		    if (maze[r][c] == 'S') {
			s += 1;
		    }
		}
	    }
	    if (e>1 || s >1) {
		throw new IllegalArgumentException();
	    }
	    //System.out.println(maze);
	}
	catch (FileNotFoundException e) {
	}
    }
    
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void setAnimate(boolean b){
        animate = b;
    }
    
    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }


    /*Wrapper Solve Function returns the helper function
      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
            //find the location of the S. 

            //erase the S

            //and start solving at the location of the s.
            //return solve(???,???);
	int Srow = -1;
	int Scol = -1;
	for (int i = 0; i < maze.length; i++) {
	    for (int x = 0; x < maze[0].length; x++) {
		if (maze[i][x] == 'S') {
		    Srow = i;
		    Scol = x;
		}
	    }
	}
	return solve(Srow, Scol, 0);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int total){ //you can add more parameters since this is private
	int[] x = {0,1,0,-1};
	int[] y = {1,0,-1,0};
        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(100);
        }
	int work = 0;
	for (int i = 0; i < 4; i++) {
	    if (maze[row+x[i]][col+y[i]] == 'E') {
		maze[row][col] = '@';
		return total+1;
	    }
	    if (maze[row+x[i]][col+y[i]] == ' ') {
		maze[row][col] = '@';
		work += 1;
		return solve(row+x[i], col+y[i], total+1);
	    }
	}
	if (work == 0) {
	    for (int i = 0; i < 4; i++) {
		if (maze[row+x[i]][col+y[i]] == '@') {
		    maze[row][col] = '.';
		    return solve(row+x[i], col+y[i], total-1);
		}
	    }
	}
        return -1;
    }
    public String toString() {
	String ans = "";
	for (int i = 0; i < maze.length; i++) {
	    for (int x = 0; x < maze[0].length; x++) {
		ans = ans + maze[i][x];
	    }
	    ans += "\n";
	}
	return ans;
    }
}
