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
	private static Node searchingNode;

	/*
	 * this is iterative approach
	 */
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

	public static Node searchingNode(Node node, int datamember) {
		while (node != null) {
			if (node.datamember == datamember)
				break;
			if (datamember < node.datamember) {
				node = node.left;
			} else {
				node = node.right;
			}

		}
		return node;
	}

	public static Node deleteNode(Node node, int datamamber) {
		Node deletingNode = searchingNode(node, datamamber);

		Node ancestorNodeOfDeletingNode = null;
		Node nextAncestorNode = node;
		while (nextAncestorNode != null) {
			if (nextAncestorNode.datamember == deletingNode.datamember)
				break;
			if (deletingNode.datamember <= nextAncestorNode.datamember) {
				ancestorNodeOfDeletingNode = nextAncestorNode;
				nextAncestorNode = nextAncestorNode.left;
			} else {
				ancestorNodeOfDeletingNode = nextAncestorNode;
				nextAncestorNode = nextAncestorNode.right;
			}
		}
		/*
		 * right subtree, lowest node
		 */
		Node leftChildNode = deletingNode.left;
		Node rightChildNode = deletingNode.right;
		Node nextNode = deletingNode.right;
		Node ancestorNode = null;
		while (nextNode.left != null) {
			ancestorNode = nextNode;
			nextNode = nextNode.left;
		}
		Node floatingNode = nextNode.right;

		deletingNode = nextNode;
		deletingNode.left = leftChildNode;
		deletingNode.right = rightChildNode;
		if (ancestorNodeOfDeletingNode.datamember >= deletingNode.datamember) {
			ancestorNodeOfDeletingNode.left = deletingNode;
		} else {
			ancestorNodeOfDeletingNode.right = deletingNode;
		}

		ancestorNode.left = floatingNode;

		return node;
	}

	public void longestPath(Node root) {

	}

	public static void main(String[] args) {
		Node root = null;
		Node originalRoot = null;
		int[] arr = { 38, 24, 45, 20, 30, 15, 28, 35, 29 }; // BST
		for (int i : arr) {
			if (root == null) {
				root = insertElement(root, i);
				originalRoot = root;
			} else {
				root = insertElement(root, i);
			}
		}

		System.out.println("in order traversal:");
		// inorderTraversal(originalRoot);

		System.out.println(" \n" + "height of node: " + originalRoot.datamember + " is \n" + height(originalRoot));

		System.out.println("level-order traversal:");
		levelOrderTraversal(originalRoot);

		System.out.println("searching node in BST: O(nlogn)");
		Node newNode = searchingNode(originalRoot, 35);
		System.out.println(newNode.datamember);

		deleteNode(originalRoot, 24);
		System.out.println("in-order traversal after deleting node:");
		inorderTraversal(originalRoot);
	}

}
