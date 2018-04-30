public class MyHeap {
    String[] data;
    private boolean max;
    private int size;
    @SuppressWarnings("unchecked")
    public MyHeap() {
	data = new String[10];
	size = 0;
	max = true;
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean type) {
	data = new String[10];
	size = 0;
        max = type;
    }
    public int size() {
	return size;
    }
    public void add(String s) {
	if (size >= data.length) {
	    resize();
	}
	data[size] = s;
	int i = size;
	if (max) {
	    while (data[i].compareTo(data[(i-1)/2]) > 0) {
		swap(data, i, (i-1)/2);
		i = (i-1)/2;
	    }
	}
	else {
	    while (data[i].compareTo(data[(i-1)/2]) < 0) {
		swap(data, i, (i-1)/2);
		i = (i-1)/2;
	    }
	}
	size += 1;
    }
    public String remove() {
	if (size <= 0) {
	    return "";
	}
	String ans = data[0];
	data[0] = data[size-1];
	data[size-1] = null;
	int i = 0;
	if (max) {
	    while (2*i+1 < size &&
		   data[i].compareTo(data[2*i+1]) < 0 ||
		   data[i].compareTo(data[2*i + 2]) < 0) {
		if (data[2*i+1].compareTo(data[2*i+2]) > 0) {
		    swap(data, i, 2*i+1);
		    i = 2*i+1;
		}
		else {
		    swap(data, i, 2*i+2);
		    i = 2*i+2;
		}
	    }
	}
	else {
	    while (2*i+1 < size &&
		   data[i].compareTo(data[2*i+1]) > 0 ||
		   data[i].compareTo(data[2*i + 2]) > 0) {
		if (data[2*i+1].compareTo(data[2*i+2]) < 0) {
		    swap(data, i, 2*i+1);
		    i = 2*i+1;
		}
		else {
		    swap(data, i, 2*i+2);
		    i = 2*i+2;
		}
	    }
	}
	size -= 1;
	return ans;
    }
    public String peek() {
	if (size > 0) {
	    return data[0];
	}
	return "";
    }
    public void swap(String[] d, int a, int b) {
	String c = d[a];
	d[a] = d[b];
	d[b] = c;
    }
    public String toString() {
	String ans = "[";
	for (int i = 0; i < size; i++) {
	    ans += data[i] + ", ";
	}
	return ans + "]";
    }
    @SuppressWarnings("unchecked")
    private void resize() {
	String[] newData = new String[size() * 2];
	for (int i = 0; i < size(); i++) {
	    newData[i] = data[i];
	}
	data = newData;
    }
    public static void main(String[] args) {
        MyHeap test = new MyHeap();
	test.add("b");
	test.add("z");
	test.add("c");
	test.add("a");
	test.add("c");
	test.add("q");
	test.add("y");
	test.add("o");
	test.add("t");
	test.add("d");
	test.add("m");
	test.add("h");
	test.remove();
	test.remove();
        System.out.println(test);
    }
    
}
