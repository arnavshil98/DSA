package com.ds.algo;

public class SelectionSort {
	/*
	 * best, average, worst -> O(n^2)
	 * unstable , in line
	 * thus no need of boolean traversal to check if the array is already 
	 * sorted.
	 * sorting of linked list
	 */
	public static void main(String[] args) {

		int[] arr = { 3, 2, 4, 1, 5, 7, 6 };

		int unsortedLength = arr.length;
		for (int i = 0; i < unsortedLength; i++) {

			for (int k = 0; k < unsortedLength - 1; k++) {
				if (arr[k] > arr[k + 1]) {
					int largerNum = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = largerNum;
				}
			}

			System.out.println("===== iteration ====== "+ i);
			System.out.print("[");
			for (int f : arr) {
				System.out.print(f + ",");
			}
			System.out.println("]");
			
			// as max value is fixed per inner iteration
			unsortedLength = unsortedLength-1;
		}
		
		System.out.println("========= printing final array ============");
		System.out.print("[");
		for (int f : arr) {
			System.out.print(f + ",");
		}
		System.out.println("]");
	}
}
