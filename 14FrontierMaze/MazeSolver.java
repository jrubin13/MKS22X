import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
public class MazeSolver {
    private Maze maze;
    private Frontier frontier;
    public MazeSolver(String mazeText) {
        
	solve();
    }
    public boolean solve() {
	return solve(0);
    }
    public boolean solve(int mode) {
	if (mode == 0) {
	    while (
	}
	return false;
    }
    public String toString() {
	return maze.toString();
    }
}
