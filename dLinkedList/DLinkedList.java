package Practicing.dLinkedList;

import Practicing.sLinkedList.Node;

public class DLinkedList {
	
	// Fields
	private DNode head;
	private DNode tail;
	private long size;
	
	// Constructor
	public DLinkedList(DNode head) {
		this.head = head;
		this.tail = head;
		if (head.getElement() != null)
			size = 1;
		else
			size = 0;
	}

	// Setters & Getters
	public DNode getHead() {
		return head;
	}

	public void setHead(DNode head) {
		this.head = head;
	}

	public DNode getTail() {
		return tail;
	}

	public void setTail(DNode tail) {
		this.tail = tail;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	// toString
	@Override
	public String toString() {
		if(head.getElement() != null)
			return "DLinkedList [head=" + head.getElement() + ", size=" + size + ", tail="+ tail.getElement()+ "]";
		else
			return "DLinkedList is EMPTY";
	}
	
	// Manipulations Methods
	public void insert(String newS) {
		DNode newN = new DNode(newS,null,null);
		if(this.getSize() != 0) {
			this.tail.setNext(newN);
			newN.setPrev(tail);
			tail = newN;
		}
		else {
			head = newN;
			tail = newN;
		}
		this.size++;
	}
	
	public void insertAt(String newS,int index) {
		if (index < 0) {									
			System.out.println("Error: Index smaller than 0.");
			 return;
		} else {
			if(index == 0) {		// inserting at the beginning
				DNode newNode = new DNode(newS,head,null);
				head.setPrev(newNode);
				head = newNode;
				this.size++;
				return;
			}
			 int currentIndex = 0;
			 DNode currentNode = head;
			 while(currentIndex != index-1 && currentNode.getNext() != null) {
			 currentIndex++;
			 currentNode = currentNode.getNext();
			 }
			 if(currentIndex == index-1 && currentNode.getNext() != null) {
				 DNode newNode = new DNode(newS,currentNode.getNext(),currentNode);
				 currentNode.getNext().setPrev(newNode);
				 currentNode.setNext(newNode);
				 this.size++;
			 } else if (currentIndex == index-1 && currentNode.getNext() == null) { 		// Inserting at the end (Extending the size)
				 DNode newNode = new DNode(newS,null,currentNode);
				 currentNode.setNext(newNode);
				 this.size++;
			 } else 
				 System.out.println("Error: Out of Range");
		}		 
	}
	
	public void insertAtStart(String newS) {
		DNode newNode = new DNode(newS,head,null);
		head.setPrev(newNode);
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
					head.setPrev(null);
					this.size--;
				} else {
					head.setElement(null);
					head.setNext(null);
					head.setPrev(null);
					this.size--;
				}
				return;
			}
			int currentIndex = 0;
			DNode currentNode = head;
			while(currentIndex != index-1 && currentNode.getNext() != null) {
				 currentIndex++;
				 currentNode = currentNode.getNext();
			}
			if(currentIndex == index-1 && currentNode.getNext() != null) {
				if(currentNode.getNext().getNext() != null) {
					currentNode.getNext().getNext().setPrev(currentNode);
					currentNode.setNext(currentNode.getNext().getNext());
				} else {
					currentNode.getNext().setPrev(null);
					currentNode.setNext(null);
					tail = currentNode;
				}
				 this.size--;
			 } else if (currentIndex == index-1 && currentNode.getNext() == null) { 		// Deleting at the end (Decreasing the size)
				 currentNode.setNext(null);																	// Logically will never happen.
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
			DNode currentNode = head;
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
			System.out.println("Error: DLinked List is EMPTY.");
			return;
		}
		DNode currentNode = head;
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
	
	public void getBefore(String s) {
		if(size == 0) {
			System.out.println("Error: DLinked List is EMPTY.");
			return;
		}
		DNode currentNode = head;
		int currentIndex = 0;
		while(currentNode.getElement() != s && currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
			currentIndex++;
		}
		if(currentNode.getElement() == s) {
			if(currentNode.getPrev() != null)
				System.out.println("Element Found before: " + s + "= " + (currentNode.getPrev()).getElement());
			else
				System.out.println("Error: No Element Before: " + s);
		} else
			System.out.println("Element Not Found .. Cannot find what is before it ..");
	}
	
	public void getAfter(String s) {
		if(size == 0) {
			System.out.println("Error: DLinked List is EMPTY.");
			return;
		}
		DNode currentNode = head;
		int currentIndex = 0;
		while(currentNode.getElement() != s && currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
			currentIndex++;
		}
		if(currentNode.getElement() == s) {
			if(currentNode.getNext() != null)
				System.out.println("Element Found After: " + s + "= " + currentNode.getNext().getElement());
			else
				System.out.println("Error: No Element After: " + s);
		} else
			System.out.println("Element Not Found .. Cannot find what is After it ..");
	}
	
	public void insertBefore(String sOld,String sNew) {
		if(size == 0) {
			System.out.println("Error: DLinked List is EMPTY, Cannot find element to insert something before it.");
			return;
		}
		DNode currentNode = head;
		int currentIndex = 0;
		while(currentNode.getElement() != sOld && currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
			currentIndex++;
		}
		if(currentNode.getElement() == sOld) {
			if(currentNode.getPrev() != null) {
				DNode newNode = new DNode(sNew,currentNode,currentNode.getPrev());
				currentNode.getPrev().setNext(newNode);
				currentNode.setPrev(newNode);
			}
			else {
				DNode newNode = new DNode(sNew,currentNode,null);
				currentNode.setPrev(newNode);
				head = newNode;
			}
			size++;
		} else
			System.out.println("Element: \"" + sOld + "\" was not Found .. Cannot Place element: \"" + sNew + "\" before it ..");
	}
	
	public void show() {
		DNode currentNode = this.head;
		if(currentNode.getElement() != null){
			System.out.print("[");
			while(currentNode.getNext() != null) {
				System.out.print(currentNode.getElement()+ ", ");
				currentNode = currentNode.getNext();
			}
			System.out.print(currentNode.getElement()+"]\n");
		} else 
			System.out.println("DLinkedList is EMPTY.");
	}
}
