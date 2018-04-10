public class MyLinkedList {
    Node start;
    Node end;
    int size;
    public MyLinkedList() {
	size = 0;
    }
    private Node getNode(int index) {
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
	int i = 0;
	while (i < size) {
	    ans += a.toString();
	    ans += ", ";
	    a = a.getNext();
	    i++;
	}
	ans = ans.substring(0, ans.length()-2);
	return ans + "]";
    }
    public void clear() {
	start = null;
	end = null;
	size = 0;
    }
    public int size() {
	return size;
    }
    public Integer get(int index) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
        Node a = start;
        a = getNode(index);
	return a.getValue();
    }
    public Integer set(int index, Integer value) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	Node a = start;
        a = getNode(index);
	Integer ans = a.getValue();
	a.setValue(value);
	return ans;
    }
    public int indexOf(Integer value) {
	Node a = start;
	int count = 0;
        for (int i = 0; i < size; i++) {
	    if (a.getValue() == value) {
		return count;
	    }
	    a = a.getNext();
	    count+=1;
	}
	return -1;
    }
    public boolean add(Integer newData) {
	Node a = end;
	Node ans = new Node();
	a.setNext(ans);
	ans.setPrev(a);
	a.getNext();
	a.setValue(newData);
	size+=1;
	return true;
    }
    public void add(int index, Integer value) {
	if (index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException();
	}
	Node a = new Node();
	Node b = end;
	b.setNext(a);
	a.setPrev(b);
	for(int i = size+1; i > index; i--) {
	    a.setValue(b.getValue());
	    a = a.getPrev();
	    b = b.getPrev();
	}
	b.setValue(value);
	size+=1;
    }
    public boolean remove(Integer value) {
	Node a = start;
	for (int i = 0; i < size; i++) {
	    if (a.getValue() == value) {
		Node next = a.getNext();
		a = a.getPrev();
		a.setNext(next);
		next.setPrev(a);
		size -= 1;
		return true;
	    }
	    a.getNext();
	}
	return false;
    }
    public boolean remove(int index) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	Node a = start;
	a = getNode(index);
	Node next = a.getNext();
	a = a.getPrev();
	a.setNext(next);
	next.setPrev(a);
	size -= 1;
	return true;
    }
    
    private class Node {
	private Integer data;
	private Node next;
	private Node prev;
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
	public Integer getValue() {
	    return data;
	}
	private void setValue(Integer value) {
	    data = value;
	}
	public String toString() {
	    return ""+data;
	}
    }
}
