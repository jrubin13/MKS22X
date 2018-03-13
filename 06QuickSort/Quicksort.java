import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class Quicksort {
    public int partition (int [] data, int start, int end) {
        Random rand = new Random();
	int  pindex = rand.nextInt(end - start) + 1;
	int pivot = data[pindex];
	int large = end;
	int small = start;
	int i = start+1;
	swap(data[pindex], data[start]);
	pindex  = star;
	while (i != end) {
	    if (data[i] > data[pindex]) {
		swap(data[i], data[large]);
		large -= 1;
	    }
	    else {
		i += 1;
	    }
	}
	return large - small;
    }
    public void swap (int a, int b) {
	int c = a;
	a = b;
	b = c;
    }
}
