import java.util.*;
public class Sorts extends MyHeap{
    private int[] data;
    @SuppressWarnings("unchecked")
    public static void heapsort(int[] d) {
	if (d.length == 0) {
	    return;
	}
        MyHeap<Integer> data = new MyHeap<>();
	for (int i = 0; i < d.length; i++) {
	    data.add(d[i]);
	}
	//System.out.println(data);
        int i = 0;
	while (0 < data.size()) {
	    d[i] = data.remove();
	    i+=1;
	}
    }
    public static void main(String[] args) {
	int[] test = {5,2,1,78,36,23,41};
	heapify(test);
	System.out.println(test);
    }
}
