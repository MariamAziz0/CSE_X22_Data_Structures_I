package Labs.Lab_4.Polynomial;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedList {
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, Object element);
/**
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(Object element);
/**
* @param index
* @return the element at the specified position in this list.
*/
public Object get(int index);

/**
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, Object element);
/**
* Removes all of the elements from this list.
*/
public void clear();
/**
* @return true if this list contains no elements.
*/
public boolean isEmpty();
/**
* Removes the element at the specified position in this list.
* @param index
*/
public void remove(int index);
/**
* @return the number of elements in this list.
*/
public int size();
/**
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
*/
public ILinkedList sublist(int fromIndex, int toIndex);
/**
* @param o
* @return true if this list contains an element with the same value as the specified element.
*/
public boolean contains(Object o);
}


class SingleLinkedList implements ILinkedList {
    /* Implement your linked list class here*/
    
    // Single Node Class Implementation:
    static class Node{
        
        // Class Fields
        private Object element;
        private Node next;
        
        // Constructor
        public Node(Object s,Node n){
            element = s;
            next = n;
        }
        
        // Getters & Setters
        public Object getObject() {
            return element;
        }

        public void setObject(Object element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        
        // toString
        public String toString() {
            if(next != null && element != null)
                return "Node [element=" + (String)element + ", next=" + (String)next.getObject() + "]";
            else if(element != null)
                return "Node [element=" + (String)element + ", next= Null]";
            else 
                return "Node is EMPTY.";
        }
    }
    
    // ------------------------------------------------------------------------------------------------------------
    // Fields
    private Node head; // This will point to the head node of the linked list
    private Node tail;    // This will point to the tail node of the linked list
    private long size;        // This will be the number of elements in the list 
    
    // Constructor
    public SingleLinkedList(Node head){
        this.head = head;
        this.tail = head;
        if(head != null)
            this.size = 1;
        else
            this.size = 0;
        if (head != null) {
            Node currentNode = head;
            while(currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
                this.size++;
            }
        tail = currentNode;
        }
    }
    
    // Setters & Getters
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public long getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    // Manipulation Methods
    public void add(int index, Object element) {
        if (index < 0) {                                    
            System.out.println("Error");
             return;
        } else {
            if(index == 0) {        // inserting at the beginning
                if(this.getSize() > 0) {
                    Node newNode = new Node(element,head);
                    head = newNode;
                    this.size++;
                } else {
                    Node newNode = new Node(element,null);
                    head = newNode;
                    tail = newNode;
                    size = 1;
                }
                return;
            }
             int currentIndex = 0;
             Node currentNode = head;
             while(currentIndex != index-1 && currentNode.getNext() != null) {
             currentIndex++;
             currentNode = currentNode.getNext();
             }
             if(currentIndex == index-1 && currentNode.getNext() != null) {
                 Node newNode = new Node(element,currentNode.getNext());
                 currentNode.setNext(newNode);
                 this.size++;
             } else if (currentIndex == index-1 && currentNode.getNext() == null) {         // Inserting at the end (Extending the size)
                 Node newNode = new Node(element,null);
                 currentNode.setNext(newNode);
                 tail = newNode;
                 this.size++;
             } else 
                 System.out.println("Error");
        }
        
    }

    public void add(Object element) {
        Node newN = new Node(element,null);
        if(this.getSize() != 0) {
            this.getTail().setNext(newN);
            tail = newN;
            this.size++;
        }
        else {
            this.head = newN;
            this.tail = newN;
            this.size = 1;
        }
    }

    public Object get(int index) {
        if(index < 0 || index >= size) {
            System.out.println("Error");
            return null;
        }
        else {
            int  currentIndex = 0;
            Node currentNode = head;
            while(currentIndex != index && currentIndex < size && currentNode.getNext() != null) {
                currentIndex++;
                currentNode = currentNode.getNext();
            }
            if(currentIndex == index) {
                return currentNode.getObject();
            } else
                return null;
        }
    }

    public void set(int index, Object element) {
        if(index < 0 || index >= size) {
            System.out.println("Error");
        } else {
            Node currentNode = head;
            int currentIndex = 0;
            while(currentIndex != index) {
                currentIndex++;
                currentNode = currentNode.getNext();
            }
            currentNode.setObject(element);
        }
    }

    public void clear() {
        this.head.setObject(null);
        this.tail.setObject(null);
        this.size = 0;
    }

    public boolean isEmpty() {
        if(head == null || tail == null || size == 0) {
            return true;
        } else
            return false;
    }

    public void remove(int index) {
        if(index < 0 || index >= size) {
            System.out.println("Error");
        }
        else {
            if(index == 0) {
                head = head.getNext();
                return;
            }
            int  currentIndex = 0;
            Node currentNode = head;
            while(currentIndex != index-1 && currentIndex < size) {
                currentIndex++;
                currentNode = currentNode.getNext();
            }
            if(currentIndex == index-1) {
                currentNode.setNext(currentNode.getNext().getNext());
            } else {
                System.out.println("Error");
            }
        }
    }

    public int size() {
        return (int)getSize();
    }

    public Node getNode(int index) {
        if(index < 0 || index >= size) {
            System.out.println("Error");
            return null;
        }
        else {
            int  currentIndex = 0;
            Node currentNode = head;
            while(currentIndex != index && currentIndex < size) {
                currentIndex++;
                currentNode = currentNode.getNext();
            }
            if(currentIndex == index) {
                return currentNode;
            } else
                return null;
        }
    }
    
    public ILinkedList sublist(int fromIndex, int toIndex) {
        if(fromIndex < 0 || toIndex >= size) {
            System.out.println("Error");
            SingleLinkedList u = new SingleLinkedList(null);
            return u;
        }
        Node begin = new Node((int)this.get(fromIndex),null);
        SingleLinkedList List = new SingleLinkedList(begin);
        for(int i = fromIndex+1 ; i < toIndex+1 ; i++) {
            List.add((int)this.get(i));
        }
        return List;
    }

    public boolean contains(Object o) {
        int  currentIndex = 0;
        Node currentNode = head;
        while((int)currentNode.getObject()  != (int)o && currentIndex < size && currentNode.getNext()!= null) {
            currentIndex++;
            currentNode = currentNode.getNext();
        }
        if((int)currentNode.getObject()  == (int)o) {
            return true;
        } else    
            return false;
    }
    
    public void show() {
        Node currentNode = this.head;
        if(currentNode.getObject() != null){
            System.out.print("[");
            while(currentNode.getNext() != null) {
                System.out.print(currentNode.getObject()+ ", ");
                currentNode = currentNode.getNext();
            }
            System.out.print(currentNode.getObject()+"]\n");
        } else 
            System.out.println("[]");
    }
}


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
//        Scanner sc = new Scanner(System.in);
        String temp;// = sc.nextLine();
        char tempChar;
        char tempChar2;
        temp = sc.nextLine();
        try {
        while(!temp.isEmpty()) {
//            temp = sc.nextLine();
            switch (temp){
            case "set":
                tempChar = sc.nextLine().charAt(0);
                if(tempChar != 'A' && tempChar != 'B' && tempChar != 'C') {System.out.println("Error");System.exit(0);}
                x.setPolynomial(tempChar, readArr());
                break;
            case "print":
                tempChar = sc.nextLine().charAt(0);
                if(tempChar != 'A' && tempChar != 'B' && tempChar != 'C') {System.out.println("Error");System.exit(0);}
                x.print(tempChar);
                break;
            case "add":
                tempChar = sc.nextLine().charAt(0);
                if(tempChar != 'A' && tempChar != 'B' && tempChar != 'C') {System.out.println("Error");System.exit(0);}
                tempChar2 = sc.nextLine().charAt(0);
                if(tempChar2 != 'A' && tempChar2 != 'B' && tempChar2 != 'C') {System.out.println("Error");System.exit(0);}
                x.setPolynomial('R', x.add(tempChar,tempChar2));
                x.print('R');
                break;
            case "sub":
                tempChar = sc.nextLine().charAt(0);
                if(tempChar != 'A' && tempChar != 'B' && tempChar != 'C') {System.out.println("Error");System.exit(0);}
                tempChar2 = sc.nextLine().charAt(0);
                if(tempChar2 != 'A' && tempChar2 != 'B' && tempChar2 != 'C') {System.out.println("Error");System.exit(0);}
                x.setPolynomial('R', x.subtract(tempChar,tempChar2));
                x.print('R');
                break;
            case "mult":
                tempChar = sc.nextLine().charAt(0);
                if(tempChar != 'A' && tempChar != 'B' && tempChar != 'C') {System.out.println("Error");System.exit(0);}
                tempChar2 = sc.nextLine().charAt(0);
                if(tempChar2 != 'A' && tempChar2 != 'B' && tempChar2 != 'C') {System.out.println("Error");System.exit(0);}
                x.setPolynomial('R', x.multiply(tempChar,tempChar2));
                x.print('R');
                break;
            case "clear":
                tempChar = sc.nextLine().charAt(0);
                if(tempChar != 'A' && tempChar != 'B' && tempChar != 'C') {System.out.println("Error");System.exit(0);}
                x.clearPolynomial(tempChar);
                x.print(tempChar);
                break;
            case "eval":
                tempChar = sc.nextLine().charAt(0);
                if(tempChar != 'A' && tempChar != 'B' && tempChar != 'C') {System.out.println("Error");System.exit(0);}
                int tempVar = sc.nextInt();
                System.out.println((int)x.evaluatePolynomial(tempChar, tempVar));
                break;
            default:
                System.out.println("Error");
                System.exit(0);
                break;
            }
            temp = sc.nextLine();
        } } catch(NoSuchElementException e) {return;}
   }

    
    // Statics Fields Of Class "PolynomialSolver"
    public static SingleLinkedList[] arr = new SingleLinkedList[10];
    public static char[] arrChar = new char[10];
    public static int arrIndex = 0;
    public static Scanner sc = new Scanner(System.in);

    // Static Methods:
    public static int[][] readArr(){
//        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = {};
          if(!sin.isEmpty()) {s = sin.split(",");}
          else {s = sin.split("");}
          if (s.length == 1 && s[0].isEmpty()) {
              int[][] arr = {{}};
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
        if (terms[0].length == 0) {System.out.println("Error");System.exit(0);}
        arrChar[arrIndex] = poly;
        SingleLinkedList.Node myNode = new SingleLinkedList.Node(null,null);
        arr[arrIndex] = new SingleLinkedList(myNode);
        arr[arrIndex].setSize(0);
        for(int i = terms.length-1 ; i >= 0 ; i--) {
            arr[arrIndex].add(terms[i][0]);
        }
//        arr[arrIndex].show();
        arrIndex++;
    }
    
    @Override
    public String print(char poly) {
        String s="" ;
        int index =searchForChar(poly);
        int n=0;
        if(arr[index] !=null){
            n=(int)arr[index].getSize();
        }
     if(n != 0) {   
        if(n-1>=2) {
            if((int)arr[index].get(n-1) !=0 && (int)arr[index].get(n-1) !=1) {
                s+=String.valueOf((int) arr[index].get(n-1));
                s+=("x^");
                s+=String.valueOf(n-1);
            }
            
            else if((int)arr[index].get(n-1)==1) {
                s+=("x^");
                s+=String.valueOf(n-1);
            }
        
        }
        else if(n-1==1) {
            if((int)arr[index].get(n-1) !=0  && (int)arr[index].get(n-1) !=1) {
                s+=String.valueOf((int) arr[index].get(n-1));
                
                s+=("x");
                
                }
                else if((int)arr[index].get(n-1)==1) {
                    s+=("x");
                }
                
        }
        else if(n-1==0) {
            if((int)arr[index].get(n-1) !=0) {
                s+=String.valueOf((int) arr[index].get(n-1));
        }
        }
        
        for(int i=n-2;i>=0;i--) {
            if(i==1) {
                if((int)arr[index].get(i) > 0 && s != "") {
                    s+="+";
                }
                if((int)arr[index].get(i) !=0  && (int)arr[index].get(i) !=1) {
                s+=String.valueOf((int) arr[index].get(i));
                
                s+=("x");
                
                }
                else if((int)arr[index].get(i)==1) {
                    s+=("x");
                }
                
            }
            else if(i==0) {
                if((int)arr[index].get(i) > 0 && s!="") {
                    s+="+";
                }
                if((int)arr[index].get(i) !=0) {
                s+=String.valueOf((int) arr[index].get(i));
                
            }
            }
            else {
                if((int)arr[index].get(i) > 0 && s!="") {
                    s+="+";
                }
                if((int)arr[index].get(i) !=0 && (int)arr[index].get(i) !=-1 && (int)arr[index].get(i) !=1) {
                    s+=String.valueOf((int) arr[index].get(i));
                    s+=("x^");
                    s+=String.valueOf(i);
                    
                    }
            
                else if((int)arr[index].get(i)==1) {
                        s+=("x^");
                        s+=String.valueOf(i);
                    }
                
                }
        }
            
       
      System.out.println(s);
     }
     else { 
    	 System.out.println("[]");
    	 return "Error";
     }
     if(s.isEmpty()) {System.out.println("[]");}
     return s;
        
    }
// --------------------------------------------------------------------------------
//    public String print(char poly) {
//        // TODO Auto-generated method stub
//        int tempIndex = searchForChar(poly);
//        if(arr[tempIndex].getSize()>0) {
//            boolean ind = false;
//            int skip = 0;
//            while((int)arr[tempIndex].get((int)(arr[tempIndex].getSize()-1-skip)) == 0) {skip++;}
//            if((int)arr[tempIndex].get((int)arr[tempIndex].getSize()-1-skip)!=1 && (int)arr[tempIndex].get((int)arr[tempIndex].getSize()-1-skip)!=0 && (int)arr[tempIndex].get((int)arr[tempIndex].getSize()-1-skip)!=-1) {System.out.print((int)arr[tempIndex].get((int)arr[tempIndex].getSize()-1-skip));}
//            if((int)arr[tempIndex].get((int)arr[tempIndex].getSize()-1-skip)== -1){System.out.print("-1");}
//            if((int)arr[tempIndex].getSize()-1-skip !=1 && (int)arr[tempIndex].getSize()-1-skip != 0) {
//                System.out.print("x");
//                System.out.print("^"+(int)(arr[tempIndex].getSize()-1));ind = true;
//                }
//            if((int)arr[tempIndex].getSize()-1-skip == 1) {System.out.print("x");ind = true;}
//        for(int i = (int)arr[tempIndex].getSize()-2-skip; i > 0 ; i--) {
//            if((int)arr[tempIndex].get(i)<0) {System.out.print("-");}
//            else if((int)arr[tempIndex].get(i)>0){System.out.print("+");}
//            if((int)arr[tempIndex].get(i)!=1 && (int)arr[tempIndex].get(i)!=0 && (int)arr[tempIndex].get(i)!=-1) {System.out.print(Math.abs((int)arr[tempIndex].get(i)));}
//            if((int)arr[tempIndex].get(i)== -1){System.out.print("1");}
//            if(i !=1 && i != 0) {
//                System.out.print("x");
//                System.out.print("^"+i);
//                }
//            if(i == 1 && (int)arr[tempIndex].get(i)!=0) {System.out.print("x");}
//        }
//        if((int)arr[tempIndex].get(0) != 0 && !ind) {System.out.print(arr[tempIndex].get(0));}
//        if((int)arr[tempIndex].get(0) != 0 && (int)arr[tempIndex].get(0) > 0 && ind) {System.out.print("+" +(int)arr[tempIndex].get(0)+"\n");}
//        else if((int)arr[tempIndex].get(0) < 0) {System.out.print("-" +Math.abs((int)arr[tempIndex].get(0))+"\n");}
//        }
//        else System.out.println("[]") ;
//        return null;
//    }

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
        if(arr[tempIndex].getSize() == 0) {System.out.println("Error"); System.exit(0);}
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
//        if(arr[ind1].getSize()==arr[ind2].getSize()) {
//            for(int i = 0 ; i < arr[ind1].getSize() ; i++) {
//                output[i][0] = (int)arr[ind1].get(i) + (int)arr[ind2].get(i);
//            }
//        } else if(arr[ind1].getSize() > arr[ind2].getSize()) {
//            for(int i = 0 ; i < arr[ind2].getSize() ; i++) {
//                output[i][0] = (int)arr[ind1].get(i) + (int)arr[ind2].get(i);
//            }
//            for(int i = (int)arr[ind2].getSize() ; i < (int)arr[ind1].getSize() ; i++) {
//                output[i][0] = (int)arr[ind1].get(i);
//            }
//        } else if(arr[ind2].getSize() > arr[ind1].getSize()) {
//            for(int i = 0 ; i < arr[ind1].getSize() ; i++) {
//                output[i][0] = (int)arr[ind1].get(i) + (int)arr[ind2].get(i);
//            }
//            for(int i = (int)arr[ind1].getSize() ; i < (int)arr[ind2].getSize() ; i++) {
//                output[i][0] = (int)arr[ind2].get(i);
//            }
//        }
        reverese2D(output);
        return output;
    }

}