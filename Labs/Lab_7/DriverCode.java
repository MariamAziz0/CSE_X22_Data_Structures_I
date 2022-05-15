package Labs.Lab_7;

import java.io.*;
import java.util.Scanner;

public class DriverCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File myFile = new File("E:\\College\\CSED Level 1 2021 - 2022\\Second Term\\Data Structures 1\\Java\\src\\Labs\\Lab_7\\TestCase.txt");
		// Note: if the .txt file is in the same directory you are working in, no need to mention the exact file path.
		
		Scanner sc = null;
		String temp;
		char[][] Map = null;
		int Rows = 0, Columns = 0;
		try {
			sc = new Scanner(myFile);
			if(sc.hasNextLine()) {
				temp = sc.nextLine();
				Rows = Integer.parseInt(temp.charAt(0)+"");
				Columns = Integer.parseInt(temp.charAt(2)+"");
				Map = new char[Rows][Columns];
			}
			while(sc.hasNext() && Rows > 0 && Columns > 0) {
				for(int i = 0 ; i < Rows ; i++) {
					temp = sc.nextLine();
					for(int j = 0 ; j < Columns ; j++) {
						Map[i][j] = temp.charAt(j);
					}
				}
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		MazeSolver myMazeSolver = new MazeSolver();
		myMazeSolver.solveBFS(Map);
		
	}

}
