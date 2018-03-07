import java.util.*;
import java.io.*;
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
	    int x = 0;
	    
	    //inf stands for the input file
	    Scanner inf = new Scanner(text);
	    int cols = 0;
	    int rows = 0;
	    while(inf.hasNextLine()){
		String line = inf.nextLine();
		cols = line.length();
		rows += 1;
	    }
	    maze = new char[rows][cols];
	    while (inf.hasNextLine()) {
		String line = inf.nextLine();
		for (int i = 0; i < line.length(); i++) {
		    maze[x][i] = line.charAt(i);
		}
		x+=1;
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
	    
	}   
	catch (FileNotFoundException e) {
	    System.out.println("File not found");
	    //System.out(0);
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
		    maze[i][x] = '.';
		    Srow = i;
		    Scol = x;
		}
	    }
	}
	return solve(Srow, Scol);
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
    private int solve(int row, int col){ //you can add more parameters since this is private
	int[] x = {0,1,0,-1};
	int[] y = {1,0,-1,0};
        //automatic animation! You are welcome.
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }
	int a = 0;
        //COMPLETE SOLVE
	for (int i = 0; i < 4; i++) {
	    if (maze[row+x[i]][col+y[i]] == ' ') {
		maze[row][col] = '@';
		a += 1;
		return solve(row+x[i], col+y[i]);
	    }
	}
	for (int i = 0; i < 4; i++) {
	    if (maze[row+x[i]][col+y[i]] == '@') {
		maze[row][col] = '.';
		a -= 1;
		return solve(row+x[i], col+y[i]);
	    }
	}
        return a; //so it compiles
    }
    public String toString() {
	String ans = "";
	for (int i = 0; i < maze.length; i++) {
	    for (int x = 0; x < maze[0].length; x++) {
		ans +=  "" + maze[i][x];
	    }
	    ans += "\n";
	}
	return ans;
    }

}
