import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    public MazeSolver(String mazeText) {
	maze = new Maze(mazeText);
	maze.clearTerminal();
	solve();
    }
    public boolean solve() {
	return solve(0);
    }
    public boolean solve(int mode) {
	if (mode == 0) {
	    frontier = new FrontierQueue();
	    Location a = maze.getStart();
	    frontier.add(a);
	    while (frontier.hasNext()) {
		Location n = frontier.next();
		//System.out.println(Arrays.toString(b));
		Location[] temp = maze.getNeighbors(n);
		maze.set(n.row(), n.col(), '.');
		//System.out.println(Arrays.toString(b));
		if (n.row() == maze.getEnd().row() &&
		    n.col() == maze.getEnd().col()){
		    while (n.getPrev() != maze.getStart()) {
			n = n.getPrev();
			maze.set(n.row(), n.col(), '@');
		    }
		    maze.set(maze.getEnd().row(), maze.getEnd().col(), 'E');
		    //System.out.println("\n" + maze);
		    maze.clearTerminal();
		    System.out.println(maze);
		    return true;
		}
		//maze.set(n.row(), n.col(), '@');
		//frontier.remove();
		for (int i = 0; i < temp.length; i++) {
		    frontier.add(temp[i]);
		}
		maze.set(maze.getStart().row(), maze.getStart().col(), 'S');
		maze.set(maze.getEnd().row(), maze.getEnd().col(), 'E');
		maze.clearTerminal();
		System.out.println(maze);
		wait(100);
	    }
	}
	return false;
    }
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }
    public String toString() {
	return maze.toString();
    }
    public static void main(String[] args) {
	MazeSolver test = new MazeSolver("data1.dat");
    }
}
