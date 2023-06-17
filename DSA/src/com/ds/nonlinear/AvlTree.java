package com.ds.nonlinear;

public class AvlTree {

	Node head;

	public static class Node {
		Node left;
		Node right;
		int datamember;

		public Node(int x) {
			this.datamember = x;
		}

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

	// RR rotation or left rotation
	public static Node leftRotation(Node x) {
		Node y = x.right;
		Node t2 = y.left;
		y.left = x;
		x.right = t2;

		return y;
	}

	// LL rotation or ,right rotation
	public static Node rightRotation(Node x) {
		Node y = x.left;
		Node t2 = y.right;

		y.right = x;
		x.left = t2;
		return y;
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
			} else // Duplicate keys not allowed
				return root;
		}

		// conditions of avl trees

		int leftBalance = balance(root);
		int rightBalance = balance(root);

		int balanceAtNode = leftBalance - rightBalance;

		// LL ROTATION
		if (balanceAtNode > 1 && x < root.left.datamember) {
			return rightRotation(root);
		}
		// RR ROATATION

		if (balanceAtNode < -1 && x > root.right.datamember) {
			return leftRotation(root);
		}
		// LR ROTATION
		if (balanceAtNode > 1 && x > root.left.datamember) {
			root.left =  leftRotation(root.left);
			return rightRotation(root);
		}

		// RL ROTATION

		if(balanceAtNode<-1 && x<root.right.datamember) {
			root.right =  rightRotation(root.right);
			return leftRotation(root);
		}
		
		return root;

	}

	public static void main(String[] args) {

	}

}
