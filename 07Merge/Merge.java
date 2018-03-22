public class Merge {
    public static void mergesort(int[] data) {
	int[] temp = new int[data.length];
	msort(data, temp, 0, data.length/2, data.length);
    }
    private static void msort(int[] data, int[] temp, int lo, int mid, int hi) {
	if (lo >= hi) {
	    for (int i = lo; i < hi; i++) {
		temp[i] = data[i];
	    }
	    int a = hi;
	    hi = mid;
	    mid = (lo+a)/2;
	    msort(temp, data, lo, mid, hi);
	}
    }

    private static void merge (int[] data, int[] temp, int lo, int mid, int hi) {

    }

}
