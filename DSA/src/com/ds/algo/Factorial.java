package com.ds.algo;

public class Factorial {

	public static int factorialIterative(int x) {
		int value = 1;
		while (x > 0) {
			value = value * x;
			x--;
		}

		return value;
	}

	public static int factorialRecursive(int x) {
		if ((x - 1) <= 0)
			return 1;
		int f= factorialRecursive(x - 1);
		return x * f;
	}

	public static void main(String[] args) {
		System.out.println(factorialIterative(5));
		System.out.println(factorialRecursive(4));
	}
}
