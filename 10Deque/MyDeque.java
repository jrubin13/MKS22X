import java.util.*;
public class MyDeque<T> {
    public T[] data;
    @SuppressWarnings("unchecked")
    public MyDeque() {
	data = new T[10];
    }
    public MyDeque(int cap) {
	if (cap >= 0) {
	    data = new T[cap];
	}
	else {
	    throw new IllegalArgumentException();
	}
    }
    public int size() {
	return data.length;
    }
    public void addFirst(T value) {
	if (value == null) {
	    throw new NullPointerException();
	}
    }
    public void addLast(T value) {
	if (value == null) {
	    throw new NullPointerException();
	}
    }
    public T removeFirst() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	return;
    }
    public T removeLast() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	return;
    }
    public T getFirst() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	return;
    }
    public T getLast() {
	if (size() == 0) {
	    throw new NoSuchElementException();
	}
	return;
    }
}
