package Labs;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ICalculator {
	int add(int x, int y);
	float divide(int x, int y) throws RuntimeException;
}

public class Calculator implements ICalculator{
	@Override
	public int add(int x, int y) {
		return x+y ;
	}

	@Override
	public float divide(int x, int y) throws RuntimeException {
		if (y == 0) {
			throw new RuntimeException("Error");
		}
		return (float)x / y ;
	}
	
	public static void main(String[] args) {
		Calculator obj = new Calculator();
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		char y = input.next().charAt(0);
		int z = input.nextInt();
		if(y =='+') {
			System.out.println(obj.add(x,z));
		} else if(y == '/') {
			try {
				System.out.println(obj.divide(x,z));
			} catch (RuntimeException ex) {
				System.out.println("Error");
			}
		} else {
			System.out.println("Error");
		}
	}
  
}