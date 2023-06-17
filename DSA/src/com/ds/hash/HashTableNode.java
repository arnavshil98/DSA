package com.ds.hash;

/*
 * the bucket where list node is stored
 */
public class HashTableNode {

	private int bucketCount;
	private ListNode startNode;
	
	public HashTableNode() {
		
	}

	public HashTableNode(int bucketCount, ListNode startNode) {
		super();
		this.bucketCount = bucketCount;
		this.startNode = startNode;
	}

	public int getBucketCount() {
		return bucketCount;
	}

	public void setBucketCount(int bucketCount) {
		this.bucketCount = bucketCount;
	}

	public ListNode getStartNode() {
		return startNode;
	}

	public void setStartNode(ListNode startNode) {
		this.startNode = startNode;
	}
	
	
}
