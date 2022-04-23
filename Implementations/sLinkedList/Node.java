package Practicing.sLinkedList;

public class Node {

	// Class Fields
	private String element;
	private Node next;
	
	// Constructor
	public Node(String s,Node n){
		element = s;
		next = n;
	}

	// Getters & Setters
	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		if(next != null && element != null)
			return "Node [element=" + element + ", next=" + next.getElement() + "]";
		else if(element != null)
			return "Node [element=" + element + ", next= Null]";
		else 
			return "Node is EMPTY.";
	}
	
}