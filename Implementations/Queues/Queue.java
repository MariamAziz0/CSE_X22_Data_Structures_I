package Practicing.Queues;

public interface Queue {

	public int size();										// Return number of elements stored inside the queue.
	public boolean isEmpty(); 						// Test whether the queue is empty or not.
	public Object front();								// return the front element of the queue without removing it.
	public void enqueue(Object o);				// Insert an element to the rear of the queue.
	public Object dequeue();							// Return and Remove the first element in the queue.
	public void showQueue();						// Display The Queue Elements.			
}