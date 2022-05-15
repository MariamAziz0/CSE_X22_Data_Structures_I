package Labs.Lab_7;

import java.awt.Point;

public class Node {
	/*
	 * Class Fields
	 */
	private Node next;
	private Node prev;
	private GraphNode element;
	private Point secondElement;
	
	
	/*
	 * Class Constructors
	 */
	public Node(GraphNode element,Node prev) {
		this.element = element;
		this.prev = prev;
		this.next = null;
	}
	
	public Node(Point element, Node next, Node prev) {		
		this.secondElement = element;
		this.next = next;
		this.prev = prev;
	}
	
	
	/*
	 * Class Standard Methods (Getters & Setters) 
	 */
	public Node getNext() {
		return next;
	}


	public void setNext(Node next) {
		this.next = next;
	}


	public Node getPrev() {
		return prev;
	}


	public void setPrev(Node prev) {
		this.prev = prev;
	}


	public GraphNode getElement() {
		return element;
	}


	public void setElement(GraphNode element) {
		this.element = element;
	}

	public Point getSecondElement() {
		return secondElement;
	}

	public void setSecondElement(Point secondElement) {
		this.secondElement = secondElement;
	}
	
	
}
