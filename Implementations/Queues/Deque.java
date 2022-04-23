package Practicing.Queues;

public interface Deque {

	public int size();
	public boolean isEmpty();
	public Object getFirst();
	public Object getLast();
	public void insertFirst(Object element);
	public void insertLast(Object element);
	public Object removeFirst();
	public Object removeLast();
	
}
