package com.ds.algo;

public class CountSort {

	 public void countSorting(int[] arr) {
		 int max = 0;
		 for(int i:arr) {
			 if(i>max) {
				 max = i;
			 }
 
		 }
		 
		 // creating countArray
		 int[] countArr = new int[max+1];
		 for(int i=0;i<=max;i++) {
			 countArr[i] =0;
		 }
		 
		 // updating countArr elements on the basis of occurence of elements in arr
		 
		 for(int i=0;i<arr.length;i++) {
			 countArr[arr[i]]++;
		 }
		 
		 // cumulative sum of elements in the countArr
		 
		 for(int i=1; i<countArr.length;i++) {
			 countArr[i] = countArr[i-1] + countArr[i]; // updating current elements
		 }
		 
		 // creating an aux array to get sorted elements in from arr
		
		 int [] b = new int[arr.length];
		 
		 /*
		  *  traverse elements in arr from last index.
		  *  each element in the arr represents index in countArr
		  *  decrease the element int countArr for that index by 1.
		  *  now the element of arr[] will be placed at the index provided by 
		  *  countArr after the value at countArr is reduced.  
		  */
		 
		 
		 for(int i=arr.length-1; i>=0;i--) {
			 // updating countArr Element for the given index
			 // where index = arr[i]
			 int index = arr[i];
			 int indexOfb = 0;
			 countArr[index] = countArr[index] -1;
			 indexOfb = countArr[index];
			 
			 b[indexOfb] = index;
			 
		 }
		 
		 
		 for(int i=0;i<b.length;i++) {
			 arr[i] = b[i];
		 }
		 
		 
	 }
	 
	
	public static void main(String[] args) {
		CountSort countSort = new CountSort();
		int[] arr = {3,1,9,7,1,2,4};
		countSort.countSorting(arr);
		System.out.print("[");
		for(int i:arr) {
			System.out.print(i+",");
		}
		System.out.print("]");
	
	}

}
