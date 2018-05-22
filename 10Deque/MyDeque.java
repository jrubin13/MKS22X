import java.util.*;
public class MyDeque<E> {
    private E[] data;
    private int size;
    private int start;
    private int end;
    @SuppressWarnings("unchecked")
    public MyDeque() {
	data = (E[]) new Object[10];
	size = 0;
	start = 0;
	end = 0;
    }
    @SuppressWarnings("unchecked")
    public MyDeque(int cap) {
	if (cap >= 0) {
	    data = (E[]) new Object[cap];
	    size = 0;
	    start = 0;
	    end = 0;
	}
	else {
	    throw new IllegalArgumentException();
	}
    }
    public int size() {
	return size;
    }
    public void addFirst(E value) {
	if (value == null) {
	    throw new NullPointerException();
	}
	if (size() >= data.length) {
	    resize();
	}
	if (size == 0) {
	    data[start] = value;
	    size += 1;
	    //end += 1;
	    start = 0;
	    return;
	}
	if (start != 0) {
	    data[start-1] = value;
	    start -= 1;
	}
	else {
	    data[data.length-1] = value;
	    start = data.length-1;
	}
	size += 1;
    }
    public void addLast(E value) {
	if (value == null) {
	    throw new NullPointerException();
	}
	if (size() >= data.length) {
	    resize();
	}
	if (size == 0) {
	    data[0] = value;
	    size += 1;
	    //end += 1;
	    return;
	}
	if (end >= data.length) {
	    data[0] = value;
	    end = 0;
	}
	else {
	    data[end+1] = value;
	    end += 1;
	}
	size += 1;
    }
    public E removeFirst() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
        E ans = data[start];
	if (start == data.length - 1) {
	    start = 0;
	    size -= 1;
	    return ans;
	}
	start += 1;
	size -= 1;
	return ans;
    }
    public E removeLast() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	E ans = data[end];
	if (end == 0) {
	    end = data.length-1;
	    size -= 1;
	    return ans;
	}
	end -= 1;
	size -= 1;
	return ans;
    }
    public E getFirst() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	return data[start];
    }
    public E getLast() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	return data[end];
    }
    @SuppressWarnings("unchecked")
    private void resize() {
	E[] newData = (E[]) new Object[size() * 2];
        int i = 0;
	//System.out.println(start);
	//System.out.println(end);
        if (start < end) {
	    for (int x = start; x <= end; x++) {
		newData[i] = data[x];
		i += 1;
	    }
	}
	else {
	    i = 0;
	    for (int x = start; x < data.length; x++) {
		newData[i] = data[x];
		i += 1;
	    }
	    for (int x = 0; x <= end; x++) {
		newData[i] = data[x];
		i+= 1;
	    }
	}
	data = newData;
	start = 0;
	end = size()-1;
    }
    public void swap(E[] d, int a, int b) {
	E c = d[a];
	d[a] = d[b];
	d[b] = c;
    }
    public static void main(String[] args) {
	MyDeque<Integer> test = new MyDeque<>(4);
	test.addFirst(2);
	System.out.println(Arrays.toString(test.data));
	test.addLast(3);
	System.out.println(Arrays.toString(test.data));
	test.addLast(6);
	System.out.println(Arrays.toString(test.data));
	test.addLast(8);
	System.out.println(Arrays.toString(test.data));
	test.addFirst(12);
        System.out.println(Arrays.toString(test.data));
	test.addFirst(0);
        System.out.println(Arrays.toString(test.data));
	//System.out.println(test.size);
	test.addFirst(1);
        System.out.println(Arrays.toString(test.data));
	test.addLast(4);
	System.out.println(test.start);
	System.out.println(test.end);
        System.out.println(Arrays.toString(test.data));
	System.out.println(test.removeFirst());
	System.out.println(test.removeLast());
	System.out.println(test.removeLast());
        System.out.println(Arrays.toString(test.data));
	
    }
}
