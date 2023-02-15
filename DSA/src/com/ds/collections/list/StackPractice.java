package com.ds.collections.list;

import java.util.Stack;

/*
 * stack using linked list and using queue ds 
 */
public class StackPractice {

	static Node head;

	public static class Node {
		int dataMember;
		Node next;
		Node prev;

		public Node(int x) {
			this.dataMember = x;
			this.prev = null;
			this.next = null;
		}
	}

	public static final StackPractice push(StackPractice list, int x) {
		Node newNode = new Node(x);
		if (list.head == null) {
			list.head = newNode;
			return list;
		} else {
			Node curNode = list.head;
			while (curNode.next != null) {
				curNode = curNode.next;
			}
			curNode.next = newNode;
			// as dll, thus new node left reference = curNode
			newNode.prev = curNode;

		}
		return list;
	}

	public static final StackPractice  pop(StackPractice list) throws Exception {
		// all data deleted,including head
		/*
		 * wrong exception handling
		 */
//		if (list.head == null) {
//			throw new Exception("stack is empty");
//		} else {
			Node curNode = list.head;
			while (curNode.next != null) {
				curNode = curNode.next;
			}
			// removing reference
			Node prevNode = curNode.prev;
			if(prevNode!=null) {
			prevNode.next = null;
			// deleting last node
			curNode = null;
			}
		//}
		return list;
	}

	public static void printList(StackPractice list) {
		Node currNode = list.head;

		System.out.print("Stack: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.dataMember + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}

	public static void main(String[] args) throws Exception {

		StackPractice list = new StackPractice();
		push(list, 2);
		push(list, 3);
		push(list, 4);
		push(list, 5);
		printList(list);
		System.out.println("");
		System.out.println("pop executed");
		System.out.println("=============");
		pop(list);
		pop(list);
		pop(list);
		pop(list);
		printList(list);
		
	}

}
