import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class Merge {
    public static void mergesort(int[] data) {
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length/2, data.length);
    }
    private static void msort(int[] data, int[] temp, int lo, int mid, int hi) {
	if (lo >= hi) {
	    return;
	}
	for (int i = lo; i < hi; i++) {
	    temp[i] = data[i];
	}
        if (hi - lo > 1) {
	    //mid = (lo+hi)/2;
	    msort(temp, data, lo, (lo+mid)/2, mid-1);
	    msort(temp, data, mid, (mid+hi)/2, hi);
	}
	else {
	    merge(data, temp, 0, data.length/2, data.length-1);
	}
    }

    private static void merge (int[] data, int[] temp, int lo, int mid, int hi) {
	int a = lo;
	int i = lo;
	while (a < mid && mid < hi) {
	    if (temp[a] > temp[mid]) {
		data[i] = temp[a];
		a += 1;
	    }
	    else {
		data[i] = temp[mid];
		mid+=1;
	    }
	    i+=1;
	}
        while (a < mid) {
	    data[i] = temp[a];
	    a+=1;
	    i+=1;
	}
	while (mid < hi) {
	    data[i] = temp[mid];
	    mid+=1;
	    i+=1;
	}
    }
    public static void main(String[] args) {
        int[] a = {5,2,3,1,7,6,8,9};
	mergesort(a);
	System.out.println(Arrays.toString(a));
    }
}
