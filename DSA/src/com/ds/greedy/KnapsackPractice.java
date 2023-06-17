package com.ds.greedy;

import java.util.Deque;
import java.util.LinkedList;

import com.ds.algo.QuickSort;

public class KnapsackPractice {

	static float[] Wi = { 50, 20, 30 };
	static float[] Pi = { 600, 500, 400 };
	static float knapsackCapacity = 70.0f;
	static float[] it = new float[Wi.length];
	static Deque<Float> deque = new LinkedList<>();
	static float value = 0.0f;
	static float cumulativeWeight = 0;
	/*
	 * deque iterate each element, match with array it, when matched,subtract
	 * wi[index] from knapsackCapacity
	 */

	public static void arrangeRatio() {
		for (int i = 0; i < Wi.length; i++) {
			it[i] = Pi[i] / Wi[i];
		}

		sorting(it);

		for (float i : it) {
			deque.addFirst(i);
		}
	}

	private static void sorting(float[] it2) {

		QuickSort.quickSort(it2, 0, it2.length - 1);

	}

	public static void fracrionalKnapsack() {
		arrangeRatio();
		for (float f : deque) {
			for (int i = 0; i < deque.size(); i++) {
				if (f == it[i]) {
					if (Wi[i] < knapsackCapacity - cumulativeWeight) {
						cumulativeWeight = cumulativeWeight + Wi[i];
						value = value + Pi[i];
					} else {
						float remainingWeight = (knapsackCapacity - cumulativeWeight);
						cumulativeWeight = cumulativeWeight + remainingWeight;
						value = value + it[i] * remainingWeight;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		fracrionalKnapsack();
		System.out.println("value:" + value);

	}

}
