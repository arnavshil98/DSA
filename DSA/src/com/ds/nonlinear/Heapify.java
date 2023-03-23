package com.ds.nonlinear;

public class Heapify {

	int[] arr = {20,10,30,5,50,40,45};
	// already array present
	
	//	we will check starting from parent node of the leaf node.
	//	[20,10,30,5,50,40,45]
		/*
		 *    20
		 *  10   30
		 * 5 50 40 45
		 * we will start from 30 = length/2
		 */
		// time complexity: O(N)
	public void buildHeap(int[] arr) {	
		for(int i = ((arr.length)/2)-1; i>=0;i--) {
			heapify(i);
		}
	}
	
	public int leftChild(int i) {
		return arr[(2*(i))+1];
	}
	
	public int rightChild(int i) {
		return arr[(2*(i))+2];
	}
	
	private void heapify(int i) {
		// compare left and parent, larger will be chosen and put to parent position
		int left = leftChild(i);
		if(arr[i]<left) {
			// swap positions
			arr[(2*(i))+1] = arr[i];
			arr[i] = left;
			// parent is updated
		}

		// left child after swap or not swapped will be always smaller
		
		// compare right and parent, larger will be chosen and put to parent position 
		int right = rightChild(i);
		if(arr[i]<right) {
			// swap positions
			arr[(2*(i))+2] = arr[i];
			arr[i] = right;
			// parent is updated
		}
	}

	public void traverseArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i+",");
		}
	}

	public static void main(String[] args) {
		Heapify heap = new Heapify();
		heap.buildHeap(heap.arr);
		
		heap.traverseArray(heap.arr);

	}

}
