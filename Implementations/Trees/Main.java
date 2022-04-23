package Practicing.Trees;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  TNode treeRootNode = new TNode(null);
		  treeRootNode.setElement("root");
		  Tree myTree = new Tree(treeRootNode);
		  // add child to root node 
		  TNode childNode1 = myTree.addChild(treeRootNode, "child-1");
		  // add child to the child node created above
		  TNode childNode11 = myTree.addChild(childNode1, "child-11");
		  TNode childNode12 = myTree.addChild(childNode1, "child-12");
		   
		   
		  // add child to root node
		  TNode childNode2 = myTree.addChild(treeRootNode, "child-2");
		  // add child to the child node created above
		  TNode childNode21 = myTree.addChild(childNode2, "child-21");
		 
		   
		  myTree.printTree(treeRootNode, " ");
		  
		  System.out.println(myTree.Element(childNode2));
		  
		  System.out.println(myTree.Root().getElement());
		  
		  System.out.println(myTree.Parent(childNode12).getElement());
		   
		  System.out.println(myTree.Size());
		  
		  System.out.println(myTree.isEmpty());
		  
		  myTree.Replace(childNode2, childNode1);
		  
		  myTree.printTree(treeRootNode, " ");
		  
		  System.out.println(myTree.isExternal(childNode1));
		  System.out.println(myTree.isInternal(childNode1));
		  System.out.println(myTree.isRoot(childNode1));
		  System.out.println(myTree.isRoot(treeRootNode));
		  
		
	}

}
