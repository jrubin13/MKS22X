import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class Quick {
    public static void quicksort(int[] data) {
	quicksortH(data, 0, data.length-1, 1);
    }
    public static void quicksortH(int[] data, int start, int end, int i) {
        if (start < end) {
	    int[] value = partition(data, start, end, i);
	    //System.out.println(Arrays.toString(data));
	    quicksortH(data, start, value[0]-1, start+1);
	    quicksortH(data, value[1]+1, end, value[1]+2);
	}
    }
    
    public static int quickselect(int[] data, int k) {
        return quickselectH(data, k, 0, data.length-1);
    }

    public static int quickselectH(int[] data, int k, int start, int end) {
	int i[];
	i = partition(data, start, end, start+1);
	if (i[0] < k-1) {
	    return quickselectH(data, k, i[1]+1, end);
	}
	else if (i[0] > k) {
	    return quickselectH(data, k, start, i[0]-1);
	}
	else {
	    return data[k];
	}
    }
    
    public static int[] partition (int [] data, int start, int end, int i) {
        //Random rand = new Random();
	//System.out.println(end-start+1);              //Random not working correctly
	//int pindex = rand.nextInt(end - start+1);
	int pindex = (int)(Math.random() * (end-start) + start);
	int small = start;
	int j = end;
	swap(data, pindex, small);
	//System.out.println(Arrays.toString(data) + "\n");
	while (i <= j) {
	    if (data[i] > data[small]) {
		swap(data, i, j);
		j -= 1;
	    }
	    else if (data[i] < data[small]) {
		swap(data, i, small);
		i += 1;
		small+=1;
	    }
	    else if (data[i] == data[small]){
		i+=1;
	    }
	}
	//System.out.println(Arrays.toString(data));
        int lowerBound = small;
	int upperBound = j;
	int[] bounds = new int[2];
	bounds[0] = lowerBound;
	bounds[1] = upperBound;
	return bounds;
	//System.out.println(Arrays.toString(data));
    }
    private static void swap (int[] data, int a, int b) {
	int c = data[a];
	data[a] = data[b];
	data[b] = c;
    }
    public static void main(String[] args) {
	int[] a = {3,2,4,5,1,1,8};
	for (int i = 0; i < a.length; i++) {
	    System.out.println(quickselect(a, i));
	}
	quicksort(a);
	System.out.println(Arrays.toString(a));
    }
}
