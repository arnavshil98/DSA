package com.ds.algo;

/*
 * Auxiliary array needed, not in line 
 * stable
 * divide and conquer
 * time:o(nlogn) space:o(n)
 * well suited for linked list o(1) space complexity
 */
public class MergeSort {

	public void conquer(int[] arr, int low, int mid, int high) {
		// Auxiliary array
		int[] auxArr = new int[high - low + 1];
		int leftIndex = low;
		int rightIndex = mid+1;
		int i = 0;
		while (leftIndex <= mid && rightIndex <= high) {
			if (arr[leftIndex] < arr[rightIndex]) {
				auxArr[i] = arr[leftIndex];
				i++;
				leftIndex++;
			} else {
				auxArr[i] = arr[rightIndex];
				i++;
				rightIndex++;
			}
		}
		while (leftIndex <= mid) {
			auxArr[i] = arr[leftIndex];
			i++;
			leftIndex++;
		}

		while (rightIndex <= high) {
			auxArr[i] = arr[rightIndex];
			i++;
			rightIndex++;
		}

		for (int f = 0, p = low; f < auxArr.length; f++,p++) {
			arr[p] = auxArr[f];
		}
	}

	public void divide(int[] arr, int low, int high) {
		int mid = (high + low) / 2;
		if (low >= high)
			return;
		divide(arr, low, mid);
		divide(arr, mid + 1, high);
		conquer(arr, low, mid, high);
	}

	public void mergeSorting(int[] arr) {
		divide(arr, 0, arr.length - 1);
		System.out.print("[");
		for (int f : arr) {
			System.out.print(f + ",");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {

		MergeSort sort = new MergeSort();
		int[] arr = { 3, 2, 4, 1, 5, 7, 6 };
		sort.mergeSorting(arr);
	}

}
