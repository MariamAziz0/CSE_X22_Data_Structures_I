package Labs.Lab_7;

import java.io.*;



class node {
	private int i;
	private int j;
	private char a;
	private node next;
	private node parent;
	
	public node() {
		
	}
	
	public node(int i, int j, char a, node next, node parent) {
		super();
		this.i = i;
		this.j = j;
		this.a = a;
		this.next = next;
		this.parent = parent;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	public char getA() {
		return a;
	}
	public void setA(char a) {
		this.a = a;
	}
	public node getNext() {
		return next;
	}
	public void setNext(node next) {
		this.next = next;
	}

	public node getParent() {
		return parent;
	}

	public void setParent(node parent) {
		this.parent = parent;
	}
	
	
	
}

//-----------------------------------------------------------------------------------------------------------
class MyStack {
	private node top;
    private int size;
    //constructor
    public MyStack(node top,int size) {
        
        this.top = top;
        this.size=size;
    }

    //------------------------------------------------------------------------------------------------------------
    public boolean isEmpty() {
        return (size==0);
    }
    //-------------------------------------------------------------------------------------------------------------
    public int size() {
        return size;
    }
    //-------------------------------------------------------------------------------------------------------------
    public node pop(){
        try {
            node temp = top;
            top=top.getNext();
            size--;
            return temp;
        }
        catch(NullPointerException e) {
            System.exit(0);
            return null;
        }
       
    }  
    //-------------------------------------------------------------------------------------------------------------
    public node peek(){
        try{
        return top;
        }
        catch(NullPointerException e){
            System.exit(0);
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------
    public void push(int I , int J , char A , node p) {
        node node = new node(I, J ,A,top,p);
        top=node;
        size++;
    }
    //-------------------------------------------------------------------------------------------------------------
}
public class MazeSolver {
	
	public MazeSolver() {
		
	}
	//--------------------------------------------------------------------------------------------------------------
	public int[][] solveDFS(int n,int m, char array_2d[][]){
		
		try {
		int[][] result=new int[50][2];
		MyStack s= new MyStack(null,0);
		int counter=0;
		int i,j;
		node t =new node();
		
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
								node temp = s.peek().getParent();
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
}