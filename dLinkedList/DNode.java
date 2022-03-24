package Practicing.dLinkedList;

public class DNode {

	// Class Fields
	private String element;
	private DNode next;
	private DNode prev;
	
	// Constructor
	public DNode(String element, DNode next, DNode prev) {
		this.element = element;
		this.next = next;
		this.prev = prev;
	}

	// Setters & Getters
	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public DNode getNext() {
		return next;
	}

	public void setNext(DNode next) {
		this.next = next;
	}

	public DNode getPrev() {
		return prev;
	}

	public void setPrev(DNode prev) {
		this.prev = prev;
	}

	// toString
	@Override
	public String toString() {
		if(next != null && prev != null && element != null)
			return "DNode [element=" + element + ", next=" + next.element + ", prev=" + prev.element + "]";
		else if (element != null && next != null)
			return "DNode [element=" + element + ", next=" + next.element + ", prev= NULL]";
		else if (element != null && prev != null)
			return "DNode [element=" + element + ", next= NULL, prev= " + prev.element+"]";
		else if(element != null)
			return "DNode [element=" + element + ", next= NULL, prev= NULL]";
		else
			return "Element is NULL";
	}
}
