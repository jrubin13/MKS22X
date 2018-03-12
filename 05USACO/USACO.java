import java.util.*;
import java.io.*;
public class USACO {
    public static int bronze(String filename) {
	try {
	    int row = 0;
	    int col = 0;
	    int elevation = 0;
	    int numInstructions = 0;
	    String instruction = "";
	    int irow = 0;
	    int icol = 0;
	    int idepth = 0;
	    int tall = 0;
	    int total = 0;
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
	    for (int q = 0; q < numInstructions; q++) {
		instruction = "";
		irow = 0;
		icol = 0;
		idepth = 0;
	        /*instruction = inf.nextInt() + " ";
		  instruction += inf.nextInt() + " ";
		  instruction += inf.nextInt() + " ";
		  int x = 0;
		  int i = 0;
		  while (x < 3) {
		  if (instruction.charAt(i) != 0) {
		  if (x = 0) {
		  
		  }
		  }*/
		irow = inf.nextInt()-1;
		icol = inf.nextInt()-1;
		idepth = inf.nextInt();
		//look for tallest part
		tall = 0;
		for (int i = irow; i <= irow+2; i++) {
		    for (int x = icol; x <= icol+2; x++) {
			if (i < row && x < col) {
			    if (tall < map[i][x]) {
				tall = map[i][x];
			    }
			}
		    }
		}
		//subtract the depth
		for (int j = irow; j <= irow+2; j++) {
		    for (int k = icol; k <= icol+2; k++) {
			if (j < row && k < col) {
			    if ((tall - idepth) < map[j][k]) {
				map[j][k] = tall - idepth;
			    }
			}
		    }
		}
	    }
            total = 0;
	    //subtract elevation, add it to total
	    for (int i = 0; i < row; i++) {
		for (int x = 0; x < col; x++) {
		    if (elevation - map[i][x] < 0) {
			map[i][x] = 0;
		    }
		    else {
			map[i][x] = elevation - map[i][x];
			total += map[i][x];
		    }
		}
	    }
	    
	    return total * 72 * 72;
	}
	catch (FileNotFoundException e) {
	    return 0;
	}
    }
    public static int silver(String filename) {
	return 0;
    }
    /*public String toString() {
	String ans = "";
	for (int i = 0; i < row; i++) {
	    for (int x = 0; x < col; x++) {
		ans = ans + map[i][x];
	    }
	    ans += "\n";
	}
	return ans;
	}*/
}
