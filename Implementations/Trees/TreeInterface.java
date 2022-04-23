package Practicing.Trees;

import java.util.ArrayList;
import java.util.List;

public interface TreeInterface {

	public Object Element(TNode v);
	public TNode Root();
	public TNode Parent(TNode v);
	public List Children(TNode v);
	public int Size();
	public boolean isEmpty();
	public void Replace(TNode v,TNode e);
	public boolean isInternal(TNode v);
	public boolean isExternal(TNode v);
	public boolean isRoot(TNode v);
	
}
