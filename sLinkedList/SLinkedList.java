package Practicing.sLinkedList;

public class SLinkedList {

	// Fields
	private Node head; // This will point to the head node of the linked list
	private long size;		// This will be the number of elements in the list 
	
	// Constructor
	public SLinkedList(Node head){
	this.head = head;
	if(head.getElement() != null)
		this.size = 1;
	else
		this.size = 0;
	}

	// Setters & Getters
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	
	// SLinkedList Manipulations methods:
	public Node getLast(){
		Node lastNode = head;
		while(lastNode.getNext() != null) {
			lastNode = lastNode.getNext();
		}
		return lastNode;
	}
	
	public void insert(String newS) {
		Node newN = new Node(newS,null);
		if(this.getSize() != 0)
			this.getLast().setNext(newN);
		else
			head = newN;
		this.size++;
	}
	public void insertAt(String newS,int index) {
		if (index < 0) {									
			System.out.println("Error: Index smaller than 0");
			 return;
		} else {
			if(index == 0) {		// inserting at the beginning
				Node newNode = new Node(newS,head);
				head = newNode;
				this.size++;
				return;
			}
			 int currentIndex = 0;
			 Node currentNode = head;
			 while(currentIndex != index-1 && currentNode.getNext() != null) {
			 currentIndex++;
			 currentNode = currentNode.getNext();
			 }
			 if(currentIndex == index-1 && currentNode.getNext() != null) {
				 Node newNode = new Node(newS,currentNode.getNext());
				 currentNode.setNext(newNode);
				 this.size++;
			 } else if (currentIndex == index-1 && currentNode.getNext() == null) { 		// Inserting at the end (Extending the size)
				 Node newNode = new Node(newS,null);
				 currentNode.setNext(newNode);
				 this.size++;
			 } else 
				 System.out.println("Error: Out of Range");
		}		 
	}
	
	public void insertAtStart(String newS) {
		Node newNode = new Node(newS,head);
		head = newNode;
		this.size++;
	}
	
	public void delete(int index) {
		if (index < 0 || index >= size) {									
			System.out.println("Error: Out of Range.");
			 return;
		} else {
			if(index == 0) {		// inserting at the beginning
				if(head.getNext() != null) {
					head = head.getNext();
					this.size--;
				} else {
					head.setElement(null);
					head.setNext(null);
				}
				return;
			}
			int currentIndex = 0;
			Node currentNode = head;
			while(currentIndex != index-1 && currentNode.getNext() != null) {
				 currentIndex++;
				 currentNode = currentNode.getNext();
			}
			if(currentIndex == index-1 && currentNode.getNext() != null) {
				 currentNode.setNext(currentNode.getNext().getNext());
				 this.size--;
			 } else if (currentIndex == index-1 && currentNode.getNext() == null) { 		// Inserting at the end (Extending the size)
				 currentNode.setNext(null);
				 this.size--;
			 } 
		}
	}
	
	public void searchByIndex(int index) {
		if(index < 0 || index >= size) {
			System.out.println("Error: Out of Range");
			return;
		}
		else {
			int  currentIndex = 0;
			Node currentNode = head;
			while(currentIndex != index && currentIndex < size) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			if(currentIndex == index)
				System.out.println("Element at index " + index + " is ->> " + currentNode.getElement());
		}	
	}
	
	public void search(String s) {
		if(size == 0) {
			System.out.println("Error: SLinked List is EMPTY.");
			return;
		}
		Node currentNode = head;
		int currentIndex = 0;
		while(currentNode.getElement() != s && currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
			currentIndex++;
		}
		if(currentNode.getElement() == s)
			System.out.println("Element Found at index = " + currentIndex);
		else
			System.out.println("Element Not Found.");
	}
	
	public void show() {
		Node currentNode = this.head;
		if(currentNode.getElement() != null){
			System.out.print("[");
			while(currentNode.getNext() != null) {
				System.out.print(currentNode.getElement()+ ", ");
				currentNode = currentNode.getNext();
			}
			System.out.print(currentNode.getElement()+"]\n");
		} else 
			System.out.println("SLinkedList is EMPTY.");
	}

	@Override
	public String toString() {
		if(head.getElement() != null)
			return "SLinkedList [head=" + head.getElement() + ", size=" + size + "]";
		else
			return "SLinkedList is EMPTY";
	}
}
