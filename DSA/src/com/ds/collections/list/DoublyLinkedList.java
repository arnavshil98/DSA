package com.ds.collections.list;

public class DoublyLinkedList {

	static Node head;

	public static class Node {
		int dataMember;
		Node prev;
		Node next;

		public Node(int x) {
			this.dataMember = x;
			this.prev = null;
			this.next = null;
		}
	}

	public static DoublyLinkedList addLast(DoublyLinkedList list, int x) {
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

	public static DoublyLinkedList addAfterKey(DoublyLinkedList list, int x, int key) {
		/*
		 * handle exception for no key found initial head while loop for match data
		 * member.
		 */

		Node newNode = new Node(x);
		if (list.head == null) {
			list.head = newNode;
			return list;
		} else {
			Node curNode = list.head;
			while (curNode.dataMember != key) {
				curNode = curNode.next;
			}
			Node oldNextNode = curNode.next;
			curNode.next = newNode;
			newNode.prev = curNode;
			newNode.next = oldNextNode;
		}

		return list;
	}
	
	public static DoublyLinkedList reverseDll(DoublyLinkedList list) {
		
		return null;
		
	}

	public static void printList(DoublyLinkedList list) {
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.dataMember + " ");

			// Go to next node
			currNode = currNode.next;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		addLast(list, 3);
		addLast(list, 5);
		addLast(list, 1);
		addLast(list, 7);
		addAfterKey(list, 4, 5);
		printList(list);
	}
}
