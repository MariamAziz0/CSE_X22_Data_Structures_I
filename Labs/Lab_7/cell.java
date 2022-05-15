package Labs.Lab_7;


public class cell {
	private int i;
	private int j;
	private char a;
	private cell next;
	private cell parent;
	
	public cell() {
		
	}
	
	public cell(int i, int j, char a, cell next, cell parent) {
		super();
		this.i = i;
		this.j = j;
		this.a = a;
		this.next = next;
		this.parent = parent;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public char getA() {
		return a;
	}
	public void setA(char a) {
		this.a = a;
	}
	public cell getNext() {
		return next;
	}
	public void setNext(cell next) {
		this.next = next;
	}

	public cell getParent() {
		return parent;
	}

	public void setParent(cell parent) {
		this.parent = parent;
	}
	
	
	
}