package Practicing.Queues;

public class SLLB_Queue implements Queue{

	private int count;
	private Node f,r;
	
	
	public SLLB_Queue() {
		System.out.println("From \"SLLB_Queue()\": Single Linked List Based Queue has been Initialized.");
		this.count = 0;
		this.f = null;
		this.r = null;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.count == 0)
			return true;
		else
			return false;
	}

	@Override
	public Object front() {
		// TODO Auto-generated method stub
		if(count == 0) {
			System.out.println("From \"front()\": Queue is Empty.");
			return null;
		}
		return this.f.getElement();
	}

	@Override
	public void enqueue(Object o) {
		// TODO Auto-generated method stub
		Node temp = new Node(o,null);
		if(this.count == 0) {
			this.f = temp;
			this.r = temp;
		} else {
			this.r.setNext(temp);
			this.r = temp;
		}
		count++;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if(this.count == 0) {
			System.out.println("From \"dequeue()\": Queue is Empty.");
			return null;
		}
		Object temp = this.f.getElement();
		this.f = this.f.getNext();
		this.count--;
		if(count == 0) {
			this.r = null;
		}
		return temp;
	}

	@Override
	public void showQueue() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			System.out.println("From \"showQueue\": Queue is Empty");
			return;
		}
		System.out.print("[");
		Node temp = this.f;
		for(int i = 0 ; i < this.count ; i++) {
			System.out.print((int)temp.getElement()+ ", ");
			temp = temp.getNext();
		}
		System.out.print("]\n");
	}

}
