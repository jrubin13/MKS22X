import java.util.*;
public class MyHeap<T extends Comparable<T>> {
    private T[] data;
    private boolean max;
    private int size;
    @SuppressWarnings("unchecked")
    public MyHeap() {
	data = (T[]) new Comparable[10];
	size = 0;
	max = true;
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean type) {
	data = (T[]) new Comparable[10];
	size = 0;
        max = type;
    }
    @SuppressWarnings("unchecked")
    public static MyHeap heapify(int[] d, boolean type) {
	MyHeap<Integer> data = new MyHeap<>(type);
	//int[] ans = new int[d.length];
        for (int i = 0; i < d.length; i++) {
	    data.add(d[i]);
        }
	return data;
    }
    public int size() {
	return size;
    }
    public void add(T s) {
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
    public T remove() {
	if (size <= 0) {
	    throw new NoSuchElementException();
	}
	if (size == 10) {
	    resize();
	}
        T ans = data[0];
	data[0] = data[size-1];
	int i = 0;
	//System.out.println(Arrays.toString(data));
	//System.out.println(size());
	data[size-1] = null;
	if (max) {
	    while (2*i+2 < size-1) {
		if (data[i].compareTo(data[2*i+1]) < 0 &&
		    data[i].compareTo(data[2*i+2]) > 0) {
		    swap(data, i, 2*i+1);
		    i = 2*i+1;
		}
		else if (data[i].compareTo(data[2*i+1]) > 0 &&
			 data[i].compareTo(data[2*i+2]) < 0) {
		    swap(data, i, 2*i+2);
		    i = 2*i+2;
		}
		else {
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
	    //added this in to make heapsort work
	    if (2*i+1 < size-1) {
		if (data[i].compareTo(data[2*i+1]) < 0) {
		    swap(data,i, 2*i+1);
		}
	    }
	}
	else {
	    while (2*i+2 < size-1) {
		if (data[i].compareTo(data[2*i+1]) > 0 &&
		    data[i].compareTo(data[2*i+2]) < 0) {
		    swap(data, i, 2*i+1);
		    i = 2*i+1;
		}
		else if (data[i].compareTo(data[2*i+1]) < 0 &&
			 data[i].compareTo(data[2*i+2]) > 0) {
		    swap(data, i, 2*i+2);
		    i = 2*i+2;
		}
		else {
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
	    //added this in to make heapsort work
	    if (2*i+1 < size-1) {
		if (data[i].compareTo(data[2*i+1]) > 0) {
		    swap(data,i, 2*i+1);
		}
	    }
	}
	data[size] = null;
	size -= 1;
	return ans;
    }
    public T peek() {
	if (size > 0) {
	    return data[0];
	}
        throw new NoSuchElementException();
    }
    public void swap(T[] d, int a, int b) {
	T c = d[a];
	d[a] = d[b];
	d[b] = c;
    }
    public String toString() {
	String ans = "[";
	for (int i = 0; i < size; i++) {
	    ans += data[i] + ", ";
	}
	if (ans.length() > 2) {
	    return ans.substring(0, ans.length()-2) + "]";
	}
	return "[]";
    }
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newData = (T[]) new Comparable[size() * 2+1];
	for (int i = 0; i < size(); i++) {
	    newData[i] = data[i];
	}
	data = newData;
    }
    public static void main(String[] args) {
        MyHeap<Integer> test = new MyHeap<>(true);
	test.add(2);
	test.add(1);
	test.add(5);
	test.add(0);
	test.add(6);
	test.add(7);
	test.add(4);
	test.add(9);
	test.add(8);
	test.add(3);
	test.add(9);
	test.add(9);
	test.remove();
	test.remove();
	System.out.println(test);
	for (int i = 0; i < 10; i++) {
	    System.out.println(test.remove());
        }
        System.out.println(test);
        int[] test2 = {4,3,56,22,0,453,67};
	heapify(test2, true);
	System.out.println(Arrays.toString(test2));
	int[] test3 = {4,3,56,22,0,453,67};
	heapify(test3, false);
	System.out.println(Arrays.toString(test3));
    }
    
}
