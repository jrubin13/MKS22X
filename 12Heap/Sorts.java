import java.util.*;
public class Sorts extends MyHeap{
    private int[] data;
    @SuppressWarnings("unchecked")
    public static void heapsort(int[] d, boolean type) {
	if (d.length == 0) {
	    return;
	}
        MyHeap<Integer> data = new MyHeap<>();
        data = heapify(d, type);
        int i = 0;
	while (0 < data.size()) {
	    d[i] = data.remove();
	    i+=1;
	}
    }
    public static void main(String[] args) {
	int[] test = {5,2,1,78,36,23,41};
	heapsort(test, false);
	System.out.println(Arrays.toString(test));
    }
}
