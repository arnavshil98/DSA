package com.ds.nonlinear;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * add elements
 * in-order, pre-order, post-order traversal
 * level order traversal
 * height
 * longest path elements
 * AVL trees
 */
public class BinarySearchTree {

	Node head;

	public static class Node {
		Node left;
		Node right;
		int datamember;

		public Node(int x) {
			this.datamember = x;
		}

	}

	public static Node insertElement(Node root, int x) {
		Node newNode = new Node(x);
		if (root == null) {
			root = newNode;
		} else {
			if (x < root.datamember) {
				root.left = insertElement(root.left, x);
			} else if (x > root.datamember) {
				root.right = insertElement(root.right, x);
			}
		}
		return root;

	}

	public static int height(Node node) {
		if (node == null) {
			return 0;
		}
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	public static int balance(Node node) {
		return height(node.left) - height(node.right);
	}

	public static void inorderTraversal(Node root) {
		if (root == null)
			return;
		inorderTraversal(root.left);
		System.out.print(root.datamember + ",");
		inorderTraversal(root.right);
	}

	static Queue<Node> queue = new LinkedList<Node>();

	public static void levelOrderTraversal(Node root) {
		if (queue.isEmpty()) {
			queue.add(root);
		}

		while (!queue.isEmpty()) {
			Node polledElement = queue.poll();
			System.out.println(polledElement.datamember);
			if (polledElement.left != null) {
				queue.add(polledElement.left);
			}
			if (polledElement.right != null) {
				queue.add(polledElement.right);
			}
		}

	}

	public static void main(String[] args) {
		Node root = null;
		Node originalRoot = null;
		int[] arr = { 42, 33, 55, 21, 39, 41 }; // BST
		for (int i : arr) {
			if (root == null) {
				root = insertElement(root, i);
				originalRoot = root;
			} else {
				root = insertElement(root, i);
			}
		}

		System.out.println("in order traversal:");
		inorderTraversal(originalRoot);

		System.out.println(" \n" + "height of node: " + originalRoot.datamember + " is \n" + height(originalRoot));

		System.out.println("level-order traversal:");
		levelOrderTraversal(originalRoot);
	}

}
