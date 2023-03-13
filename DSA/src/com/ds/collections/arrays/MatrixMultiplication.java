package com.ds.collections.arrays;

public class MatrixMultiplication {

	static int[][] C;

	public static void printMatrix() {
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C.length; j++) {
				System.out.println("i: "+i +"j: "+ j+" "+C[i][j]);
			}
		}
	}

	public static void multiplyMatrix(int A[][], int B[][]) {
		C = new int[2][2];
		// looping A
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				for (int k = 0; k < A.length; k++) {
					C[i][j] = A[i][k] * B[k][j];
				}
			}
		}
		
		printMatrix();
	}

	public static void main(String[] args) {

		// A: 4X3
		int A[][] = { { 1, 1 }, { 2, 2 } };

		// B: 3x4
		int B[][] = { { 1, 1 }, { 2, 2 } };

		multiplyMatrix(A,B);
	}
}
