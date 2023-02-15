package com.ds.algo;

import java.util.ArrayList;
import java.util.Iterator;

public class Fibonacci {

	static ArrayList<Integer> fabonacciSeries = new ArrayList<>();

	public static void fibonacciIterative(int length) {
		Integer value = 0;
		for (int i = 0; i < length; i++) {
			if (i == 0 || i == 1) {
				value = 1;
			} else {
				value = fabonacciSeries.get(i - 1) + fabonacciSeries.get(i - 2);
			}
			fabonacciSeries.add(value);
		}
	}
	
	public static int fibonacciRecursive(int length) {
		if(length<=1) return length;
		return fibonacciRecursive(length-1) + fibonacciRecursive(length-2);
	}
	

	public static void main(String[] args) {

		fibonacciIterative(5);

		Iterator<Integer> itr = fabonacciSeries.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		System.out.println(fibonacciRecursive(5));
	}

}
