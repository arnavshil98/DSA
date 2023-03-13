package com.ds.collections.arrays;

public class StrToArray {

	public static void main(String[] args) {

		String str = "welcome";
		char[] arr = new char[str.length()];
		for(int i=0;i<str.length();i++) {
			arr[i]=str.charAt(i);
		}
		
		System.out.println(arr[3]);
	}
}
