package com.ds.collections.list;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PostFix {

	/*
	 * precedence rule must be set. ^, *,/, +,-
	 * 
	 * "a+b*(c^d-e)^(f+g*h)-i"
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
		for (int i = 0; i < StringArray.length; i++) {
			if (StringArray[i] == '+' || StringArray[i] == '-' || StringArray[i] == '/' || StringArray[i] == '*'
					|| StringArray[i] == '^') {
				int precedenceValue = decidePrecedence(StringArray[i]);
				int stackPrecedenceValue = decidePrecedence(st.peek());

				if (precedenceValue > stackPrecedenceValue)
					st.add(StringArray[i]);
				else {
					/*
					 * pop all operators till precedenceValue > stackPrecedenceValue
					 */
					for (int x = 0; x < st.size(); x++) {
						if (st.get(x) != null) {
							// stack is not empty
							if (precedenceValue > decidePrecedence(st.get(x))) {
								st.add(StringArray[i]);
								break;
							} else {
								postFixExpression.addLast(st.pop());
							}
						} else {
							// stack is empty
							st.add(StringArray[i]);
						}
					}

				}
			}
		}
	}

	public static void main(String[] args) {
	}

}
