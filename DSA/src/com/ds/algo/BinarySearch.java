package com.ds.algo;
import java.util.Scanner;
public class BinarySearch {

	public static void main(String[] args) throws Exception {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		/*
		 * search 5. O(log n)
		 */
		Scanner sc  = new Scanner(System.in);
		System.out.println("please provide input for search");
		int x = sc.nextInt();
		int low = 0;
		int high = arr.length;
		int mid = 0;
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			mid = (low + high) / 2;
			if (arr[mid] < x) {
				low = mid;
			} else if (arr[mid] > x) {
				high = mid;
			} else if (arr[mid] == x) {
				break;
			}

			counter = counter + 1;
			if(counter==(arr.length-1)) {
				throw new Exception("search data not available");
			}
		}
		;

		System.out.println("required index is:" + mid);

		System.out.println("required loopcount is:" + counter);
	}
}
