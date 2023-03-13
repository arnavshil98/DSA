package com.ds.nonlinear;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

	Node head;

	public static class Node {
		Node left;
		Node right;
		int dataMember;

		public Node(int x) {
			this.left = null;
			this.right = null;
			this.dataMember = x;
		}
	}

	static Deque<Node> deque = new LinkedList<Node>();

	public static Node insertElements(Node node, int x) {
		Node newNode = new Node(x);

		if (node == null) {
			node = newNode;
			deque.add(node);
			return node;
		} else {
			Node ancestorNode = null;
			ancestorNode = deque.removeFirst();

			if (ancestorNode.left == null) {
				ancestorNode.left = newNode;
				deque.addLast(newNode);
				deque.addFirst(ancestorNode);
				return node;
			} else if (ancestorNode.right == null) {
				ancestorNode.right = newNode;
				deque.addLast(newNode);
				return node;
			}
		}
		return node;
	}

	public static void main(String[] args) {
		BinaryTree obj = new BinaryTree();
		Scanner sc = new Scanner(System.in);
		Node node = null;
		int i = 1;
		while (i <= 7) {
			System.out.println("please provide input: ");
			int value = sc.nextInt();
			node = obj.insertElements(node, value);
			i++;
		}

	}

}
