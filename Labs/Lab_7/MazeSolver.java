package Labs.Lab_7;

import java.awt.Point;
import java.util.*;

public class MazeSolver{
	
//	@Override
	public int[][] solveDFS(){
		return null;
	}
	
//	@Override
	public int[][] solveBFS(char[][] Map){
		Point[] Path;
		Queue<GraphNode> myQueue = new LinkedList<>();
		Stack<Point> myStack = new Stack();
		Graph myGraph = new Graph(Map);
		GraphNode temp = myGraph.getStart();
		myQueue.add(temp);
		temp.setVisitedFlag(true);
		
		while(myQueue.size() > 0) {
			temp = myQueue.remove();
			temp.setVisitedFlag(true);
			if(temp.getObj() == 'E') {
				break;
			}
			for(int i = 0 ; i < 4 ; i++) {
				if(temp.getAdjGNs()[i] != null){	
					if( !temp.getAdjGNs()[i].isVisitedFlag() && temp.getAdjGNs()[i].getObj() != '#') {
						myQueue.add(temp.getAdjGNs()[i]);
						temp.getAdjGNs()[i].setP(temp);
					}
				}
			}
		}
		
		
		
//		Path = new Point[50];
//		int u = 49;
		GraphNode tempPRO = temp;
		while(tempPRO != null) {
			myStack.push(new Point(tempPRO.getX(), tempPRO.getY()));
			tempPRO = tempPRO.getP();
		}
//		while(tempPRO.getP() != null) {
//			if(tempPRO.getP() == null) {
//				System.out.println("WARNING: In SolveDFS >> \"While(PointsCounter >= 0)\"");
//				Path[u] = new Point(tempPRO.getX(),tempPRO.getY());
//				tempPRO = null;
//			} else {
//			Path[u] = new Point(tempPRO.getX(),tempPRO.getY());
//			tempPRO = tempPRO.getP();
////			PointsCounter--;
//			}
//			u--;
//		}
		
		// Printing
		Point tempNewPRO;
		System.out.print("[");
		while(myStack.size() > 1) {
			tempNewPRO = myStack.pop();
			System.out.print("(" +tempNewPRO.x + ", " + tempNewPRO.y +  "), ");
		}
		tempNewPRO = myStack.pop();
		System.out.print("(" +tempNewPRO.x + ", " + tempNewPRO.y +  ")]");
		return null;
	}
	
}
