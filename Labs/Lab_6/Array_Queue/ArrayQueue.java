package Labs.Lab_6.Array_Queue;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IQueue {
  /*** Inserts an item at the queue front.*/
  public void enqueue(Object item);
  /*** Removes the object at the queue rear and returns it.*/
  public Object dequeue();
  /*** Tests if this queue is empty.*/
  public boolean isEmpty();
  /*** Returns the number of elements in the queue*/
  public int size();
}

public class ArrayQueue implements IQueue {

	/*
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Class Fields:
	 */
	private int Max_Size = 1000;				// Max_Number of elements that can be stored in the queue.
	private int Current_Size = 0;				// Number of elements currently present in the queue.
	private Object[] Array;								// The Array of which the queue is built.
	private int F = 0;								// Front Index.
	private int R = 0;								// Rear Index. Index of the element after the last.
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	
	
	/*
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Constructors:
	 */
	public ArrayQueue() {
		Array = new Object[this.Max_Size];
	}
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	
	
	
	/*
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 *  Main method to run and test different cases.
	 */
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
		ArrayQueue myQueue = new ArrayQueue();
		for(int i = arr.length-1 ; i >= 0 ; i--) {
			myQueue.enqueue(arr[i]);
		}
		
		String tempChoice = sc.nextLine();
		switch(tempChoice){
			case "enqueue":
				break;
			case "dequeue":
				break;
			case "isEmpty":
				break;
			case "size":
				break;
			default:
				System.out.println("Error");
				break;
		}
    }
    // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    
    /*
     * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     * Standard Queue Methods
     */
	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if(this.Current_Size == this.Max_Size) {
			System.out.println("Error");						// If the Queue is full, Print "Error"
			return;
		}
		Array[R] = (int)item;									// Inserting the element
		R = (R+1) % this.Max_Size;							// Increment the rear pointer using the MOD Operation.
		this.Current_Size++;									// Increment the Queue Size.
		return;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if(this.Current_Size == 0) {
			System.out.println("Error");
			return null;
		}
		Object temp = Array[F];
		Array[F] = null;
		F = (F + 1) % this.Max_Size;
		this.Current_Size--;
		return temp;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.Current_Size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.Current_Size;
	}
	
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	
	/*
	 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	 * Supporting Methods.
	 */
	public void show() {
		System.out.print("[");
		if(this.Current_Size > 0) {
			int tempIndex = this.F;
			for(int i = 0 ; i < this.Current_Size - 1 ; i++) {
				System.out.print((int)Array[tempIndex]+ ", ");
				tempIndex++;
			}
			System.out.print((int)Array[tempIndex]);
		}
		System.out.print("]");
	}
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}