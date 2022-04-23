package Practicing.Stacks;

public class main {

	public static void main(String[] args) {
				
		ArrayStack s1 = new ArrayStack();
		System.out.println("S1 Size = " + s1.size());
		s1.show();
		s1.push(5);
		s1.show();
		s1.push(7);
		s1.show();
		s1.push(-10);
		s1.show();
		System.out.println("Popped -> " + s1.pop());
		s1.show();
		System.out.println("Popped -> " + s1.pop());
		s1.show();
		System.out.println("S1 Size = " + s1.size());
		
	}
	
}
