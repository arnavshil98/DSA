package com.ds.greedy;
import java.util.Stack;

public class ActivitySelectionPrac {

	static int s[] = { 1, 3, 0, 3, 4, 5 };
	static int f[] = { 2, 4, 6, 7, 9, 9 };

	/*
	 * finish time is already sorted ascending order if finish time is smaller than
	 * start time of next slot then assign slot to task
	 */

	public static void sequenceTasks() {
		Stack<Integer> st = new Stack<>();

		System.out.println("start: " + s[0] + "," + "end: " + f[0]); // first task
		st.push(f[0]);
		for (int i = 0; i < f.length - 1; i++) {
			if (st.peek() <= s[i + 1]) {
				System.out.println("start: " + s[i + 1] + "," + "end: " + f[i + 1]); // next task
				st.push(f[i + 1]);
			}
		}
	}

	public static void main(String[] args) {
		sequenceTasks();
	}

}
