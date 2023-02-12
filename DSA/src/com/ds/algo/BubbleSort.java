package com.ds.algo;

import java.lang.reflect.Array;

public class BubbleSort {

	/*
	 * best:o(n+1) average and worst:o(n^2) stable(doesn't swap equal numbers), in
	 * line each outer iteration checks for ordering of the array
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 2, 4, 1, 5, 7, 6 };

		for (int i = 0; i < arr.length; i++) {
			boolean traverse = false;
			for (int k = 0; k < arr.length - 1; k++) {
				if (arr[k] > arr[k + 1]) {
					int smaller = arr[k + 1];
					arr[k + 1] = arr[k];
					arr[k] = smaller;
					traverse = true;
				}
			}
			
			System.out.println("===== iteration ====== "+ i);
			if (!traverse) {
				break;
			}
			System.out.print("[");
			for (int f : arr) {
				System.out.print(f + ",");
			}
			System.out.println("]");
		}

		System.out.println("========= printing final array ============");
		System.out.print("[");
		for (int f : arr) {
			System.out.print(f + ",");
		}
		System.out.println("]");
		
	}

}
