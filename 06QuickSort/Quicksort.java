import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class Quicksort {
    public static int partition (int [] data, int start, int end) {
        Random rand = new Random();
	int pindex = rand.nextInt(end - start);
	int pivot = data[pindex];
	System.out.println("value = " + pivot);
	System.out.println("value index = " + pindex);
	System.out.println(Arrays.toString(data));
	int large = end;
	int small = start;
	int i = start;
	//swap(data, pindex, start);
	//pindex  = start;
	System.out.println(Arrays.toString(data) + "\n");
	while (i != pindex && large != pindex) {
	    if (data[i] > pivot) {
		swap(data, i, large);
		large -= 1;
	    }
	    else {
		i += 1;
	    }
	    System.out.println(Arrays.toString(data));
	}
	return pindex;
    }
    public static void swap (int[] data, int a, int b) {
	int c = data[a];
	data[a] = data[b];
	data[b] = c;
    }
    public static void main(String[] args) {
	int[] test = {1,5,3,7,8,0,3};
	System.out.println(partition(test,0, 6));
        System.out.println(Arrays.toString(test));
    }
}
