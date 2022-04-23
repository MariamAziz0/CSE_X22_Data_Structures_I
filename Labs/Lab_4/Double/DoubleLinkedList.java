package Labs.Lab_4.Double;

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


public class DoubleLinkedList implements ILinkedList {
    
    // Class for node
    static class DNode{
        private Object element;
        private DNode prev;
        private DNode next;
        
        public DNode(Object element, DNode next, DNode prev){
            this.element=element;
            this.prev=prev;
            this.next=next;
        }
        //setters and getters
        public void setElement(Object element){
            this.element=element;
        }
        public Object getElement(){
            return element;
        }
        public DNode getNext() {
            return next;
        }

        public void setNext(DNode next) {
            this.next = next;
        }

        public DNode getPrev() {
            return prev;
        }

        public void setPrev(DNode prev) {
            this.prev = prev;
        }
    }
    
    
    /* Implement your linked list class here*/
    private DNode head;
    private DNode tail;
    private long size;
    //Constructor
    public DoubleLinkedList(DNode head){
        this.head=head;
        this.tail=head;
        if(head.getElement() != null)
            size=1;
        else 
            size=0;
        DNode node = head;
        while(node.getNext()!=null) {
            node=node.getNext();
        }
        tail=node;
        }
    //setters and getters
    public DNode getHead() {
        return head;
    }

    public void setHead(DNode head) {
        this.head = head;
    }

    public DNode getTail() {
        return tail;
    }

    public void setTail(DNode tail) {
        this.tail = tail;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }


    //--------------------------------------------------------------------------------------
    
    //Implementation of methods
    public void add(int index, Object element){
       if(index < 0 || index>= this.getSize()) {
           System.out.println("Error");
           return;
       }
        else{
                if(index == 0) {        // inserting at the beginning
                DNode newNode = new DNode(element,head,null);
                head.setPrev(newNode);
                head = newNode;
                this.size++;
                return; 
                }
            int i =0;
            DNode node = head;
            while(node.getNext() != null && i<index-1){
                node= node.getNext();
                i++;
            }
            if(node.getNext() != null && i==index-1){
                DNode newNode = new DNode(element,node.getNext(),node);
                node.setNext(newNode);
                node.getNext().setPrev(newNode);
                this.size++;
                return;
            }
            else if(node.getNext() == null && i==index-1){
                DNode newNode = new DNode(element,null,node);
                node.setNext(newNode);
                this.size++;
                return;
            }
            else {
                System.out.println("Error");
                return;
                }
      }
    }
    
    //---------------------------------------------------------------------------------------
    public void add(Object element){
        
        DNode newNode = new DNode(element,null,null);
        if(this.getSize() != 0){
            tail.setNext(newNode);
            tail=newNode;
        }
        else{
            head=newNode;
            tail=newNode;
        }
        
        this.size++;
        return;
    }
    //--------------------------------------------------------------------------------------
    public Object get(int index){
       if(index<0|| index>=size) {
           System.out.println("Error");
           return null;
           }
       else if(index==0)
           return head.getElement();
       else {
           DNode node = head;
           int i=0;
           while(node.getNext() != null && i<index) {
               i++;
               node=node.getNext();
           }
           if(i==index) {
               return node.getElement();
           }
           else {
               System.out.println("Error");
               return null;
           }
       }
    }
   //-----------------------------------------------------------------------------------------
    public void set(int index, Object element) {
        if(index<0 || index >= this.getSize()) {
            System.out.println("Error");
            return;
        }
        else if(index==0) {
            head.setElement(element);
            return;
        }
        else {
            int i=0;
            DNode node = head;
            while(node.getNext() != null && i<index) {
                i++;
                node=node.getNext();
            }
            if(i==index && node.getElement() != null) {
                node.setElement(element);
                return;
            }
            else { 
                System.out.println("Error");
                return;
            }
            
        }
        
    }
    //----------------------------------------------------------------------------------------
    public void clear() {
        this.head.setPrev(null);
        this.head.setNext(null);
        this.head.setElement(null);
        this.tail.setPrev(null);
        this.tail.setNext(null);
        this.tail.setElement(null);
        this.size=0;
        return;
    }
    //---------------------------------------------------------------------------------------
    public boolean isEmpty() {
        if(this.size==0) {
            return true;
        }
        else {
            return false;
        }
    }
    //--------------------------------------------------------------------------------------
    public void remove(int index) {
        if(index<0 || index >= size) {
            System.out.println("Error");
            return;
        }
        else if(index==0 && head.getElement() != null){
            head=head.getNext();
            return;
        }
        else{
            int i=0 ;
            DNode node = head;
            while(i<index-1 && i<this.getSize()){
                i++;
                node=node.getNext();
            }
            if(i==index-1){
                node.setNext(node.getNext().getNext());
                return;
            }
            else{
                System.out.println("Error");
            }
        }
        
           
    }
    //--------------------------------------------------------------------------------------
    public int size() {
        return (int)this.size;
    }
    //---------------------------------------------------------------------------------------
    public ILinkedList sublist(int fromIndex, int toIndex) {
        if(fromIndex <0 || toIndex <0) {
           System.out.println("Error");
           
            return null;
        }
        else if(fromIndex >=size || toIndex>=size) {
            System.out.println("Error");
          
            return null;
        }
        else if(fromIndex>toIndex) {
            System.out.println("Error");
            
            return null;
        }
         
        DNode begin = new DNode((int)this.get(fromIndex),null,null);
        DoubleLinkedList List = new DoubleLinkedList(begin);
        for(int i = fromIndex+1 ; i < toIndex+1 ; i++) {
            List.add((int)this.get(i));
        }
        return List;
        
    }
    //----------------------------------------------------------------------------------------
    public boolean contains(Object o) {
        DNode node = head;
        boolean found = false;
        while(node.getNext()!=null && found==false) {
            if((int)node.getElement()==(int)o) {
                found =true;
            }
            else {
                node=node.getNext();
            }
        }
        if(node.getNext()==null && (int)node.getElement()==(int)o){
            found=true;
        }
        return found;
    }
    //----------------------------------------------------------------------------------
    public DNode getNode(int index) {
        if(index<0 || index>=size) {
            System.out.println("Error");
            return null;
            }
        else if(index==0)
            return head;
        else {
            DNode node = head;
            int i=0;
            while(node.getNext() != null && i<index) {
                i++;
                node=node.getNext();
            }
            if(i==index) {
                return node;
            }
            else {
                System.out.println("Error");
                return null;
            }
        }
    }
    public void show() {
        DNode currentNode = this.head;
        if(currentNode.getElement() != null){
            System.out.print("[");
            while(currentNode.getNext() != null) {
                System.out.print(currentNode.getElement()+ ", ");
                currentNode = currentNode.getNext();
            }
            System.out.print(currentNode.getElement()+"]\n");
        } else 
            System.out.println("[]");
    }
    //---------------------------------------------------------------------------------------
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
         Scanner sc = new Scanner(System.in);
            String sin = sc.nextLine().replaceAll("\\[|\\]", "");
              String[] s = sin.split(", ");
              DoubleLinkedList myList;
              if (s.length == 1 && s[0].isEmpty()) {
                  DoubleLinkedList.DNode myNode = new DoubleLinkedList.DNode(null, null,null);
                myList = new DoubleLinkedList(myNode); 
              } else {
                  DoubleLinkedList.DNode myNode = new DoubleLinkedList.DNode(Integer.parseInt(s[0]),null,null);
              myList = new DoubleLinkedList(myNode);
                for(int i = 1; i < s.length; i++) {
                  myList.add(Integer.parseInt(s[i]));
                }
              }
              String temp = sc.nextLine();
              int x;
              int index;
              switch (temp) {
              case "add":
                x = sc.nextInt();
                myList.add(x);
                myList.show();
                break;
              case "addToIndex":
                index = sc.nextInt();
                x = sc.nextInt();
                myList.add(index,x);
                if(index < myList.getSize() && index>=0) {
                myList.show();
                }
                break;
              case "get":
                index = sc.nextInt();
                Object obj = myList.get(index);
                if(obj != null){
                    System.out.println((int)myList.get(index));
                }
                break;
              case "set":
                index = sc.nextInt();
                x = sc.nextInt();
                myList.set(index, x);
                if(index < myList.getSize() && index>=0) {
                    myList.show();
                }   
                break;
              case "clear":
                myList.clear();
                myList.show();
                break;
              case "isEmpty":
                if(myList.isEmpty() == true)
                  System.out.println("True");
                else
                  System.out.println("False");
                break;
              case "remove":
                index = sc.nextInt();
                myList.remove(index);
                if(index < myList.getSize() && index>=0) {
                    myList.show();
                }   
               break;
              case "sublist":
                int firstIndex = sc.nextInt();
                int lastIndex = sc.nextInt();
                ILinkedList tempList = myList.sublist(firstIndex, lastIndex);
                if(tempList !=null){
                    DoubleLinkedList temppList=(DoubleLinkedList)tempList;
                    temppList.show();
                }
                break;
              case "contains":
                x = sc.nextInt();
                if(myList.contains(x)==true)
                  System.out.println("True");
                else
                  System.out.println("False");
                break;
              case "size":
                System.out.println(myList.size());
                break;
                  
              default:
                System.out.println("Error");
              }
    }
}
