import java.util.Iterator;
public class MyLinkedListImproved<T extends Comparable<T>> {
Node start;
    Node end;
    int size;
    public MyLinkedListImproved() {
	size = 0;
	start = null;
	end = null;
    }
    private Node getNode(int index) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	Node ans = start;
	for (int i = 0; i < index; i++) {
	    ans = ans.getNext();
	}
	return ans;
    }
    public String toString() {
	String ans = "";
	Node a = start;
	ans += "[";
	while (a != null) {
	    ans += a.toString();
	    ans += ", ";
	    a = a.getNext();
	}
	if (size > 0) {
	    ans = ans.substring(0, ans.length()-2);
	    return ans + "]";
	}
	else {
	    return "[]";
	}
    }
    public void clear() {
	start = null;
	end = null;
	size = 0;
    }
    public int size() {
	return size;
    }
    public T get(int index) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
        Node a = start;
        a = getNode(index);
	return a.getValue();
    }
    public T set(int index, T value) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	Node a = start;
        a = getNode(index);
        T ans = a.getValue();
	a.setValue(value);
	return ans;
    }
    public int indexOf(T value) {
	Node a = start;
	int count = 0;
        for (int i = 0; i < size; i++) {
	    if (a.getValue().equals(value)) {
		return count;
	    }
	    a = a.getNext();
	    count+=1;
	}
	return -1;
    }
    public boolean add(T newData) {
	Node ans = new Node(end, null, newData);
	if (size == 0) {
	    start = ans;
	}
	else {
	    end.setNext(ans);
	}
	end = ans;
	size+=1;
	return true;
    }
    public void add(int index, T value) {
	if (index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException();
	}
	if (size == 0) {
	    Node ans = new Node(null, null, value);
	    start = ans;
	    end = ans;
	    size +=1;
	    return;
	}
	if (index >= size) {
	    Node ans = new Node(null, null, value);
	    Node a = end;
	    ans.setPrev(a);
	    a.setNext(ans);
	    end = ans;
	    size += 1;
	}
	else if (index == 0) {
	    Node ans = new Node(null, null, value);
	    ans.setNext(start);
	    start.setPrev(ans);
	    start = ans;
	    size+=1;
	}
	else {
	    Node ans = new Node(null, null, value);
	    Node storeLo = start;
	    storeLo = getNode(index);
	    Node storeHi = storeLo;
	    storeLo = storeLo.getPrev();
	    ans.setPrev(storeLo);
	    ans.setNext(storeHi);
	    storeLo.setNext(ans);
	    storeHi.setPrev(ans);
	    size+=1;
	}
    }
    public boolean remove(T value) {
	Node a = start;
        while (a != null) {
	    if (a.getValue().equals(value)) {
		if (a.getNext() != null && a.getPrev() != null) {
		    Node before = a.getPrev();
		    Node after = a.getNext();
		    before.setNext(after);
		    after.setPrev(before);
		}
		if (a.getNext() == null) {
		    Node before = a.getPrev();
		    before.setNext(null);
		    end = before;
		}
		if (a.getPrev() == null) {
		    Node after = a.getNext();
		    after.setPrev(null);
		    start = after;
		}
		size -=1;
		return true;
	    }
	    a = a.getNext();
	}
	return false;
    }
    public T remove(int index) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	Node a = start;
	a = getNode(index);
	if (a.getNext() == null) {
	    Node before = a.getPrev();
	    before.setNext(null);
	    end = before;
	    size -=1;
	    return a.getValue();
	}
	else if (a.getPrev() == null) {
	    Node after = a.getNext();
	    after.setPrev(null);
	    start = after;
	    size-=1;
	    return a.getValue();
	}
        else {
	    Node before = a.getPrev();
	    Node after = a.getNext();
	    before.setNext(after);
	    after.setPrev(before);
	    size -=1;
	    return a.getValue();
	}
    }
    
    private class Node {
	private T data;
	private Node next;
	private Node prev;
	public Node() {
	    prev = null;
	    next = null;
	    data = null;
	}
	public Node(Node before, Node after, T val) {
	    prev = before;
	    next = after;
	    data = val;
	}
	public Node getNext() {
	    return next;
	}
	private void setNext(Node ahead) {
	    next = ahead;
	}
	public Node getPrev() {
	    return prev;
	}
	private void setPrev(Node back) {
	    prev = back;
	}
	public T getValue() {
	    return data;
	}
	private void setValue(T value) {
	    data = value;
	}
	public String toString() {
	    return ""+data;
	}
    }
    public Iterator<T> iterator() {
	return new LLIterator(start, end);
    }
    
    private class LLIterator implements Iterator<T> {
	Node start;
	Node end;
	public LLIterator(Node begin, Node stop) {
	    start = begin;
	    end = stop;
	}
    }
}
