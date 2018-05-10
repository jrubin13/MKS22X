import java.util.*;
public class Sorts extends MyHeap{
    @SuppressWarnings("unchecked")
    public static void heapsort(int[] d) {
	if (d.length == 0) {
	    return;
	}
        MyHeap<Integer> data = heapify(d, false);
	//System.out.println(data + "\n");
        int i = 0;
	while (0 < data.size()) {
	    d[i] = data.remove();
	    //System.out.println(Arrays.toString(d));
	    //System.out.println(data);
	    //System.out.println(data.size());
	    i+=1;
	}
    }
    public static void main(String[] args) {
	int[] test2 = {5,2,1,78,36,41,22,22,46,44,0,0};
	int[] test = {5,2,1,78,36,41,22,22,46,44,0,0};
        Arrays.sort(test2);
	System.out.println(Arrays.toString(test2));
	heapsort(test);
	System.out.println(Arrays.toString(test));
    }
}
