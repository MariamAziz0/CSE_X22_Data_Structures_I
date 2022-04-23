package Practicing.Queues;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Array Based Queue Test:
		AB_Queue myQueue = new AB_Queue(5);
		System.out.println(myQueue.size());
		myQueue.dequeue();
		myQueue.enqueue(5);
		myQueue.showQueue();
		System.out.println(myQueue.size());
		myQueue.enqueue(7);
		myQueue.enqueue(9);
		myQueue.enqueue(0);
		myQueue.enqueue(-15);
		myQueue.dequeue();
		myQueue.enqueue(3);
		myQueue.showQueue();
		myQueue.dequeue();
		myQueue.showQueue();
		myQueue.dequeue();
		myQueue.showQueue();
		myQueue.dequeue();
		myQueue.showQueue();
		System.out.println(myQueue.isEmpty());
		// ------------------------------------------------------
		
		System.out.println("\n-------------------------- SEPARATOR --------------------------\n");
		
		// Single Linked List Based Queue Test:
		SLLB_Queue myQueue_2 = new SLLB_Queue();
		System.out.println(myQueue_2.size());
		myQueue_2.dequeue();
		myQueue_2.enqueue(5);
		myQueue_2.showQueue();
		System.out.println(myQueue_2.size());
		myQueue_2.enqueue(7);
		myQueue_2.enqueue(9);
		myQueue_2.enqueue(0);
		myQueue_2.enqueue(-15);
		myQueue_2.dequeue();
		myQueue_2.enqueue(3);
		myQueue_2.showQueue();
		myQueue_2.dequeue();
		myQueue_2.showQueue();
		myQueue_2.dequeue();
		myQueue_2.showQueue();
		myQueue_2.dequeue();
		myQueue_2.showQueue();
		System.out.println(myQueue_2.isEmpty());
		// ------------------------------------------------------
		
	}

}
