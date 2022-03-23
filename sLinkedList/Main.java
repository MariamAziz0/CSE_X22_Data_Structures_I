package Practicing.sLinkedList;

public class Main {

	public static void main(String[] args) {
		Node myFirstNode = new Node(null,null);
		SLinkedList myList = new SLinkedList(myFirstNode);
		myList.show();
		myList.insert("Youssef");
		myList.show();
		myList.insert("Mohamed");
		myList.show();
		myList.insertAt("Khalid", 0);
		myList.show();
		System.out.println(myList.getHead().toString());
		myList.insertAtStart("Joseph");
		myList.show();
		System.out.println(myList.getHead().toString());
		myList.search("George");
		myList.delete(3);
		myList.show();
		myList.delete(0);
		myList.show();
		myList.delete(2);
		myList.show();
		myList.delete(1);
		myList.show();
		System.out.println(myList.getHead().toString());
		System.out.println(myList.toString());
		myList.delete(0);
		myList.show();
		System.out.println(myList.getHead().toString());
		System.out.println(myList.toString());
	}

}
