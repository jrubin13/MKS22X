import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class Quick {
    public static int quickselect(int[] data, int k) {
	if (k < 1 || k > data.length) {
	    throw new ArrayIndexOutOfBoundsException();
	}
	int start = 0;
	int end = data.length-1;
	k -= 1;
	int i = partition(data, start, end);
        while (i != k) {
	    if (i > k) {
		i = partition(data, 0, i-1);
	    }
	    else if (i < k) {
		i = partition(data, i, data.length-1);
	    }
	    else {
		return data[i];
	    }
	}
	return data[i];
    }
    public static int partition (int [] data, int start, int end) {
	if (start < 0 || start >= data.length || end < 0 || end >= data.length) {
	    throw new ArrayIndexOutOfBoundsException();
	}
        Random rand = new Random();
	int pindex = rand.nextInt(end - start + 1);
	System.out.println("value = " + data[pindex]);
	//System.out.println(Arrays.toString(data));
	int large = end;
	int small = start;
	int i = start+1;
	int j = large;
	swap(data, pindex, small);
	System.out.println(Arrays.toString(data) + "\n");
	while (i <= j) {
	    if (data[i] >= data[start]) {
		swap(data, i, j);
		j -= 1;
	    }
	    else {
		i += 1;
	    }
	    //System.out.println(Arrays.toString(data));
	}
	swap(data, small, j);
	System.out.println(Arrays.toString(data));
	return j;
    }
    private static void swap (int[] data, int a, int b) {
	int c = data[a];
	data[a] = data[b];
	data[b] = c;
    }
}
