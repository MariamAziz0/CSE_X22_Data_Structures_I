package Labs.Lab_7;

public class GraphNode {

	// Fields
	private char obj;								// Object Stored in the node (probably a char)
	private int X;										// row 
	private int Y; 										// column
	private GraphNode[] AdjGNs = {null, null, null, null};				// Adjacent Nodes (4 Nodes) [N, E, W, S]
	private boolean visitedFlag;
	private GraphNode P;
	
	
	// Constructors
	public GraphNode(char obj, int X, int Y) {
		this.obj = obj;
		this.X = X;
		this.Y = Y;
		this.visitedFlag = false;
		this.P = null;
	}

	// Setters and Getters
	public char getObj() {
		return obj;
	}


	public void setObj(char obj) {
		this.obj = obj;
	}


	public int getX() {
		return X;
	}


	public void setX(int x) {
		X = x;
	}


	public int getY() {
		return Y;
	}


	public void setY(int y) {
		Y = y;
	}


	public GraphNode[] getAdjGNs() {
		return AdjGNs;
	}


	public void setAdjGNs(GraphNode[] adjGNs) {
		AdjGNs = adjGNs;
	}

	
	public boolean isVisitedFlag() {
		return visitedFlag;
	}

	
	public void setVisitedFlag(boolean visitedFlag) {
		this.visitedFlag = visitedFlag;
	}

	public GraphNode getP() {
		return P;
	}

	public void setP(GraphNode p) {
		P = p;
	}
	
	
}
