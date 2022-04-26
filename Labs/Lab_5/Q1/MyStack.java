package Labs.Lab_5.Q1;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IStack {
  
  /*** Removes the element at the top of stack and returns that element.
  * @return top of stack element, or through exception if empty
  */
  
  public Object pop();
  
  /*** Get the element at the top of stack without removing it from stack.
  * @return top of stack element, or through exception if empty
  */
  
  public Object peek();
  
  /*** Pushes an item onto the top of this stack.
  * @param object to insert*
  */
  
  public void push(Object element);
  
  /*** Tests if this stack is empty
  * @return true if stack empty
  */
  public boolean isEmpty();
  
  public int size();
}

class Node {
	
	// Node Fields
	private Object element;				// Element Stored in the node.					
	private Node next;						// Next Node pointed to from this node.
	private Node prev;						// Previous Node pointed to from this node.
	
	// Constructor
	public Node(Object element, Node next, Node prev) {		
		this.element = element;
		this.next = next;
		this.prev = prev;
	}
	
	// Setters & Getters.
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
	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	
}

/**
 * CSED - Level 1 - Term 2 - Course: DS I - Lab 5, "MyStack"  
 * Class Implements the Stack Data Structure using doubly linked list.
 * @author George Samy Wahba Beshay
 *
 */
public class MyStack implements IStack {

	/**
	 * Main Method.
	 * @param args
	 */
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
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
		MyStack stack = new MyStack();
		for(int i = 0 ; i < arr.length ; i++) {
			stack.push(arr[i]);
		}
		
		String temp = sc.nextLine();
		switch(temp) {
			case "push":
				int tempElement = sc.nextInt();
				stack.push(tempElement);
				stack.show();
				break;
			case "pop":
				if(stack.size() == 0) {
					System.out.println("Error");
					break;
				}	
				try {
				stack.pop();
				stack.show();
				}
				catch(Exception E){
					System.out.println("Error");
				}
				break;
			case "peek":
				try {
					int tempV = (int)stack.peek();
					System.out.println(tempV);
				}
				catch (Exception E) {
					System.out.println("Error");
				}
				break;
			case "isEmpty":
				boolean flag = stack.isEmpty();
				if(flag) {
					System.out.println("True");
				}
				else {
					System.out.println("False");
				}
				break;
			case "size":
				try {
				System.out.println(stack.size());
				}
				catch (Exception E) {
					System.out.println("0");
				}
				break;
			default:
				System.out.println("Error");
				break;
		}
    }

    // Fields
    /**
     * Field Size: Number of elements in the stack.
     */
    private int Size = 0;
    /**
     * Field top: Pointing the Top node that is accessible.
     */
    private Node top = null;
    
	@Override
	public Object pop(){
		// TODO Auto-generated method stub
		if(Size == 0) {
			System.out.println("Error");
			return null;
		}
		Object temp = top.getElement();
		if(Size > 1){
		top.getPrev().setNext(null);
		top = top.getPrev();
		} else {
			top = null;
		}
		this.Size--;
		return temp;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(Size == 0)
			return null;
		return top.getElement();
	}

	@Override
	public void push(Object element) {
		// TODO Auto-generated method stub
		if (top == null || Size == 0) {
			Node temp = new Node(element,null,null);
			this.top = temp;
			Size++;
			return;
		}
		Node temp = new Node(element,null,top);
		this.top.setNext(temp);
		this.top = temp;
		Size++;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(Size == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Size;
	}
	
	/**
	 * Method Objective: Print the stack to show its content, FOR ADMIN ONLY.
	 */
	public void show() {
		if(this.size() == 0) {
			System.out.println("[]");
			return;
		}
		Node temp = top;
		System.out.print("[");
		while(temp.getPrev() != null) {
			System.out.print((int)temp.getElement()+", ");
			temp = temp.getPrev();
		}
		System.out.print((int)temp.getElement()+"]");
	}
}