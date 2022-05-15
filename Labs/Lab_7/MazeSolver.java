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
		
		LLQueue myQueue = new LLQueue();
		Stack myStack = new Stack();
		Graph myGraph = new Graph(Map);
		GraphNode temp = myGraph.getStart();
		
		myQueue.enqueue(temp);
		temp.setVisitedFlag(true);
		
		while(myQueue.size() > 0) {
			
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
			
		}
		
		GraphNode tempPRO = temp;
		
		while(tempPRO != null) {
			myStack.push(new Point(tempPRO.getX(), tempPRO.getY()));
			tempPRO = tempPRO.getP();
		}
		
		// Printing
		Point tempNewPRO;
		Point[] ArrayOfPoints = new Point[myStack.size()]; 
		int ArrayOfPointsIndex = 0;
		System.out.print("BFS: ");
		while(myStack.size() > 1) {
			tempNewPRO = myStack.pop();
			ArrayOfPoints[ArrayOfPointsIndex] = tempNewPRO;
			ArrayOfPointsIndex++;
			System.out.print("{" +tempNewPRO.x + ", " + tempNewPRO.y +  "}, ");
		}
		tempNewPRO = myStack.pop();
		System.out.print("{" +tempNewPRO.x + ", " + tempNewPRO.y +  "}");
		ArrayOfPoints[ArrayOfPointsIndex] = tempNewPRO;
		return convertFromArrOfPointsToArrOfIntegers(ArrayOfPoints);
	}
	
	public int[][] convertFromArrOfPointsToArrOfIntegers(Point[] Input){
		int[][] Output = new int[Input.length][2];
		for(int i = 0 ; i < Input.length ; i++) {
			Output[i][0] = Input[i].x;
			Output[i][1] = Input[i].y;
		}
		return Output;
	}
	
}
