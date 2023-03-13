package com.ds.collections.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

// symmetric matrix 3x3
public class MatrixRotation {

	static int[][] transposedMatrix;

	private static void rotateMatrix(int width, int depth, int[][] matrix) {

		Deque<Integer> ad = new ArrayDeque<Integer>();

		for (int j = depth - 1; j >= 0; j--) {
			for (int i = 0; i < width; i++) {
				ad.addLast(matrix[i][j]);
			}
		}
		transposedMatrix = new int[depth][width];
		
		for (int i = 0; i < depth; i++) {
			for (int j = 0; j <width; j++) {
				transposedMatrix[i][j] = ad.poll();
			}
		}

		printMatrix(depth, width);

	}

	public static void printMatrix(int width, int depth) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < depth; j++) {
				System.out.println("i: " + i + "j: " + j + " " + transposedMatrix[i][j]);
			}
		}
	}

	public static void main(String[] args) {

		int matrix[][] = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int width = 3;
		int depth = 3;

		rotateMatrix(width, depth, matrix);

	}

}
