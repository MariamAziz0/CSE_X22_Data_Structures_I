package Labs.Lab_7;

import java.awt.Point;

public class Stack {
	// Fields
    /**
     * Field Size: Number of elements in the stack.
     */
    private int Size = 0;
    /**
     * Field top: Pointing the Top node that is accessible.
     */
    private Node top = null;
    
//	@Override
	public Point pop(){
		// TODO Auto-generated method stub
		if(Size == 0) {
			System.out.println("Error");
			return null;
		}
		Point temp = top.getSecondElement();
		if(Size > 1){
		top.getPrev().setNext(null);
		top = top.getPrev();
		} else {
			top = null;
		}
		this.Size--;
		return temp;
	}

//	@Override
	public Point peek() {
		// TODO Auto-generated method stub
		if(Size == 0)
			return null;
		return top.getSecondElement();
	}

//	@Override
	public void push(Point element) {
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

//	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(Size == 0)
			return true;
		return false;
	}

//	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Size;
	}
	
}
