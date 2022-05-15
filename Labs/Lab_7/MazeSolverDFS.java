package Labs.Lab_7;

public class MazeSolverDFS {
	
	public MazeSolverDFS() {
		
	}
	//--------------------------------------------------------------------------------------------------------------
	public int[][] solveDFS(int n,int m, char array_2d[][]){
		
		try {
		int[][] result=new int[50][2];
		MyStack s= new MyStack(null,0);
		int counter=0;
		int i,j;
		cell t =new cell();
		
		boolean[][] visited=new boolean[n][m];
		
		for(int k=0;k<n;k++) {
			for(int l=0;l<m;l++) {
				visited[k][l]=false;
			}
		}
		
		for(int k=0;k<n;k++) {
			for(int l=0;l<m;l++) {
				if(array_2d[k][l]=='S') {
					s.push(k,l,'S',null);
					visited[k][l]=true;
					
					while(!s.isEmpty()) {
						t=s.pop();
						visited[t.getI()][t.getJ()]=true;
						
						if(t.getA()=='.' || t.getA()=='S') {
							result[counter][0]=t.getI();
							result[counter][1]=t.getJ();
							counter++;
						}
						
						if(t.getA()=='E') {
							result[counter][0]=t.getI();
							result[counter][1]=t.getJ();
							counter++;
							
							int[][] result_final=new int[counter][2];
							for(int q=0;q<counter;q++) {result_final[q][0]=result[q][0];result_final[q][1]=result[q][1];}
							return result_final;
						}
						
						if(t.getA()=='.' || t.getA()=='S') {
							i=t.getI();
							j=t.getJ();
							boolean child_found=false;
							
							if(j+1<m) {
								if(visited[i][j+1]==false){
									if(array_2d[i][j+1]=='.' || array_2d[i][j+1]=='E') {s.push(i, j+1, array_2d[i][j+1],t); child_found=true;}}
								}
								
							if(i-1>=0) {
								if(visited[i-1][j]==false){ 
									if(array_2d[i-1][j]=='.' || array_2d[i-1][j]=='E') {s.push(i-1, j, array_2d[i-1][j],t); child_found=true;}}
							}
							if(j-1>=0) {
								if(visited[i][j-1]==false) {
									if(array_2d[i][j-1]=='.'|| array_2d[i][j-1]=='E') {s.push(i,j-1,array_2d[i][j-1],t); child_found=true;}}
							}
							if(i+1<n) {
								if(visited[i+1][j]==false) {
									if(array_2d[i+1][j]=='.'|| array_2d[i+1][j]=='E') {s.push(i+1, j, array_2d[i+1][j],t); child_found=true;}}
							}
							if(child_found==false) {
								cell temp = s.peek().getParent();
								int i_temp= temp.getI();
								int j_temp= temp.getJ();
								for(int d=0;d<counter;d++) {
									if(result[d][0]==i_temp && result[d][1]==j_temp) {counter=d+1;}
								}
							}
						}
						
						
					}
				}
			}
		}
		
		return null;
		}
		catch(Exception e) {
			System.out.print("Error");
			return null;

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] array= {{'#','#','.','.','S'},
						{'.','.','#','.','.'},
						{'.','#','#','.','.'},
						{'E','.','.','.','.'},
						{'.','.','#','#','#'},};
		
		MazeSolverDFS obj=new MazeSolverDFS();
		
		int[][] result=obj.solveDFS(5, 5, array);
		if(result != null) {
		for(int i=0;i<result.length;i++) {
			System.out.println("(" + result[i][0] + "," + result[i][1] + ")");
		}
		}
		else {System.out.println("Error");}
	}

}
