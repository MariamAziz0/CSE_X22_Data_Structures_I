package Labs.Lab_4;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface IPolynomialSolver {
    /**
    * Set polynomial terms (coefficients & exponents)
    * @param poly: name of the polynomial
    * @param terms: array of [coefficients][exponents]
    */
    void setPolynomial(char poly, int[][] terms);
  
    /**
    * Print the polynomial in ordered human readable representation
    * @param poly: name of the polynomial
    * @return: polynomial in the form like 27x^2+x-1
    */
    String print(char poly);
  
    /**
    * Clear the polynomial
    * @param poly: name of the polynomial
    */
      void clearPolynomial(char poly);
  
    /**
    * Evaluate the polynomial
    * @param poly: name of the polynomial
    * @param value: the polynomial constant value
    * @return the value of the polynomial
    */
    float evaluatePolynomial(char poly, float value);
  
    /**
    * Add two polynomials
    * @param poly1: first polynomial
    * @param poly2: second polynomial
    * @return the result polynomial
    */
    int[][] add(char poly1, char poly2);
  
    /**
    * Subtract two polynomials
    * @param poly1: first polynomial
    * @param poly2: second polynomial
    * @return the result polynomial*/
    int[][] subtract(char poly1, char poly2);
  
    /**
    * Multiply two polynomials
    * @param poly1: first polynomial
    * @param poly2: second polynomial
    * @return: the result polynomial
    */
    int[][] multiply(char poly1, char poly2);
}


public class PolynomialSolver implements IPolynomialSolver{
    public static void main(String[] args) {
         /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        PolynomialSolver x = new PolynomialSolver();
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        char tempChar;
        char tempChar2;
        switch (temp){
        case "set":
        	tempChar = sc.nextLine().charAt(0);
        	x.setPolynomial(tempChar, readArr());
        	break;
        case "print":
        	tempChar = sc.nextLine().charAt(0);
        	x.print(tempChar);
        	break;
        case "add":
        	tempChar = sc.nextLine().charAt(0);
        	tempChar2 = sc.nextLine().charAt(0);
        	x.setPolynomial('R', x.add(tempChar,tempChar2));
        	x.print('R');
        	break;
        case "sub":
        	tempChar = sc.nextLine().charAt(0);
        	tempChar2 = sc.nextLine().charAt(0);
        	x.setPolynomial('R', x.subtract(tempChar,tempChar2));
        	x.print('R');
        	break;
        case "mult":
        	tempChar = sc.nextLine().charAt(0);
        	tempChar2 = sc.nextLine().charAt(0);
        	x.setPolynomial('R', x.multiply(tempChar,tempChar2));
        	x.print('R');
        	break;
        case "clear":
        	tempChar = sc.nextLine().charAt(0);
        	x.clearPolynomial(tempChar);
        	break;
        case "eval":
        	tempChar = sc.nextLine().charAt(0);
        	int tempVar = sc.nextInt();
        	System.out.println(x.evaluatePolynomial(tempChar, tempVar));
        	break;
        default:
        	System.out.println("Error");
        	break;
        }
        if(sc.hasNextLine()) {System.out.println("Yes"); temp = sc.nextLine();}
        else {System.out.println("No");}
//        switch (temp){
//        case "set":
//        	tempChar = sc.nextLine().charAt(0);
//        	x.setPolynomial(tempChar, readArr());
//        	break;
//        case "print":
//        	tempChar = sc.nextLine().charAt(0);
//        	x.print(tempChar);
//        	break;
//        default:
//        	System.out.println("Error");
//        }
//        while(sc.hasNextLine()) {
//            switch (temp){
//            case "set":
//            	tempChar = sc.nextLine().charAt(0);
//            	x.setPolynomial(tempChar, readArr());
//            	break;
//            case "print":
//            	tempChar = sc.nextLine().charAt(0);
//            	x.print(tempChar);
//            	break;
//            default:
//            	System.out.println("Error");
//            	temp = sc.nextLine();
//            }
//        }
        sc.close();
        System.out.println("Finished.");
//        x.setPolynomial('A',readArr());
//        x.setPolynomial('B',readArr());
//        x.setPolynomial('R',x.multiply('A','B'));
//        x.print('R');
    }
    
    // Statics Fields Of Class "PolynomialSolver"
    public static SingleLinkedList[] arr = new SingleLinkedList[10];
    public static char[] arrChar = new char[10];
    public static int arrIndex = 0;

    // Static Methods:
    public static int[][] readArr(){
    	Scanner sc1 = new Scanner(System.in);
		String sin = sc1.nextLine().replaceAll("\\[|\\]", "");
  		String[] s = sin.split(",");
  		if (s.length == 1 && s[0].isEmpty()) {
  			int[][] arr = {{}};
  			sc1.close();
  			return arr;
  		} else {
  			int[][] arr = new int[s.length][1];
  			for(int i = 0; i < s.length; i++) {
  				arr[i][0] = Integer.parseInt(s[i]);
  			}
  			return arr;
  		}
    }
    
    public static int searchForChar(char c) {
    	int index = -1;
    	for(int i = 0 ; i < 10 ; i++) {
    		if(c == arrChar[i]) {
    			index = i;
    			break;
    		}
    	}
    	return index;
    }
    
    // Manipulation Methods
    @Override
    public void setPolynomial(char poly, int[][] terms) {
    	arrChar[arrIndex] = poly;
    	SingleLinkedList.Node myNode = new SingleLinkedList.Node(null,null);
    	arr[arrIndex] = new SingleLinkedList(myNode);
    	arr[arrIndex].setSize(0);
    	for(int i = terms.length-1 ; i >= 0 ; i--) {
    		arr[arrIndex].add(terms[i][0]);
    	}
//    	arr[arrIndex].show();
    	arrIndex++;
    }
    
    @Override
    public String print(char poly) {
        // TODO Auto-generated method stub
    	int tempIndex = searchForChar(poly);
    	if(arr[tempIndex].getSize()>0) {
    		if((int)arr[tempIndex].get((int)arr[tempIndex].getSize()-1)!=1 && (int)arr[tempIndex].get((int)arr[tempIndex].getSize()-1)!=0 && (int)arr[tempIndex].get((int)arr[tempIndex].getSize()-1)!=-1) {System.out.print((int)arr[tempIndex].get((int)arr[tempIndex].getSize()-1));}
    		if((int)arr[tempIndex].get((int)arr[tempIndex].getSize()-1)== -1){System.out.print("-");}
    		if((int)arr[tempIndex].getSize()-1 !=1 && (int)arr[tempIndex].getSize()-1 != 0) {
    			System.out.print("x");
    			System.out.print("^"+(int)(arr[tempIndex].getSize()-1));
    			}
    		if((int)arr[tempIndex].getSize()-1 == 1) {System.out.print("x");}
    	for(int i = (int)arr[tempIndex].getSize()-2; i > 0 ; i--) {
    		if((int)arr[tempIndex].get(i)<0) {System.out.print("-");}else {System.out.print("+");}
    		if((int)arr[tempIndex].get(i)!=1 && (int)arr[tempIndex].get(i)!=0 && (int)arr[tempIndex].get(i)!=-1) {System.out.print(Math.abs((int)arr[tempIndex].get(i)));}
    		if((int)arr[tempIndex].get(i)== -1){System.out.print("-");}
    		if(i !=1 && i != 0) {
    			System.out.print("x");
    			System.out.print("^"+i);
    			}
    		if(i == 1) {System.out.print("x");}
    	}
    	if((int)arr[tempIndex].get(0) != 0) {System.out.print("+" +(int)arr[tempIndex].get(0)+"\n");}
    	}
    	else System.out.println("[]") ;
    	return null;
    }

    @Override
    public void clearPolynomial(char poly) {
        // TODO Auto-generated method stub
    	int tempIndex = searchForChar(poly);
    	arr[tempIndex].clear();      
    }

    @Override
    public float evaluatePolynomial(char poly, float value) {
        // TODO Auto-generated method stub
    	float ans = 0;
    	int tempIndex = searchForChar(poly);
    	for(int i = 0 ; i < arr[tempIndex].getSize() ; i++) {
    		ans += ((int)arr[tempIndex].get(i)) * Math.pow(value, i);
    	}
        return ans;
    }

    public void reverese2D(int[][] arr) {
    	for(int i = 0 ; i < arr.length/2 ; i++) {
    		int temp = arr[i][0];
    		arr[i][0] = arr[arr.length-i-1][0];
    		arr[arr.length-i-1][0] = temp;
    	}
    }
    
    @Override
    public int[][] add(char poly1, char poly2) {
        // TODO Auto-generated method stub
    	int ind1 = searchForChar(poly1);
    	int ind2 = searchForChar(poly2);
    	int [][] output;
    	if(arr[ind1].getSize()>arr[ind2].getSize()) {
    		output = new int[(int)arr[ind1].getSize()][1];
    	} else {
    		output = new int[(int)arr[ind2].getSize()][1];
    	}
    	if(arr[ind1].getSize()==arr[ind2].getSize()) {
    		for(int i = 0 ; i < arr[ind1].getSize() ; i++) {
    			output[i][0] = (int)arr[ind1].get(i) + (int)arr[ind2].get(i);
    		}
    	} else if(arr[ind1].getSize() > arr[ind2].getSize()) {
    		for(int i = 0 ; i < arr[ind2].getSize() ; i++) {
    			output[i][0] = (int)arr[ind1].get(i) + (int)arr[ind2].get(i);
    		}
    		for(int i = (int)arr[ind2].getSize() ; i < (int)arr[ind1].getSize() ; i++) {
    			output[i][0] = (int)arr[ind1].get(i);
    		}
    	} else if(arr[ind2].getSize() > arr[ind1].getSize()) {
    		for(int i = 0 ; i < arr[ind1].getSize() ; i++) {
    			output[i][0] = (int)arr[ind1].get(i) + (int)arr[ind2].get(i);
    		}
    		for(int i = (int)arr[ind1].getSize() ; i < (int)arr[ind2].getSize() ; i++) {
    			output[i][0] = (int)arr[ind2].get(i);
    		}
    	}
    	reverese2D(output);
        return output;
    }

    @Override
    public int[][] subtract(char poly1, char poly2) {
        // TODO Auto-generated method stub
    	int ind1 = searchForChar(poly1);
    	int ind2 = searchForChar(poly2);
    	int [][] output;
    	if(arr[ind1].getSize()>arr[ind2].getSize()) {
    		output = new int[(int)arr[ind1].getSize()][1];
    	} else {
    		output = new int[(int)arr[ind2].getSize()][1];
    	}
    	if(arr[ind1].getSize()==arr[ind2].getSize()) {
    		for(int i = 0 ; i < arr[ind1].getSize() ; i++) {
    			output[i][0] = (int)arr[ind1].get(i) - (int)arr[ind2].get(i);
    		}
    	} else if(arr[ind1].getSize() > arr[ind2].getSize()) {
    		for(int i = 0 ; i < arr[ind2].getSize() ; i++) {
    			output[i][0] = (int)arr[ind1].get(i) - (int)arr[ind2].get(i);
    		}
    		for(int i = (int)arr[ind2].getSize() ; i < (int)arr[ind1].getSize() ; i++) {
    			output[i][0] = (int)arr[ind1].get(i);
    		}
    	} else if(arr[ind2].getSize() > arr[ind1].getSize()) {
    		for(int i = 0 ; i < arr[ind1].getSize() ; i++) {
    			output[i][0] = (int)arr[ind1].get(i) - (int)arr[ind2].get(i);
    		}
    		for(int i = (int)arr[ind1].getSize() ; i < (int)arr[ind2].getSize() ; i++) {
    			output[i][0] = -(int)arr[ind2].get(i);
    		}
    	}
    	reverese2D(output);
        return output;
    }

    @Override
    public int[][] multiply(char poly1, char poly2) {
        // TODO Auto-generated method stub
    	int ind1 = searchForChar(poly1);
    	int ind2 = searchForChar(poly2);
    	int max;
    	if(arr[ind1].getSize() + arr[ind2].getSize()  > 2) {max = (int)arr[ind1].getSize() + (int)arr[ind1].getSize() - 1;}
    	else {max = 1;}
    	int [][] output = new int[max][1];
    	for(int i = 0 ; i < output.length ; i++) {
    		output[i][0] = 0;
    	}
    	for(int i = 0 ; i < arr[ind1].getSize() ; i++) {
    		for(int j = 0 ; j < arr[ind2].getSize() ; j++) {
    			output[i+j][0] += (int)arr[ind1].get(i) * (int)arr[ind2].get(j);
    		}
    	}
//    	if(arr[ind1].getSize()==arr[ind2].getSize()) {
//    		for(int i = 0 ; i < arr[ind1].getSize() ; i++) {
//    			output[i][0] = (int)arr[ind1].get(i) + (int)arr[ind2].get(i);
//    		}
//    	} else if(arr[ind1].getSize() > arr[ind2].getSize()) {
//    		for(int i = 0 ; i < arr[ind2].getSize() ; i++) {
//    			output[i][0] = (int)arr[ind1].get(i) + (int)arr[ind2].get(i);
//    		}
//    		for(int i = (int)arr[ind2].getSize() ; i < (int)arr[ind1].getSize() ; i++) {
//    			output[i][0] = (int)arr[ind1].get(i);
//    		}
//    	} else if(arr[ind2].getSize() > arr[ind1].getSize()) {
//    		for(int i = 0 ; i < arr[ind1].getSize() ; i++) {
//    			output[i][0] = (int)arr[ind1].get(i) + (int)arr[ind2].get(i);
//    		}
//    		for(int i = (int)arr[ind1].getSize() ; i < (int)arr[ind2].getSize() ; i++) {
//    			output[i][0] = (int)arr[ind2].get(i);
//    		}
//    	}
    	reverese2D(output);
        return output;
    }

}