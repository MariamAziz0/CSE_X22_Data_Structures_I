package Practicing.BST;

public class BST {
	
	public static void main(String[] args) {
		BST myBST = new BST();
		myBST.traverse();
		myBST.insert(5);
		myBST.traverse();
		int[] tempArr = {5,1,23,561,1,79,2,3,8,9,9}; 
		for(int i = 0 ; i < tempArr.length ; i++) {
			myBST.insert(tempArr[i]);
		}
		myBST.traverse();
	}

	// Class Fields
	private BST_Node root;
	private int size;
	
	// Class Constructor
	public BST() {
		this.root = null;
		this.size = 0;
	}
	
	// Class Methods
	
	/* 	insert
 		delete 
 		traverse
 		getMax
 		getMin
 		isEmpty
	 */

	public boolean isEmpty() {
		if(this.size == 0)
			return true;
		else
			return false;
	}
	
	public Object getMin() {
		if(this.size == 0)
			return null;
		BST_Node temp = this.root;
		while(temp.getLeft() != null) {
			temp = temp.getLeft();
		}
		return temp.getKey();
	}
	
	public Object getMax() {
		if(this.size == 0)
			return null;
		BST_Node temp = this.root;
		while(temp.getRight() != null) {
			temp = temp.getRight();
		}
		return temp.getKey();
	}
	
	public void traverse() {
		System.out.print("[");
		traverseInOrder(this.root);
		System.out.print("]\n");
	}
	
	public void traverseInOrder(BST_Node N) {
		if(N != null) {
			traverseInOrder(N.getLeft());
			if(!N.isDeletion_Flag())
				System.out.print(N.getKey() + " ");
			traverseInOrder(N.getRight());
		}
	}
		
	public void insert(Object Data) {
			if(this.root == null) {
				this.root = new BST_Node(Data);
				return;
			} if(search(Data) != null){
				System.out.println("Element is already in the BST, can not duplicate elements.");
			} else {
				insert(Data, this.root);
			}
			this.size++;
			return;
	}
	
	public void insert(Object Data, BST_Node node) {
		if((int)Data < (int)node.getKey()) {
			if(node.getLeft() == null) {
				BST_Node newNode = new BST_Node(Data);
				node.setLeft(newNode);
			} else {
				insert(Data, node.getLeft());
			}
		} else if((int)Data > (int)node.getKey()) {
			if(node.getRight() == null) {
				BST_Node newNode = new BST_Node(Data);
				node.setRight(newNode);
			} else {
				insert(Data, node.getRight());
			}
		}
	}
	
	public void delete(Object Data){
		BST_Node temp = search(Data);
		if(temp == null) {
			System.out.println("Error: Element deletion requested for was not found");
			return;
		}
		if(temp != null) {
			temp.setDeletion_Flag(true);
		}
	}

	public BST_Node search(Object Data) {
		return Rec_search(Data,this.root);
	}
	
	public BST_Node Rec_search(Object Data, BST_Node node) {
		if(node == null) {
			return null;
		}
		if((int)node.getKey() == (int)Data) 
			return node;
		if((int) Data > (int)node.getKey()) 
			return Rec_search(Data,node.getRight());
		else if((int)Data < (int)node.getKey()) 
			return Rec_search(Data,node.getLeft());
		System.out.println("Error @ Rec_search");
		return null;
	}
}
