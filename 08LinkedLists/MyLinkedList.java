public class MyLinkedList {
    Node start;
    Node end;
    int size;
    public MyLinkedList() {
	size = 0;
	start = null;
	end = null;
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
	Node ans = new Node(end, null, newData);
	if (size > 0) {
	    a.setNext(ans);
	    //ans.setPrev(a);
	    a = a.getNext();
	}
	else {
	    start = ans;
	}
	end = a;
	//a.setValue(newData);
	size+=1;
	//end = a;
	return true;
    }
    public void add(int index, Integer value) {
	if (index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException();
	}
	/*Node a = end;
	if (index == size) {
	    add(value);
	}
	Node n = new Node(null, null, value);
	n.setPrev(a);
	a.setNext(n);
        n.setValue(a.getValue());
	end = n;
	a.getPrev();
	n.getPrev();
        for (int i = size; i > index; i--) {
	    n.setValue(a.getValue());
	    a.getPrev();
	    n.getPrev();
	}
	size+=1;*/
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
    public Integer remove(int index) {
	if (index < 0 || index >= size()) {
	    throw new IndexOutOfBoundsException();
	}
	Node a = start;
	a = getNode(index);
	Integer ans = a.getValue();
	Node next = a.getNext();
	a = a.getPrev();
	a.setNext(next);
	next.setPrev(a);
	size -= 1;
	return ans;
    }
    
    private class Node {
	private Integer data;
	private Node next;
	private Node prev;
	public Node() {
	    data = 0;
	    next = null;
	    prev = null;
	}
	public Node(Node before, Node after, Integer val) {
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
