package com.ds.collections.list;

public class SinglyLinkedList{

	// until the cursor exits main method, this head will not be destroyed

	static Node head;

	public static class Node {
		int dataMember;
		Node next;

		public Node(int x) {
			this.dataMember = x;
			this.next = null;
		}

	}

	public static SinglyLinkedList addNodeLast(SinglyLinkedList list, int x) {
		if (list.head == null) {
			list.head = new Node(x);
			return list;
		}
		Node curNode = list.head;
		while (curNode.next != null) {
			curNode = curNode.next;
		}
		curNode.next = new Node(x);
		return list;
	}

	public static SinglyLinkedList addFirst(SinglyLinkedList list, int x) {

		if (list.head == null) {
			list.head = new Node(x);
			return list;
		} else {
			Node oldHeadNode = list.head;
			/*
			 * declaring new head; as list always start from head;
			 */
			list.head = new Node(x);
			list.head.next = oldHeadNode;
		}
		return list;

	}

	public static SinglyLinkedList addAfterKey(SinglyLinkedList list, int x, int existingData) throws Exception {

		/*
		 * 1. if no such data member found throw exception 2. else add node after
		 */
		Node curNode = list.head;
		while (curNode.dataMember != existingData) {
			if (curNode.next != null) {
				curNode = curNode.next;
			} else {
				// reached last of the list without data match
				throw new Exception("no such node exists");
			}

		}
		Node oldNextNode = curNode.next;
		if (oldNextNode != null) {
			curNode.next = new Node(x);
			curNode.next.next = oldNextNode;
		} else {
			curNode.next = new Node(x);
		}

		return list;
	}

	public static void printList(SinglyLinkedList list) {
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

	public static void main(String[] args) throws Exception {

		SinglyLinkedList list = new SinglyLinkedList();
		addNodeLast(list, 3);
		addNodeLast(list, 5);
		addNodeLast(list, 1);
		addNodeLast(list, 8);
		addFirst(list, 7);
		addAfterKey(list, 6, 5);
		addAfterKey(list, 12, 8);
		// addAfterKey(list, 12, 9);
		printList(list);
		
	}

}
