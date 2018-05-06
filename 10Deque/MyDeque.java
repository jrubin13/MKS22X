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
	if (size()+1 >= data.length) {
	    resize();
	}
	if (size == 0) {
	    data[0] = value;
	    size += 1;
	    end += 1;
	    return;
	}
	data[size] = data[size-1];
	for (int i = 0; i < size-1; i++) {
	    swap(data, i, i+1);
	}
	data[0] = value;
	size += 1;
	end += 1;
    }
    public void addLast(E value) {
	if (value == null) {
	    throw new NullPointerException();
	}
	if (size()+1 >= data.length) {
	    resize();
	}
	if (size == 0) {
	    data[0] = value;
	    size += 1;
	    end += 1;
	    return;
	}
	if (size == data.length - 1) {
	    data[0] = value;
	    end = 0;
	    size += 1;
	    return;
	}
	data[end] = value;
	end += 1;
	size += 1;
    }
    public E removeFirst() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
        E temp = data[start];
	if (start == size - 1) {
	    start = 0;
	    size -= 1;
	    return temp;
	}
	start += 1;
	size -= 1;
	return temp;
    }
    public E removeLast() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	E temp = data[end-1];
	if (end == 0) {
	    end = size - 1;
	    size -= 1;
	    return temp;
	}
	end -= 1;
	size -= 1;
	return temp;
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
	for (int i = 0; i < size(); i++) {
	    newData[i] = data[i];
	}
	data = newData;
    }
    public void swap(E[] d, int a, int b) {
	E c = d[a];
	d[a] = d[b];
	d[b] = c;
    }
    public static void main(String[] args) {
	MyDeque<Integer> test = new MyDeque<>(4);
	test.addFirst(2);
	test.addLast(3);
	//System.out.println(Arrays.toString(test.data));
	//System.out.println(test.size);
	test.addFirst(1);
	//System.out.println(Arrays.toString(test.data));
	test.addLast(4);
	System.out.println(Arrays.toString(test.data));
	System.out.println(test.removeFirst());
	System.out.println(test.removeLast());
	System.out.println(Arrays.toString(test.data));
	
    }
}
