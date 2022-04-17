package Practicing.Trees;

import java.util.List;

public class Tree implements TreeInterface{
	
	private int Size = 0;
	private TNode Root;
	
	public Tree(TNode Root) {
		this.Root = Root;
		this.Size++;
	}
	
	public TNode addChild(TNode parent, Object Obj) {
	TNode node = new TNode(parent);
	node.setElement(Obj);
	parent.getChildren().add(node);
	this.Size++;
	return node;
	}
	
	public void printTree(TNode TreeRootNode,String appender) {
		System.out.println(appender + TreeRootNode.getElement());
		for (TNode each : TreeRootNode.getChildren()) {
		   printTree(each, appender + appender);
		   }
	}

	@Override
	public Object Element(TNode v) {
		// TODO Auto-generated method stub
		return v.getElement();
	}

	@Override
	public TNode Root() {
		// TODO Auto-generated method stub
		return this.Root;
	}

	@Override
	public TNode Parent(TNode v) {
		// TODO Auto-generated method stub
		return v.getParent();
	}

	@Override
	public List Children(TNode v) {
		// TODO Auto-generated method stub
		return v.getChildren();
	}

	@Override
	public int Size() {
		// TODO Auto-generated method stub
		return this.Size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.Size == 0)
			return true;
		return false;
	}

	@Override
	public void Replace(TNode v, TNode e) {
		// TODO Auto-generated method stub
		v.getParent().getChildren().add(e);
		v.getParent().getChildren().remove(v);
	}

	@Override
	public boolean isInternal(TNode v) {
		// TODO Auto-generated method stub
		if(v.getChildren().isEmpty())
			return false;
		return true;
	}

	@Override
	public boolean isExternal(TNode v) {
		// TODO Auto-generated method stub
		if(v.getChildren().isEmpty())
			return true;
		return false;
	}

	@Override
	public boolean isRoot(TNode v) {
		// TODO Auto-generated method stub
		if(v == this.Root)
			return true;
		return false;
	}
	
	
	
	
	
}
