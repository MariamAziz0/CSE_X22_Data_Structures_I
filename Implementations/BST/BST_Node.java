package Practicing.BST;

public class BST_Node {

	// Class Fields
	private Object key;
	private BST_Node left,right;
	private boolean Deletion_Flag;
	
	// Class Constructor
	public BST_Node(Object key){
		this.key = key;
		this.left = null;
		this.right = null;
		this.Deletion_Flag = false;
	}

	// Class Setters and Getters
	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public BST_Node getLeft() {
		return left;
	}

	public void setLeft(BST_Node left) {
		this.left = left;
	}

	public BST_Node getRight() {
		return right;
	}

	public void setRight(BST_Node right) {
		this.right = right;
	}

	public boolean isDeletion_Flag() {
		return Deletion_Flag;
	}

	public void setDeletion_Flag(boolean deletion_Flag) {
		Deletion_Flag = deletion_Flag;
	}

	
}
