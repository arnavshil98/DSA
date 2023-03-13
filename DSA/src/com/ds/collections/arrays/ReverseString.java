package com.ds.collections.arrays;

import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {
		String str = "hello";
		StringBuffer sb = new StringBuffer();
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			st.push(str.charAt(i));
		}

		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		System.out.println(sb);
	}
}
