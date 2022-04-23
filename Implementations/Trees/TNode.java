package Practicing.Trees;

import java.util.ArrayList;
import java.util.List;

public class TNode {

	private Object Element;
	private final List<TNode> children = new ArrayList<>();
	private TNode parent;
	
	public TNode (TNode parent) {
		this.parent = parent;
	}
	public Object getElement() {
		return Element;
	}
	public List<TNode> getChildren() {
		return children;
	}
	public TNode getParent() {
		return parent;
	}
	public void setElement(Object element) {
		Element = element;
	}
	
}
