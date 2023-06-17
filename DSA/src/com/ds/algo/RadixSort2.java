package com.ds.algo;

public class RadixSort2 {

	public static int getMax(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static void radixSorting(int[] arr, int size) {
		int maxElement = getMax(arr);

		for (int place = 1; maxElement / place > 0; place *= 10) {
			countSort(arr, size, place);
		}

	}

	public static void countSort(int[] arr, int size, int place) {

		int[] a = new int[size]; // parallel array of arr[] on the basis of place
		
		// max of the array by place
		
		int max = 0;
		for (int i = 0; i < size; i++) {
			a[i] = (arr[i] / place) % 10;
			if (a[i] > max) {
				max = (arr[i] / place) % 10;
			}
		}

		// allocating countArray
		int[] countArray = new int[10];
		// replacing 0 with the occurence of the digits
		for (int i = 0; i < size; i++) {
			countArray[a[i]] += 1;
		}

		// cumulative sum of the countArr
		for (int i = 1; i < countArray.length; i++) {
			countArray[i] = countArray[i] + countArray[i - 1];
		}

		int[] b = new int[size];

		// sorting b[] 
		
		for (int i = 0; i < size; i++) {
			int index = a[i];
			// updating countArr index
			countArray[index] = countArray[index] - 1;
			
			b[countArray[index]] = arr[i];
		}

		// updating arr[] from b[].
		
		for(int i=0;i<size;i++) {
			arr[i] = b[i];
		}
		
		
	}

	// Main driver method
	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;

		radixSorting(arr,n);
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+",");
		}

		/*
		 * System.out.println((802/100)%10); we can find the place values
		 */

	}

}
