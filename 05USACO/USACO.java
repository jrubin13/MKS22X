import java.util.*;
import java.io.*;
public class USACO {
    public static int bronze(String filename) {
	try {
	    int row = 0;
	    int col = 0;
	    int elevation = 0;
	    int numInstructions = 0;
	    File text = new File(filename);// can be a path like: "/full/path/to/file.txt"
	    //inf stands for the input file
	    Scanner inf = new Scanner(text);
	    row = inf.nextInt();
	    col = inf.nextInt();
	    elevation = inf.nextInt();
	    numInstructions = inf.nextInt();
	    int[][] map = new int[row][col];
	    for (int i = 0; i < row; i++) {
		for (int x = 0; x < col; x++) {
		    map[i][x] = inf.nextInt();
		}
	    }
	    //System.out.println(row);
	    //System.out.println(col);
	    //System.out.println(elevation);
	    //System.out.println(numInstructions);
	    //System.out.println(map);
	    return 2;
	}
	catch (FileNotFoundException e) {
	    return 0;
	}
    }
    public static int silver(String filename) {
	return 0;
    }
    public String toString() {
	String ans = "";
	for (int i = 0; i < rows; i++) {
	    for (int z = 0; z < cols; z++) {
		if (board[i][z] == 0) {
		    ans += " _ ";
		}
		else if (board[i][z] >= 10) {
		    ans = ans + board[i][z] + " ";
		}
		else {
		    ans = ans + " " + board[i][z] + " ";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
}
