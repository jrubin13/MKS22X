import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class Merge {
    public static void mergesort(int[] data) {
	int[] temp = new int[data.length];
	for (int i = 0; i < data.length; i++) {
	    temp[i] = data[i];
	}
	msort(data, temp, 0, data.length/2, data.length);
    }
    private static void msort(int[] data, int[] temp, int lo, int mid, int hi) {
	if (lo >= hi) {
	    return;
	}
	if (hi - lo <= 1) {
	    return;
	}
	//for (int i = lo; i < hi; i++) {
	//    temp[i] = data[i];
	//}
	//mid = lo+hi;
	//mid = mid/2;
	msort(temp, data, lo, ((lo+mid)/2), mid);
	msort(temp, data, mid, (hi+mid)/2, hi);
	merge(data, temp, lo, mid, hi);
    }

    private static void merge (int[] data, int[] temp, int lo, int mid, int hi) {
	int a = lo;
	int i = lo;
	int m = mid;
	//mid+=1;
	while (a < mid && m < hi) {
	    if (temp[a] < temp[m]) {
		data[i] = temp[a];
		a += 1;
	    }
	    else {
		data[i] = temp[m];
		m+=1;
	    }
	    i+=1;
	}
	//System.out.println(Arrays.toString(data));
        if (a < mid) {
	    while (a < mid) {
		data[i] = temp[a];
		a+=1;
		i+=1;
	    }
	}
	if (mid < hi) {
	    while (m < hi) {
		data[i] = temp[m];
		m+=1;
		i+=1;
	    }
	}
    }
    /* public static void main(String[] args) {
        int[] a = {5,2,3,1,7,6,8,9,4};
	System.out.println(Arrays.toString(a));
	mergesort(a);
	System.out.println(Arrays.toString(a));
	}*/
}
