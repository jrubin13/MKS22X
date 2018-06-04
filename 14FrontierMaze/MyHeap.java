import java.util.*;
public class MyHeap<T extends Comparable<T>>{
    private T[] data;
    private boolean max;
    private int size;
    @SuppressWarnings("unchecked")
    public MyHeap() {
	data = (T[]) new Comparable[10];
	size = 0;
	max = false;
    }
    @SuppressWarnings("unchecked")
    public MyHeap(boolean type) {
	data = (T[]) new Comparable[10];
	size = 0;
        max = type;
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
}
