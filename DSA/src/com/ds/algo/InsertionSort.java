package com.ds.algo;

public class InsertionSort {

	/*
	 * concept: 1st element of array is always ordered
	 * best case o(n), average and worst case o(n^2) used in small arrays, when the
	 * data to be sorted is less
	 */
	public static void main(String[] args) {

		int[] arr = { 3, 2, 4, 1, 5, 7, 6 };
		/*
		 * 23|41576, i=1
		 * 234|1576,i=2
		 * 1234|576,i=3
		 * 12345|76,i=4
		 */
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>key) {
				//swaping elements
				int largerElement = arr[j];
				arr[j] = key;
				arr[j+1] = largerElement;
				j--;
			}
		}


		System.out.println("========= printing final array ============");
		System.out.print("[");
		for (int f : arr) {
			System.out.print(f + ",");
		}
		System.out.println("]");
	}
}
