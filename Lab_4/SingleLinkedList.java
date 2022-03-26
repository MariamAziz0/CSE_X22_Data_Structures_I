package Labs.Lab_4;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, Object element);
/**
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(Object element);
/**
* @param index
* @return the element at the specified position in this list.
*/
public Object get(int index);

/**
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, Object element);
/**
* Removes all of the elements from this list.
*/
public void clear();
/**
* @return true if this list contains no elements.
*/
public boolean isEmpty();
/**
* Removes the element at the specified position in this list.
* @param index
*/
public void remove(int index);
/**
* @return the number of elements in this list.
*/
public int size();
/**
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
*/
public ILinkedList sublist(int fromIndex, int toIndex);
/**
* @param o
* @return true if this list contains an element with the same value as the specified element.
*/
public boolean contains(Object o);
}


public class SingleLinkedList implements ILinkedList {
	/* Implement your linked list class here*/
	
	// Single Node Class Implementation:
	static class Node{
		
		// Class Fields
		private Object element;
		private Node next;
		
		// Constructor
		public Node(Object s,Node n){
			element = s;
			next = n;
		}
		
		// Getters & Setters
		public Object getObject() {
			return element;
		}

		public void setObject(Object element) {
			this.element = element;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		// toString
		public String toString() {
			if(next != null && element != null)
				return "Node [element=" + (String)element + ", next=" + (String)next.getObject() + "]";
			else if(element != null)
				return "Node [element=" + (String)element + ", next= Null]";
			else 
				return "Node is EMPTY.";
		}
	}
	
	// ------------------------------------------------------------------------------------------------------------
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
		Scanner sc = new Scanner(System.in);
		String sin = sc.nextLine().replaceAll("\\[|\\]", "");
  		String[] s = sin.split(", ");
  		SingleLinkedList myList;
  		if (s.length == 1 && s[0].isEmpty()) {
  			SingleLinkedList.Node myNode = new SingleLinkedList.Node(null, null);
  			myList = new SingleLinkedList(myNode); 
  			myList.setSize(0);
  		} else {
  			SingleLinkedList.Node myNode = new SingleLinkedList.Node(Integer.parseInt(s[0]),null);
			myList = new SingleLinkedList(myNode);
  			for(int i = 1; i < s.length; i++) {
  				myList.add(Integer.parseInt(s[i]));
  			}
  		}
  		String temp = sc.nextLine();
  		int x;
  		int index;
  		switch (temp) {
  		case "add":
  			x = sc.nextInt();
  			myList.add(x);
  			myList.show();
  			break;
  		case "addToIndex":
  			index = sc.nextInt();
  			x = sc.nextInt();
  			if(index >= (int)myList.getSize() || index < 0) {
  				System.out.println("Error");
  				break;
  			}
  			myList.add(index,x);
  			myList.show();
  			break;
  		case "get":
  			index = sc.nextInt();
  			if(index < 0 || index >= myList.getSize()) {
  			myList.get(index);
  			} else {
  				System.out.println((int)myList.get(index));
  			}
  			break;
  		case "set":
  			index = sc.nextInt();
  			x = sc.nextInt();
  			if (index < 0) {
  				System.out.println("Error");
  				break;  			
  			}
  			if(index >= (int)myList.getSize()) {
  				System.out.println("Error");
  				break;
  			}
  			myList.set(index, x);
  			myList.show();
  			break;
  		case "clear":
  			myList.clear();
  			myList.show();
  			break;
  		case "isEmpty":
  			if(myList.isEmpty())
  				System.out.println("True");
  			else
  				System.out.println("False");
  			break;
  		case "remove":
  			index = sc.nextInt();
  			if (index < 0 || index >= myList.getSize()) {
  				System.out.println("Error");
  				break;  			
  			}
  			boolean temp__ = (index < myList.getSize());
  			myList.remove(index);
  			if (temp__)
  				myList.show();
  			break;
  		case "sublist":
  			int firstIndex = sc.nextInt();
  			int lastIndex = sc.nextInt();
  			if(firstIndex < 0 || firstIndex >= (int)myList.getSize() || lastIndex >= (int)myList.getSize() || firstIndex > lastIndex || lastIndex < 0) {
  				System.out.println("Error");
  				break;
  			}
  			SingleLinkedList tempList = (SingleLinkedList)myList.sublist(firstIndex, lastIndex);
  			tempList.show();
  			break;
  		case "contains":
  			x = sc.nextInt();
  			if(myList.getSize() == 0) {
  				System.out.println("False");
  				break;
  			}
  			if(myList.contains(x)==true)
  				System.out.println("True");
  			else
  				System.out.println("False");
  			break;
  		case "size":
  			System.out.println(myList.size());
  			break;
  		default:
  			System.out.println("Error");
  		}
    }

	
	// Fields
	private Node head; // This will point to the head node of the linked list
	private Node tail;	// This will point to the tail node of the linked list
	private long size;		// This will be the number of elements in the list 
	
	// Constructor
	public SingleLinkedList(Node head){
		this.head = head;
		this.tail = head;
		if(head != null)
			this.size = 1;
		else
			this.size = 0;
		if (head != null) {
			Node currentNode = head;
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
				this.size++;
			}
		tail = currentNode;
		}
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

	public void setSize(int size) {
		this.size = size;
	}
	
	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	// Manipulation Methods
	public void add(int index, Object element) {
		if (index < 0) {									
			System.out.println("Error");
			 return;
		} else {
			if(index == 0) {		// inserting at the beginning
				if(this.getSize() > 0) {
					Node newNode = new Node(element,head);
					head = newNode;
					this.size++;
				} else {
					Node newNode = new Node(element,null);
					head = newNode;
					tail = newNode;
					size = 1;
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
				 Node newNode = new Node(element,currentNode.getNext());
				 currentNode.setNext(newNode);
				 this.size++;
			 } else if (currentIndex == index-1 && currentNode.getNext() == null) { 		// Inserting at the end (Extending the size)
				 Node newNode = new Node(element,null);
				 currentNode.setNext(newNode);
				 tail = newNode;
				 this.size++;
			 } else 
				 System.out.println("Error");
		}
		
	}

	public void add(Object element) {
		Node newN = new Node(element,null);
		if(this.getSize() != 0) {
			this.getTail().setNext(newN);
			tail = newN;
			this.size++;
		}
		else {
			this.head = newN;
			this.tail = newN;
			this.size = 1;
		}
	}

	public Object get(int index) {
		if(index < 0 || index >= size) {
			System.out.println("Error");
			return null;
		}
		else {
			int  currentIndex = 0;
			Node currentNode = head;
			while(currentIndex != index && currentIndex < size && currentNode.getNext() != null) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			if(currentIndex == index) {
				return currentNode.getObject();
			} else
				return null;
		}
	}

	public void set(int index, Object element) {
		if(index < 0 || index >= size) {
			System.out.println("Error");
		} else {
			Node currentNode = head;
			int currentIndex = 0;
			while(currentIndex != index) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			currentNode.setObject(element);
		}
	}

	public void clear() {
		this.head.setObject(null);
		this.tail.setObject(null);
		this.size = 0;
	}

	public boolean isEmpty() {
		if(head == null || tail == null || size == 0) {
			return true;
		} else
			return false;
	}

	public void remove(int index) {
		if(index < 0 || index >= size) {
			System.out.println("Error");
		}
		else {
			if(index == 0) {
				head = head.getNext();
				return;
			}
			int  currentIndex = 0;
			Node currentNode = head;
			while(currentIndex != index-1 && currentIndex < size) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			if(currentIndex == index-1) {
				currentNode.setNext(currentNode.getNext().getNext());
			} else {
				System.out.println("Error");
			}
		}
	}

	public int size() {
		return (int)getSize();
	}

	public Node getNode(int index) {
		if(index < 0 || index >= size) {
			System.out.println("Error");
			return null;
		}
		else {
			int  currentIndex = 0;
			Node currentNode = head;
			while(currentIndex != index && currentIndex < size) {
				currentIndex++;
				currentNode = currentNode.getNext();
			}
			if(currentIndex == index) {
				return currentNode;
			} else
				return null;
		}
	}
	
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if(fromIndex < 0 || toIndex >= size) {
			System.out.println("Error");
			SingleLinkedList u = new SingleLinkedList(null);
			return u;
		}
		Node begin = new Node((int)this.get(fromIndex),null);
		SingleLinkedList List = new SingleLinkedList(begin);
		for(int i = fromIndex+1 ; i < toIndex+1 ; i++) {
			List.add((int)this.get(i));
		}
		return List;
	}

	public boolean contains(Object o) {
		int  currentIndex = 0;
		Node currentNode = head;
		while((int)currentNode.getObject()  != (int)o && currentIndex < size && currentNode.getNext()!= null) {
			currentIndex++;
			currentNode = currentNode.getNext();
		}
		if((int)currentNode.getObject()  == (int)o) {
			return true;
		} else	
			return false;
	}
	
	public void show() {
		Node currentNode = this.head;
		if(currentNode.getObject() != null){
			System.out.print("[");
			while(currentNode.getNext() != null) {
				System.out.print(currentNode.getObject()+ ", ");
				currentNode = currentNode.getNext();
			}
			System.out.print(currentNode.getObject()+"]\n");
		} else 
			System.out.println("[]");
	}
}