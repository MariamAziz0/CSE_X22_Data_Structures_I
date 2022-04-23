package Practicing.Stacks;

public interface Stack_Interface {

	// Accessor Methods	
	public int size();																			// Return the number of elements stored in a stack.
	public boolean isEmpty();															// Test whether the stack is empty or not.
	public Object top();							// Return the top element.
	
	// Update Methods
	public void push(Object element);			// Insert an element onto the stack. 
	public Object pop();							// Return and remove the top element of the stack.
	
}
