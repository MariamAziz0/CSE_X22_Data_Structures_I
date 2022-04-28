package Labs.Lab_6.Linked_List_Queue;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IQueue {
	  /*** Inserts an item at the queue front.*/
	  public void enqueue(Object item);
	  /*** Removes the object at the queue rear and returnsit.*/
	  public Object dequeue();
	  /*** Tests if this queue is empty.*/
	  public boolean isEmpty();
	  /*** Returns the number of elements in the queue*/
	  public int size();
}

class Node{
	/*
	 * Class Fields
	 */
	private Node next;
	private Node prev;
	private Object element;
	
	
	/*
	 * Class Constructors
	 */
	public Node(Object element,Node prev) {
		this.element = element;
		this.prev = prev;
		this.next = null;
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


	public Object getElement() {
		return element;
	}


	public void setElement(Object element) {
		this.element = element;
	}
	
}

public class LinkedListQueue implements IQueue {
	/*
	 * Class Fields:
	 */
	private int Current_Size = 0;
	private Node Front = null;
	private Node Last = null;
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	
	
	/*
	 * Constructors
	 */
	public LinkedListQueue(){
		this.Front = null;
		this.Last = null;
		this.Current_Size = 0;
	}
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	
    	// Scanning the input.
    	Scanner sc = new Scanner(System.in);
    	String sin = sc.nextLine().replaceAll("\\[|\\]", "");
    	String[] s = sin.split(", ");;
		int[] arr = new int[s.length];
		if (s.length == 1 && s[0].isEmpty())
          arr = new int[]{};
		else {
			for(int i = 0; i < s.length; ++i)
				arr[s.length-i-1] = Integer.parseInt(s[i]);
		}
		
		// Copying Elements to Queue.
		LinkedListQueue myQueue = new LinkedListQueue();
		for(int i = 0 ; i < arr.length ; i++) {
				myQueue.enqueue(arr[i]);
		}
		
		
		String tempChoice = sc.nextLine();
		switch(tempChoice){
			case "enqueue":
				int tempValue = sc.nextInt();
				myQueue.enqueue(tempValue);
				myQueue.show();
				break;
			case "dequeue":
				if(myQueue.size() == 0) {
					System.out.println("Error");
					break;
				}
				myQueue.dequeue();
				myQueue.show();
				break;
			case "isEmpty":
				if(myQueue.isEmpty())
					System.out.println("True");
				else
					System.out.println("False");
				break;
			case "size":
				System.out.println(myQueue.size());
				break;
			default:
				System.out.println("Error");
				break;
		}
		
    }

	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if(this.Current_Size > 0) {
			Node tempNode = new Node(item, this.Last);
			this.Last.setNext(tempNode);
			this.Last = tempNode;
			this.Current_Size++;
		} else {
			Node tempNode = new Node(item, null);
			this.Last = tempNode;
			this.Front = tempNode;
			this.Current_Size++;
		}	
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if(this.Current_Size == 0) {
			System.out.println("Error");
			return null;
		}
		Object tempVar = this.Front.getElement();
		if(this.Current_Size == 1) {
			this.Front = null;
			this.Last = null;
			this.Current_Size--;
			return tempVar;
		}
		this.Front.getNext().setPrev(null);
		this.Front = this.Front.getNext();
		this.Current_Size--;
		return tempVar;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.Current_Size == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.Current_Size;
	}
	
	/*
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Supporting Methods.
	 */
	public void show() {
		System.out.print("[");
		if(this.Current_Size > 0) {
			Node tempNode = this.Last;
			for(int i = 0 ; i < this.Current_Size - 1 ; i++) {
				System.out.print((int)tempNode.getElement()+ ", ");
				tempNode = tempNode.getPrev();
			}
			System.out.print((int)tempNode.getElement());
		}
		System.out.print("]");
	}
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}