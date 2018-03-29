public class MyLinkedList {
    Node start;
    Node end;
    int size;
    public MyLinkedList() {
	start = 0;
	end = 0;
	size = 0;
    }
    
}

private class Node {
    private int data;
    private Node next;
    private Node prev;
    public Node getNext() {
	return next;
    }
    private void setNext(Node new) {
        next = new;
    }
    public Node getPrev() {
	return prev;
    }
    private void setPrev(Node new) {
        prev = new;
    }
    public int getValue() {
	return data;
    }
    private void setValue(int new) {
	data = new;
    }
    public String toString() {
	
    }
}
