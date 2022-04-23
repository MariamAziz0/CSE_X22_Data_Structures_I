package Labs;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	// --------------------------------------------------------- Methods ---------------------------------------------------------
	
	public int[] reverse(int[] array){
    
     for(int i = 0 ; i < (array.length/2) ; i++)
     {
    	 int temp = array[array.length-1 - i];
    	 array [array.length-1 - i] = array[i];
    	 array[i] = temp;
     }
     return array;
    }
	
	public double average(int[] array)
	{
		double sum = 0.0;
		for(int i = 0 ; i < array.length ; i++)
		{
			sum+=array[i];
		}
		if (array.length == 0)
			return 0.0;
		else
			return sum/array.length;
    }
	
	public int[] sumEvenOdd(int[] array)
	{
		int sum[] = {0,0};
    	for(int i = 0 ; i < array.length ; i++)
    	{
    		if (array[i]%2 == 0)
    			sum[0] += array[i];
    		else
    			sum[1] += array[i];
    	}
    	return sum;
    }
	
	public int[] moveValue(int[] array, int value)
	{
    	int movedArray[] = new int[array.length];
    	int counter = 0;
    	for(int i = 0 ; i < array.length ; i++)
    	{
    		if(array[i] == value)
    		{
    			counter++;
    		}
    	}
    	int k = 0;
    	for(int i = 0 ; i < array.length ; i++)
    	{
    		if(array[i] != value)
    		{
    			movedArray[k] = array[i];
    			k++;
    		}	
    	}
    	for(int i = array.length - 1 ; i >= array.length - counter ; i--)
    	{
    		movedArray[i]=value;
    	}
    	return movedArray;
    }
	
	public int[][] transpose(int[][] array)
	{
		if(array[0].length != 0)
		{
	    	for(int i = 0 ; i < array.length ; i++)
	    	{
	    		for(int j = 0 ; j < i+1 ; j++)
	    		{
	    			int temp = array[i][j];
	    			array[i][j] = array[j][i];
	    			array[j][i] = temp;
	    		}
	    	}
		}
    	return array;
    }
	
	public int fibonacci(int n)
	{
    	if(n == 1)
    		return 0;
    	else if(n == 2)
    		return 1;
    	else
    		return (fibonacci(n-1) + fibonacci(n-2));
    }
	// -------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args)
	{
		// -------------------------------------------------- Question 1 --------------------------------------------------
//		Scanner sc = new Scanner(System.in);
//        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
//    	String[] s = sin.split(", ");;
//		int[] arr = new int[s.length];
//        if (s.length == 1 && s[0].isEmpty())
//            arr = new int[]{};
//        else {
//            for(int i = 0; i < s.length; ++i)
//        	   arr[i] = Integer.parseInt(s[i]);
//        }
//      	int[] res = new Solution().reverse(arr);
//     	System.out.print("[");
//      	for(int i = 0; i < arr.length; ++i) {
//        	System.out.print(arr[i]);
//            if(i != s.length - 1)
//              System.out.print(", ");
//        }
//        System.out.print("]");
		// -------------------------------------------------- Question 2 --------------------------------------------------
//		Scanner sc = new Scanner(System.in);
//		String sin = sc.nextLine().replaceAll("\\[|\\]", "");
//		String[] s = sin.split(", ");
//		int[] arr = new int[s.length];
//		if (s.length == 1 && s[0].isEmpty())
//          arr = new int[]{};
//		else {
//          for(int i = 0; i < s.length; ++i)
//      	   arr[i] = Integer.parseInt(s[i]);
//		}
//		double res = new Solution().average(arr);
//		System.out.println(res);
		// -------------------------------------------------- Question 3 --------------------------------------------------
//		Scanner sc = new Scanner(System.in);
//		String sin = sc.nextLine().replaceAll("\\[|\\]", "");
//		String[] s = sin.split(", ");
//		int[] arr = new int[s.length];
//		if (s.length == 1 && s[0].isEmpty())
//          arr = new int[]{};
//		else {
//          for(int i = 0; i < s.length; ++i)
//      	   arr[i] = Integer.parseInt(s[i]);
//		}
//		int[] res = new Solution().sumEvenOdd(arr);
//		System.out.print("[" + res[0] + ", " + res[1] + "]");
//    }
		// -------------------------------------------------- Question 4 --------------------------------------------------
//		Scanner sc = new Scanner(System.in);
//		String sin = sc.nextLine().replaceAll("\\[|\\]", "");
//		int x = sc.nextInt();
//		String[] s = sin.split(", ");
//		int[] arr = new int[s.length];
//		if (s.length == 1 && s[0].isEmpty())
//          arr = new int[]{};
//		else {
//          for(int i = 0; i < s.length; ++i)
//      	   arr[i] = Integer.parseInt(s[i]);
//		}
//		int[] res = new Solution().moveValue(arr, x);
//		System.out.print("[");
//		for(int i = 0 ; i < res.length ; i++)
//		{
//			if (i!=res.length-1)
//				System.out.print(res[i] + ", ");
//			else
//				System.out.print(res[i]);
//		}
//		System.out.print("]\n");
		// -------------------------------------------------- Question 5 --------------------------------------------------
//		Scanner sc = new Scanner(System.in);
//        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
//    	String[] s = sin.split(", ");;
//		int[][] arr = new int[(int)Math.sqrt(s.length)][(int)Math.sqrt(s.length)];
//        if (s.length == 1 && s[0].isEmpty())
//            arr = new int[][]{{}};
//        else
//        {
//        	int h = 0;
//            for(int i = 0; i < Math.sqrt(s.length); ++i)
//            {
//            	for(int j = 0; j < Math.sqrt(s.length); ++j)
//                {
//            		arr[i][j] = Integer.parseInt(s[h]);
//            		h++;
//                }
//            }
//        }
//      	int[][] res = new Solution().transpose(arr);
//      	if (res[0].length == 0)
//      		System.out.println("[[]]");
//      	else if(res.length != 0)
//      	{	
//	     	System.out.print("[");
//	      	for(int i = 0; i < res.length; i++)
//	      	{
//	      		System.out.print("[");
//	      		for(int j = 0 ; j < res.length ; j++)
//	      		{
//	      			System.out.print(res[i][j]);
//	      			if(j != res.length - 1)
//	                    System.out.print(", ");
//	      		}
//	      		if(i == res.length - 1)
//	      			System.out.print("]");
//	      		else
//	      			System.out.print("], ");
//	        }
//	        System.out.print("]\n");
//      	}
		// -------------------------------------------------- Question 6 --------------------------------------------------
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int ans = new Solution().fibonacci(n);
//		System.out.println(ans);
	}
}