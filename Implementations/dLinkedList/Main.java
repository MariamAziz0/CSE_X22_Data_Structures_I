package Practicing.dLinkedList;

public class Main {

	public static void main(String[] args) {
		
		DNode myFirstNode = new DNode(null,null,null);
		DLinkedList myList = new DLinkedList(myFirstNode);
		myList.show();
		myList.insert("Youssef");
		myList.show();
		myList.insert("Mohamed");
		myList.show();
		myList.insertAt("Khalid", 0);
		myList.show();
		System.out.println(myList.getHead().toString());
		System.out.println(myList.getTail().toString());
		myList.insertAtStart("Joseph");
		myList.show();
		System.out.println(myList.getHead().toString());
		System.out.println(myList.getTail().toString());
		myList.insertBefore("Joseph", "George");
		myList.search("George");
		myList.getBefore("George");
		myList.insertBefore("Not Found", "ABC");
		myList.show();
		myList.getBefore("Khalid");
		myList.getAfter("Mohamed");
		myList.delete(3);
		myList.show();
		myList.searchByIndex(2);
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
