package com.ds.collections.list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PostFix2 {

	/*
	 * precedence rule must be set. ^, *,/, +,-
	 * 
	 * 
	 * a+b/c-d*e
	 */

	public static int decidePrecedence(char operator) {
		switch (operator) {
		case '-':
			return 0;
		case '+':
			return 1;
		case '/':
			return 2;
		case '*':
			return 3;
		case '^':
			return 4;
		default:
			return -1;
		}
	}

	public static void infixToPostfix(String expression) {

		Deque<Character> postFixExpression = new ArrayDeque<>();
		Stack<Character> st = new Stack<>();
		char[] StringArray = new char[expression.length()];
		StringArray = expression.toCharArray();
		for (char i : StringArray) {

			if (i == '-' || i == '+' || i == '/' || i == '*' || i == '^') {
				if (st.isEmpty()) {
					st.add(i);

				} else {
					int currentPrecedence = decidePrecedence(i);
					int stackPrecedence = decidePrecedence(st.peek());
					if (currentPrecedence > stackPrecedence) {
						st.add(i);
					} else {
						while (!st.empty()) {
							stackPrecedence = decidePrecedence(st.peek());
							if (currentPrecedence > stackPrecedence) {
								st.add(i);
								break;
							} else {
								char popped = st.pop();
								postFixExpression.add(popped);
							}
						}
						if (st.isEmpty()) {
							st.add(i);
						}
					}
				}

			} else {
				postFixExpression.add(i);
			}
		}
		if (!st.isEmpty()) {
			while (!st.isEmpty()) {
				postFixExpression.add(st.pop());
			}
		}

		StringBuffer sb = new StringBuffer();
		postFixExpression.forEach(i -> sb.append(i)); // steamAPI
		System.out.println(sb);
	}

	public static void main(String[] args) {
		infixToPostfix("a+b/c-d*e");
	}

}
