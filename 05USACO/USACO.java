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
	try {
	    int rows = 0;
	    int cols = 0;
	    int time = 0;
	    int startx = 0;
	    int starty = 0;
	    int endx = 0;
	    int endy = 0;
	    char[][] map;
	    int[][] before;
	    int[][] after;
	    File text = new File(filename);// can be a path like: "/full/path/to/file.txt"
	    //inf stands for the input file
	    Scanner inf = new Scanner(text);
	    rows = inf.nextInt();
	    cols = inf.nextInt();
	    time = inf.nextInt();
	    inf.nextLine();
	    map = new char[rows][cols];
	    before = new int[rows][cols];
	    after = new int[rows][cols];
	    String line = "";
	    int count = 0;
	    for (int i = 0; i < rows; i++) {
		line = inf.nextLine();
		for (int x = 0; x < line.length(); x++) {
		    map[count][x] = line.charAt(x);
		    if (map[count][x] == '*') {
			before[count][x] = -1;
			after[count][x] = -1;
		    }
		    else {
			before[count][x] = 0;
			after[count][x] = 0;
		    }
		}
		count+=1;
	    }
	    startx = inf.nextInt()-1;
	    starty = inf.nextInt()-1;
	    before[startx][starty] = 1;
	    after[startx][starty] = 1;
	    endx = inf.nextInt()-1;
	    endy = inf.nextInt()-1;
	    int[] x = {-1,0,1,0};
	    int[] y = {0,1,0,-1};
	    int total = 0;
	    for (int i = 0; i < time; i++) {
		if (i % 2 == 1) {
		    for (int r = 0; r < before.length; r++) {
			for (int c = 0; c < before[0].length; c++) {
			    total = 0;
			    if (after[r][c] > 0) {
				before[r][c] = 0;
			    }
			    else if (after[r][c] == 0) {
				for (int around = 0; around < 4; around++) {
				    if (r+x[around] >= 0 && r+x[around] < map.length &&
					c+y[around] >= 0 && c+y[around] < map[0].length) {
					if (map[r+x[around]][c+y[around]] != '*') {
					    total += after[r+x[around]][c+y[around]];
					}
				    }
				}
				before[r][c] = total;
			    }
			}
		    }
		}		    
		    //check after, change before
		else {
		    for (int r = 0; r < before.length; r++) {
			for (int c = 0; c < before[0].length; c++) {
			    total = 0;
			    if (before[r][c] > 0) {
				after[r][c] = 0;
			    }
			    else if (before[r][c] == 0) {
				for (int around = 0; around < 4; around++) {
				    if (r+x[around] >= 0 && r+x[around] < before.length &&
					c+y[around] >= 0 && c+y[around] < before[0].length) {
					if (map[r+x[around]][c+y[around]] != '*') {
					    total += before[r+x[around]][c+y[around]];
					}
				    }
				}
				after[r][c] = total;
			    }
			}
		    }
		}
	    }
	    if (time % 2 == 1) {
		return after[endx][endy];
	    }
	    else {
		return before[endx][endy];
	    }
	    
	}
	catch  (FileNotFoundException e){
	    return 0;
	}
    }
}
