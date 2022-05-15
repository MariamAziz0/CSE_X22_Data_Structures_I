package Labs.Lab_7;

public class LLQueue {

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
	public LLQueue(){
		this.Front = null;
		this.Last = null;
		this.Current_Size = 0;
	}
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	
	public void enqueue(GraphNode item) {
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
	
	public GraphNode dequeue() {
		// TODO Auto-generated method stub
		if(this.Current_Size == 0) {
			System.out.println("Error in dequeue");
			return null;
		}
		GraphNode tempVar = this.Front.getElement();
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
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.Current_Size == 0)
			return true;
		return false;
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return this.Current_Size;
	}
	
//	public void show() {
//		System.out.print("[");
//		if(this.Current_Size > 0) {
//			Node tempNode = this.Last;
//			for(int i = 0 ; i < this.Current_Size - 1 ; i++) {
//				System.out.print("("+(int)tempNode.getElement().getX()+ ", "+(int)tempNode.getElement().getY() + "), ");
//				tempNode = tempNode.getPrev();
//			}
//			System.out.print("("+(int)tempNode.getElement().getX()+ ", "+(int)tempNode.getElement().getY() + ")");
//		}
//		System.out.print("]");
//	}
	
	
	
}

//class Node{
//	/*
//	 * Class Fields
//	 */
//	private Node next;
//	private Node prev;
//	private GraphNode element;
//	
//	
//	/*
//	 * Class Constructors
//	 */
//	public Node(GraphNode element,Node prev) {
//		this.element = element;
//		this.prev = prev;
//		this.next = null;
//	}
//	
//	
//	/*
//	 * Class Standard Methods (Getters & Setters) 
//	 */
//	public Node getNext() {
//		return next;
//	}
//
//
//	public void setNext(Node next) {
//		this.next = next;
//	}
//
//
//	public Node getPrev() {
//		return prev;
//	}
//
//
//	public void setPrev(Node prev) {
//		this.prev = prev;
//	}
//
//
//	public GraphNode getElement() {
//		return element;
//	}
//
//
//	public void setElement(GraphNode element) {
//		this.element = element;
//	}
//}
