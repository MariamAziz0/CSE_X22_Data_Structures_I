package Labs.Lab_7;

import java.awt.Point;

public class MazeSolver{
	
//	@Override
	public int[][] solveDFS(){
		return null;
	}
	
//	@Override
	public int[][] solveBFS(char[][] Map){
		Point[] Path;
		int PointsCounter = 0;
		LLQueue myQueue = new LLQueue();
		Graph myGraph = new Graph(Map);
		GraphNode temp = myGraph.getStart();
		myQueue.enqueue(temp);
		temp.setVisitedFlag(true);
		
		while(!myQueue.isEmpty()) {
			temp = myQueue.dequeue();
			temp.setVisitedFlag(true);
			if(temp.getObj() == 'E') {
				break;
			}
			for(int i = 0 ; i < 4 ; i++) {
				if(temp.getAdjGNs()[i] != null){	
					if( !temp.getAdjGNs()[i].isVisitedFlag() && temp.getAdjGNs()[i].getObj() != '#') {
						myQueue.enqueue(temp.getAdjGNs()[i]);
						temp.getAdjGNs()[i].setP(temp);
					}
				}
			}
			PointsCounter++;
		}
		
		Path = new Point[50];
		int u = 49;
		GraphNode tempPRO = temp;
		while(tempPRO.getP() != null) {
			if(tempPRO.getP() == null) {
				System.out.println("WARNING: In SolveDFS >> \"While(PointsCounter >= 0)\"");
				Path[u] = new Point(tempPRO.getX(),tempPRO.getY());
				tempPRO = null;
			} else {
			Path[u] = new Point(tempPRO.getX(),tempPRO.getY());
			tempPRO = tempPRO.getP();
//			PointsCounter--;
			}
			u--;
		}
		
		// Printing 
		System.out.print("[");
		while(u < 49) {
			System.out.print("(" +Path[u].x + ", " + Path[u].y +  "), ");
			u++;
		}
		System.out.print("(" +Path[49].x + ", " + Path[49].y +  ")]");
		return null;
	}
	
}
