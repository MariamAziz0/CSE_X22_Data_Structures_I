package Labs.Lab_7;


import java.io.*;

public class MyStack {
	private cell top;
    private int size;
    //constructor
    public MyStack(cell top,int size) {
        
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
    public cell pop(){
        try {
            cell temp = top;
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
    public cell peek(){
        try{
        return top;
        }
        catch(NullPointerException e){
            System.exit(0);
            return null;
        }
    }
    //-------------------------------------------------------------------------------------------------------------
    public void push(int I , int J , char A , cell p) {
        cell node = new cell(I, J ,A,top,p);
        top=node;
        size++;
    }
    //-------------------------------------------------------------------------------------------------------------
}
