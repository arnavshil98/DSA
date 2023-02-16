package com.ds.collections.list;

import java.util.Stack;

public class BalancingBrackets {

	public static void balanceBrackets(String expression) {
		Stack<Character> st = new Stack<>();
		int i = 0;
		int balance = 0;
		while (i < expression.length()) {
			if (expression.charAt(i) == '{' || expression.charAt(i) == '(' || expression.charAt(i) == '[') {
				st.push(expression.charAt(i));
				balance = balance + 1;
			} else if (expression.charAt(i) == '}' || expression.charAt(i) == ')' || expression.charAt(i) == ']') {
				Character openingBracket = null;
				switch (expression.charAt(i)) {
				case '}':
					openingBracket = '{';
					break;
				case ')':
					openingBracket = '(';
					break;
				case ']':
					openingBracket = '[';
					break;

				}
				char poppedBracket = st.pop();
				if (openingBracket.equals(poppedBracket)) {
					balance = balance - 1;
				}
			}
			
			i++;
		}
		
		System.out.println("balance:" + balance);
		if (balance == 0) {
			System.out.println("bracket is balanced ....");
		} else {
			System.out.println("bracket is not balanced ....");
		}
	}

	public static void main(String[] args) {

		balanceBrackets("a[b{c(d*d)n}g]");

	}

}
