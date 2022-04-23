package Practicing.Queues;

public class AB_Queue implements Queue{

	private int count;
	private int Size;
	private int Max_Size = 1000;
	private int f,r;
	private Object[] Q;
	
	public AB_Queue() {
		System.out.println("From \"AB_Queue()\": Array Based Queue has been Initialized with the default size (1000).");
		this.Size = Max_Size;
		this.count = 0;
		this.f = 0;
		this.r = 0;
		this.Q = new Object[this.Size];
	}
	
	public AB_Queue(int Size) {
		System.out.println("From \"AB_Queue(int Size)\": Array Based Queue has been Initialized with size = " + Size);
		this.Size = Size;
		this.count = 0;
		this.f = 0;
		this.r = 0;
		this.Q = new Object[this.Size];
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(count == 0)
			return true;
		else
			return false;
	}

	@Override
	public Object front() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			System.out.println("From \"front\": Queue is Empty.");
			return null;
		}
		else{
			return (int)Q[f];
		}
	}

	@Override
	public void enqueue(Object o) {
		// TODO Auto-generated method stub
		if(this.count == this.Size) {
			System.out.println("From \"enqueue\": Queue is Full.");
			return;
		}
		this.Q[r] = (int)o;
		if (this.r == this.Size-1)
			this.r = 0;
		else
			this.r++;
		this.count++;
		return;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			System.out.println("From \"dequeue\": Queue is Empty.");
			return null;
		}
		int temp = (int)this.Q[f];
		this.Q[f] = null;
		if(this.f == this.Size-1)
			this.f = 0;
		else
			this.f++;
		this.count--;
		return temp;
	}
	
	@Override
	public void showQueue() {
		if(this.isEmpty()) {
			System.out.println("From \"showQueue\": Queue is Empty");
			return;
		}
		System.out.print("[");
		if(this.f<this.r){
			for(int i = f ; i < this.r ; i++) {
				System.out.print((int)this.Q[i] + ", ");
			}
		} else {
			for(int i = f ; i < this.Size ; i++) {
				System.out.print((int)this.Q[i] + ", ");
			}
			for(int i = 0 ; i < this.r ; i++) {
				System.out.print((int)this.Q[i] + ", ");
			}
		}
		System.out.print("]\n");
	}

}
