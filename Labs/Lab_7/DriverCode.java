package Labs.Lab_7;

public class DriverCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MazeSolver myMazeSolver = new MazeSolver();
		char[][] Map = { 
				{'#','#','.','.','S'},
				{'.','.','#','.','.'},
				{'.','#','#','.','.'},
				{'E','.','.','.','.'},
				{'.','.','#','#','#'}
		};
		myMazeSolver.solveBFS(Map);
		
	}

}
