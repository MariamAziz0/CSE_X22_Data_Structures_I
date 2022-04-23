package Practicing.Queues;

public class Node {

	private Object element;
	private Node next;
	
	public Node() {
		this.element = null;
		this.next = null;
	}
	
	public Node(Object obj, Node n) {
		this.element = obj;
		this.next = n;
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
