package Labs.Lab_7;

public interface IMazeSolver {
	
	/**
	* Read the maze file, and solve it using Breadth First Search
	* @param maze maze file
	* @return the coordinates of the found path from point �S�
	*
	to point �E� inclusive, or null if no path is found.
	*/
	public int[][] solveBFS();
	/**
	* Read the maze file, and solve it using Depth First Search
	* @param maze maze file
	* @return the coordinates of the found path from point �S�
	*
	to point �E� inclusive, or null if no path is found.
	*/
	public int[][] solveDFS();

}
