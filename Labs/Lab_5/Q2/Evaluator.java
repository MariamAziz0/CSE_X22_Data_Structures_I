package Labs.Lab_5.Q2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface IStack {
	  
	  /*** Removes the element at the top of stack and returns that element.
	  * @return top of stack element, or through exception if empty
	  */
	  
	  public Object pop();
	  
	  /*** Get the element at the top of stack without removing it from stack.
	  * @return top of stack element, or through exception if empty
	  */
	  
	  public Object peek();
	  
	  /*** Pushes an item onto the top of this stack.
	  * @param object to insert*
	  */
	  
	  public void push(Object element);
	  
	  /*** Tests if this stack is empty
	  * @return true if stack empty
	  */
	  public boolean isEmpty();
	  
	  public int size();
	}

class Node {
		// Node Fields
		private Object element;				// Element Stored in the node.					
		private Node next;						// Next Node pointed to from this node.
		private Node prev;						// Previous Node pointed to from this node.
		
		// Constructor
		public Node(Object element, Node next, Node prev) {		
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
		
		// Setters & Getters.
		public Object getElement() {
			return element;
		}
		public void setElement(Object element) {
			this.element = element;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
	}

class MyStack implements IStack {

    // Fields
    private int Size = 0;
    private Node top = null;
    
	@Override
	public Object pop(){
		// TODO Auto-generated method stub
		if(Size == 0) {
			System.out.println("Error");
			return null;
		}
		Object temp = top.getElement();
		if(Size > 1){
		top.getPrev().setNext(null);
		top = top.getPrev();
		} else {
			top = null;
		}
		this.Size--;
		return temp;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(Size == 0)
			return null;
		return top.getElement();
	}

	@Override
	public void push(Object element) {
		// TODO Auto-generated method stub
		if (top == null || Size == 0) {
			Node temp = new Node(element,null,null);
			this.top = temp;
			Size++;
			return;
		}
		Node temp = new Node(element,null,top);
		this.top.setNext(temp);
		this.top = temp;
		Size++;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(Size == 0)
			return true;
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Size;
	}
	
	public void show() {
		if(this.size() == 0) {
			System.out.println("[]");
			return;
		}
		Node temp = top;
		System.out.print("[");
		while(temp.getPrev() != null) {
			System.out.print((String)temp.getElement()+", ");
			temp = temp.getPrev();
		}
		System.out.print((String)temp.getElement()+"]\n");
	}
}

interface IExpressionEvaluator {
  
/**
* Takes a symbolic/numeric infix expression as input and converts it to
* postfix notation. There is no assumption on spaces between terms or the
* length of the term (e.g., two digits symbolic or numeric term)
*
* @param expression infix expression
* @return postfix expression
*/
  
public String infixToPostfix(String expression);
  
  
/**
* Evaluate a postfix numeric expression, with a single space separator
* @param expression postfix expression
* @return the expression evaluated value
*/
  
public int evaluate(String expression);

}

/**
 * CSED - Level 1 - Term 2 - Course: DS I - Lab 5,
 * "Evaluator Class" To convert from infix to postfix and evaluate the expression value. 
 * PRE-Implemented Stack has been used.
 * @author George Samy Wahba Beshay
 */
public class Evaluator implements IExpressionEvaluator {
  
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
    	Evaluator EV = new Evaluator();
    	Scanner sc = new Scanner(System.in);
    	String expression = sc.nextLine();
    	int a,b,c;
    	a = EV.scanNum(sc.nextLine());
    	b = EV.scanNum(sc.nextLine());
    	c = EV.scanNum(sc.nextLine());
    	if(a == -139851935 || b == -139851935 || c == -139851935) {
    		System.out.println("Error");
    		System.exit(0);
    	}
//    	System.out.println(expression + "\n"+ a + "\n" + b + "\n" + c);
    	expression = EV.clean(expression);
//    	System.out.println(expression);
    	if(expression.compareTo("Error") == 0) {
    		System.out.println("Error");
    		System.exit(0);
    	}
    	System.out.println(EV.infixToPostfix(expression) );
    	if(EV.infixToPostfix(expression).compareTo("Error") != 0)
    		System.out.println(EV.evaluate(EV.ReplaceVar(EV.infixToPostfix(expression),a,b,c)));
    	sc.close();
    }
    
    /**
     * Method Objective: Iterating over the input expression and substitue each variable with its given value
     * @param expression : Input Expression.
     * @param a	: Variable a value.
     * @param b : Variable b value.
     * @param c : Variable c value.
     * @return Expression String in terms of VALUES not VARIABLES. 
     */
    public String ReplaceVar(String expression, int a, int b, int c) {
    	String ans = "";
    	String aStr = "" ,bStr = "" ,cStr = "";
    	
    	if (a>= 0) {
    		aStr = Integer.toString(a) + " ";
    	} else {
    		aStr = aStr + "0 " + Integer.toString(-a) + " - ";
    	}
    	
    	if (b>= 0) {
    		bStr = Integer.toString(b) + " ";
    	} else {
    		bStr = bStr + "0 " + Integer.toString(-b) + " - ";
    	}
    	
    	if (c>= 0) {
    		cStr = Integer.toString(c) + " ";
    	} else {
    		cStr = cStr + "0 " + Integer.toString(-c) + " - ";
    	}
    	
    	String searchingFor = "abc";
    	
    	for(int i = 0 ; i < expression.length() ; i++) {
    		char x = expression.charAt(i);
    		if(searchingFor.contains(""+x)) {
    			switch(x) {
    				case 'a':
    					ans += aStr;
    					break;
    				case 'b':
    					ans += bStr;
    					break;
    				case 'c':
    					ans += cStr;
    					break;
    				default:
    					System.out.println("Error");
    					break;
    			}
    		} else {
    			ans += x + " ";
    		}
    	}
    	return ans;
    }

    /**
     * Method Objective: Scan the input variables - values "a= .."
     * @param Input : Input line as a string.
     * @return variable value as an int data type.
     */
    public int scanNum(String Input) {
    	int Num;
    	String stNum = "";
    	String toBeIgnored = "abc=";
    	String Considered = "0123456789-";
    	for(int i = 0 ; i < Input.length() ; i++) {
    		if(  toBeIgnored.contains( ("" + Input.charAt(i)) )  ) {
    			continue;
    		} else {
    			if(Considered.contains( ("" + Input.charAt(i)))){ 
    				stNum += Input.charAt(i);
    			}
    		}
    	}
    	if(stNum.length() == 0) {
    		Num = -139851935;
    	} else
    		Num = Integer.parseInt(stNum);
    	return Num;
    }
    
    /**
     * Method Objective: Detect the precedence of the operator.
     * @param x : Operator to get the precedence of.
     * @return int value representing the precedence level of the given operator.
     */
    public int getPrecedence(String x) {		// Level 2 >>> Level 1
    	int level = 0;				// x == '*' or '/'		
     	if (x.equals("+") || x .equals("-"))
    		level = 1;
     	if (x.equals("*") || x .equals("/"))
     		level = 2;
     	if (x.equals("^"))
     		level = 3;
    	return level;
    }
    
    /**
     * Method Objective: Purify & Clean the given expression removing all useless characters like ++ and --.
     * @param str : Input non - purified Expression.
     * @return  Output purified Expression.
     */
    public String clean(String str) {
    	String Avoid1 = "*/^" ;
    	String Avoid2 = "*/^+-" ;
    	if( Avoid1.contains("" + str.charAt(0)) || Avoid2.contains("" + str.charAt(str.length()-1)) ){
    		return "Error";
    	}
    	String ans = "";
    	boolean skipFlag = false;
    	for(int i = 0 ; i < str.length()-1 ; i++) {
    		if(skipFlag) {
    			skipFlag = false;
    			continue;
    		}
    		char temp = str.charAt(i);
    		char temp2 = str.charAt(i+1); 
    		if(temp == temp2) {
    			if(temp == '-' || temp == '+') {
    				if(i == 0) {
    					skipFlag = true;
    					continue;
    				} else {
    					if( "+-/*^".contains("" + str.charAt(i-1)) ){
    						skipFlag = true;
    						continue;
    					} else {
    					ans += '+';
    					skipFlag = true;
    					}
    				} 		
    			}
    			else if( temp == '^' || temp == '/' || temp == '*') {
    				return "Error";
    			}
    	}
    		else {
    			ans += temp;
    			skipFlag = false;
    		}
    		
    	}
    	ans += str.charAt(str.length()-1);
    	return ans;
    }
    
	@Override
	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	*
	* @param expression infix expression
	* @return postfix expression
	*/
	public String infixToPostfix(String expression) {
		// TODO Auto-generated method stub
		String ans = "";
		String Operands = "abc";
		String Operators = "+-/*^";
		String Parenthesis ="()";
		int ParenthesisCounter = 0;
//		boolean ParenthesisFlag = false;
		MyStack EvaluatorStack = new MyStack(); 
 		for(int i = 0 ; i < expression.length() ; i++) {
 			String x = "" + expression.charAt(i);
 			
			if(Operands.contains(x)) {
				ans = ans + x ;
			}
			
			else if (Operators.contains(x)) {
//				if(i>0){
//					if( Operators.contains("" + expression.charAt(i-1) ) && x.compareTo("" + expression.charAt(i-1)) != 0  ) {
//					return "Error";
//					}
//				}
				boolean FinishFlag = false;
				while(EvaluatorStack.size() > 0 && !FinishFlag) {
					if(getPrecedence(x) > getPrecedence((String)EvaluatorStack.peek())) {
						EvaluatorStack.push(x);
						FinishFlag = true;
					} else {
						ans += (String)EvaluatorStack.pop();
					}
				}
				if(EvaluatorStack.size() == 0) {
					EvaluatorStack.push(x);
				}
			}
			
			else if(Parenthesis.contains(x)) {
				if(x.compareTo("(") == 0) {
					EvaluatorStack.push(x);
					ParenthesisCounter++;
//					ParenthesisFlag = true;
				}
				else if(ParenthesisCounter > 0 && EvaluatorStack.size() > 0){
					while( ((String)EvaluatorStack.peek()).compareTo("(") != 0   && EvaluatorStack.size() > 0) {
						ans += (String)EvaluatorStack.pop();
					}
					EvaluatorStack.pop();
					ParenthesisCounter--;
//					ParenthesisFlag = false;
				 }
				else return "Error";
			}
			else return "Error";
		}
 		
 		// Handling the Remaining Elements in the Stack
 		while(EvaluatorStack.size()>0) {
 			if(EvaluatorStack.peek() == "(" || EvaluatorStack.peek() == ")" || ParenthesisCounter != 0) {
 				return "Error" ;
 			}
 			else {
 				ans += (String)EvaluatorStack.pop();
 			}
 		}
 		if (ans.length() == 0) {
 			return "Error";
 		}
		return ans;
	}

	/**
	 * 
	 */
	@Override
	public int evaluate(String expression) {
		// TODO Auto-generated method stub
		int ans = 0 ;
		String[] Array = expression.split(" ");
//		System.out.println(Arrays.toString(Array));
		MyStack EvaluatorStack = new MyStack();
		String searchingFor = "+-*/^";
		for(int i = 0 ; i < Array.length ; i++) {
			String x = Array[i];
			if(searchingFor.contains("" + x)) {
				int tempAns = 0;
				int var1 = 0;
				int var2 =  Integer.parseInt("" + (String)EvaluatorStack.pop());
				if(EvaluatorStack.size() > 0) {
					var1 = Integer.parseInt("" + (String)EvaluatorStack.pop());
				}
//				System.out.println(var1 + " " + var2 + " " + x);

					switch(x) {
					case "+":
						tempAns = var1 + var2;
						break;
					case "-":
						tempAns = var1 - var2;
						break;
					case "*":
						tempAns = var1 * var2;
						break;
					case "/":
						tempAns = var1 / var2;
						break;
					case "^":
						tempAns = (int) Math.pow(var1, var2);
						break;
					default:
						System.out.println("Error");
						break;
					}
//				System.out.println(tempAns);
				EvaluatorStack.push(Integer.toString(tempAns));
			} else {
				EvaluatorStack.push("" + x);
			}	
		}
		ans = Integer.parseInt( (String)EvaluatorStack.pop() );
		return ans;
	}
}