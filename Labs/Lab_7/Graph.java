package Labs.Lab_7;

public class Graph {

	// Fields
	private int numOfNodes;
	private GraphNode Start;
	
	// Constructors
	public Graph(char[][] Map) {
		if(Map.length >= 1) {
			this.numOfNodes = Map.length * Map[0].length;
			
//			GraphNode First = new GraphNode(Map[0][0], 0, 0);
//			GraphNode current = First;
			GraphNode[][] NodesArray = new GraphNode[Map.length][Map[0].length];
			
			for(int i = 0 ; i < Map.length ; i++) {
				for(int j = 0 ; j < Map[0].length ; j++) {					
						NodesArray[i][j] = new GraphNode(Map[i][j], i, j);
				}
			}
			
			for(int i = 0 ; i < Map.length ; i++) {
				for(int j = 0 ; j < Map[0].length ; j++) {

						// If the character is the S then this is our start point.
						if(NodesArray[i][j].getObj() == 'S')
							this.Start = NodesArray[i][j];
						// Adjacent Nodes Handling
						if(i != 0 ) {
							NodesArray[i][j].getAdjGNs()[0] = NodesArray[i-1][j];
						}
						if(i != Map.length - 1) {
							NodesArray[i][j].getAdjGNs()[3] = NodesArray[i+1][j];
						}
						if(j != 0) {
							NodesArray[i][j].getAdjGNs()[2] = NodesArray[i][j-1];
						}
						if(j != Map[0].length - 1) {
							NodesArray[i][j].getAdjGNs()[1] = NodesArray[i][j+1];
						}
						
				}
			}
		} else {
			this.numOfNodes = 0;
			this.Start = null;
			System.out.println("WARNING: Class Graph >> Constructor >> Array Size = 0.");
		}
	}

	// Setters and Getters
	public int getNumOfNodes() {
		return numOfNodes;
	}

	public GraphNode getStart() {
		return Start;
	}
	
}
