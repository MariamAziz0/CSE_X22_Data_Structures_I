package Practicing.Stacks;

import java.util.EmptyStackException;

public class ArrayStack implements Stack_Interface{
	
	public static final int CAPACITY = 1000;						// Capacity of the stack. (Default)
	private int capacity;														// Maximum capacity of the stack.
	private Object S[];														// S holds the elements of the stack.
	private int top = -1;													// The top Element of the stack.
	
	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int capacity) {
		this.capacity = capacity;
		S = new Object[capacity];
	}

	@Override
	public int size() {		
		return (top+1);
	}

	@Override
	public boolean isEmpty() {
		return (top < 0);
	}

	@Override
	public Object top(){
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return S[top];
	}

	@Override
	public void push(Object element){
		if(top == capacity-1) {
			System.out.println("Stack is Full.");
		} else {
		S[top+1]=element;
		top++;
		}
	}

	@Override
	public Object pop(){
		Object elem;
		if(isEmpty()) {
			System.out.println("Stack is Empty.");
		}
		elem = S[top];
		S[top--] = null;
		return elem;
	}
	
	public void show() {			// Method For Checking Only - 
		if(top>=0) {					// - Should not be available to user.
			System.out.print("(");
			for(int i = 0 ; i <= top-1 ; i++) {
				System.out.print(S[i]+ ", ");
			}
			System.out.print(S[top]);
			System.out.print(")\n");
		} else
			System.out.println("Stack is Empty.");
	}

}
