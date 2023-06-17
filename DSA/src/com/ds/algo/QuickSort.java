package com.ds.algo;

import java.util.Arrays;

public class QuickSort {

	public static void quickSort(float[] it2, int low, int high) {

		if(low<high) {
			int pivotIndex = partition(it2,low,high);
			quickSort(it2,low, pivotIndex-1);
			quickSort(it2,pivotIndex+1, high);
		}
	}

	private static int partition(float[] it2, int low, int high) {
		int i = low-1;
		int pivot = (int) it2[high];
		/*
		 * i makes space for only smaller elements inn the array
		 *  therefore no need to loop till pivot
		 *  purpose of the loop is to set all the smaller
		 *  elements smaller than pivot before.
		 */
		for(int j=low; j<high;j++) {
			if(it2[j]<pivot) {
				i++;
				int temp = (int) it2[i];
				it2[i] = it2[j];
				it2[j] = temp;
			}
		}
		
		/*
		 * placing pivot to correct position
		 */
		
		i++;
		int temp = (int) it2[i];
		it2[i] = pivot;
		it2[high] = temp;
		
		return i;
	}
	
	public static void main(String[] args) {
		float[] arr = {3,4,7,9,11,10,8};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
	}
}
