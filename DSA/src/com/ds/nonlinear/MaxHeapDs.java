package com.ds.nonlinear;

public class MaxHeapDs {

	int[] arr;
	int size;
	int capacity;

	public MaxHeapDs(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
		size = 0;
	}

	public int parentNode(int index) {
		int parent = arr[(index - 1) / 2];
		return parent;
	}

//	public int leftChild(int index) {
//		int leftChild = arr[(2 * index) + 1];
//		return leftChild;
//	}
//
//	public int rightChild(int index) {
//		int rightChild = arr[(2 * index) + 2];
//		return rightChild;
//	}

	public void heapify(int i) {

		System.out.println(parentNode(i));
//		System.out.println(leftChild(i));
//		System.out.println(rightChild(i));
	}

	public void insertNode(int data) {
		if (size == capacity) {
			System.out.println("reached max capacity of array");
			return;
		}
		arr[size] = data;

		// check for swap
		int index = size;
		int parentNode = parentNode(index);
		int currentNode = arr[index];
		while (index >= 0) {
			if (arr[index] > parentNode) {
				// swap parent and current element
				arr[index] = parentNode;
				// parent index , changing index
				index = (index - 1) / 2;
				arr[index] = currentNode;
				parentNode = parentNode(index); // updated index
				// currentNode = arr[index];// updated index
			}else {
				break;
			}
		}
		size = size + 1;

	}

	public void traverseArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i+",");
		}
	}

	public static void main(String[] args) {
		MaxHeapDs heap = new MaxHeapDs(6);
		// 5,11,7,20
		heap.insertNode(20);
		heap.insertNode(10);
		heap.insertNode(30);
		heap.insertNode(5);
		heap.insertNode(50);
		heap.insertNode(40);
		heap.traverseArray(heap.arr);

	}

}
