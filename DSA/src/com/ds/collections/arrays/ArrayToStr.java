package com.ds.collections.arrays;

/*
 * string can't be initialized using null value needs "";
 * str needs to updated using str = str.concat(arr[i]);
 * 
 * StringBuffer same reference will be updated.
 * 
 */
public class ArrayToStr {

	public static void main(String[] args) {
		String arr[] = { "q", "w", "e", "r", "t", "y" };
		String str = "";

		for (int i = 0; i < arr.length; i++) {
			str = str.concat(arr[i]);
		}
		System.out.println(str);

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		
		System.out.println(sb);
	}

}
