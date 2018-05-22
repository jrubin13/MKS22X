import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private int size;
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
	    Location[] a = maze.getNeighbors(maze.getStart());
	    for (int i = 0; i < a.length; i++) {
		frontier.add(a[i]);
		size += 1;
	    }
	    while (size > 0) {
		Location n = frontier.next();
		Location[] temp = new Location[4];
		//System.out.println(Arrays.toString(b));
		temp = maze.getNeighbors(n);
		Location[] b = new Location[maze.s()];
		for (int i = 0; i < maze.s(); i++) {
		    b[i] = temp[i];
		}
		System.out.println(Arrays.toString(b));
		if (b.length == 0) {
		    while (b.length == 0) {
			maze.set(n.row(), n.col(), '.');
			n.getPrev();
		    }
		}
		//System.out.println(Arrays.toString(b));
		if (n.row() == maze.getEnd().row() &&
		    n.col() == maze.getEnd().col()){
		    maze.set(maze.getEnd().row(), maze.getEnd().col(), 'E');
		    while (n.getPrev() != maze.getStart()) {
			maze.set(n.row(), n.col(), '@');
			n = n.getPrev();
		    }
		    return true;
		}
		maze.set(n.row(), n.col(), '@');
		//frontier.pop();
		size -= 1;
		for (int i = 0; i < b.length; i++) {
		    frontier.add(b[i]);
		    size +=1;
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
