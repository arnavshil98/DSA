package com.ds.collections.arrays;

public class InitCap {

	public static void main(String[] args) {
		String str = "my name is khan";

		char[] arr = str.toCharArray();
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				int newChar = (int) arr[i] - 32;
				char initCap = (char) newChar;
				arr[i] = initCap;
			}
			if (flag) {
				int newChar = (int) arr[i] - 32;
				char initCap = (char) newChar;
				arr[i] = initCap;
			}
			if (arr[i] == ' ') {
				flag = true;
				continue;
			}
			flag = false;
		}

		System.out.println(arr);

	}

}
