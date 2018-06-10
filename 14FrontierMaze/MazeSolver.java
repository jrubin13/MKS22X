import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
public class MazeSolver{
    private Maze maze;
    private boolean animate = false;
    private Frontier frontier;
    private boolean astar = true;
    private int mode;
    public MazeSolver(String mazeText) {
	maze = new Maze(mazeText);
	//maze.clearTerminal();
	//solve();
	//animate = false;
    }
    public void setAnimate(boolean type) {
	animate = type;
    }
    public boolean solve() {
	//animate = false;
	return solve(0);
    }
    public boolean solve(int mode) {
	if (mode == 0) {                      //Breadth-First
	    frontier = new FrontierQueue();
	    mode = 0;
	    return simulation();
	}
	if (mode == 1) {                      //Depth-First
	    frontier = new FrontierStack();
	    mode = 1;
	    return simulation();
	}
        if (mode == 2) {                      //Best First
	    //System.out.println(mode);
	    frontier = new FrontierPriorityQueue();
	    mode = 2;
	    //maze.setAStar(astar);
	    return simulation();
	}
	if (mode == 3) {                      //A*
	    frontier = new FrontierPriorityQueue();
	    maze.setAStar(astar);
	    mode = 3;
	    return simulation();
	}
	return false;
    }
    private boolean simulation() {
	Location start = maze.getStart();
	Location[] temp;
	frontier.add(start);
	while (frontier.hasNext()) {
	    Location n = frontier.next();
	    //System.out.println(Arrays.toString(b));
	    //System.out.println(n);
	    System.out.println(frontier);
	    if (mode == 0 || mode == 1) {
		temp = maze.getNeighbors(n);
	    }
	    else {
		temp = maze.getNeighbors2(n);
	    }
	    maze.set(n.row(), n.col(), '.');
	    //System.out.println(Arrays.toString(b));
	    if (n.row() == maze.getEnd().row() &&
		n.col() == maze.getEnd().col()){
		while (n.getPrev() != maze.getStart()) {
		    n = n.getPrev();
		    maze.set(n.row(), n.col(), '@');
		}
		maze.set(maze.getStart().row(), maze.getStart().col(), 'S');
		maze.set(maze.getEnd().row(), maze.getEnd().col(), 'E');
		if (animate) {
		    //System.out.println("\n" + maze);
		    maze.clearTerminal();
		    System.out.println(maze);
		}
		return true;
	    }
	    //maze.set(n.row(), n.col(), '@');
	    //frontier.remove();
	    for (int i = 0; i < temp.length; i++) {
		frontier.add(temp[i]);
	    }
	    if (animate) {
		maze.clearTerminal();
		maze.set(maze.getStart().row(), maze.getStart().col(), 'S');
		maze.set(maze.getEnd().row(), maze.getEnd().col(), 'E');
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
	test.setAnimate(false);
	test.solve(1);
    }
}
