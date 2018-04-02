public class MyLinkedList {
    Node start;
    Node end;
    int size;
    public MyLinkedList() {
        start = Node.getNode(0);
	end = Node.getNode(0);
	size = 0;
    }
    private Node getNode(int index) {
	
    }
    
}

private class Node {
    private Integer data;
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
    public Integer getValue() {
	return data;
    }
    private void setValue(Integer new) {
	data = new;
    }
    public String toString() {
	
    }
}
