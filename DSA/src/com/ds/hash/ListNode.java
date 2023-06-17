package com.ds.hash;
/*
 * act as the list node inside the hash table bucket.
 * linked list
 */
public class ListNode {

	private int key;
	private int data;
	private ListNode next;
	
	public ListNode() {
		
	}
	
	public ListNode(int key, int data, ListNode next) {
		super();
		this.key = key;
		this.data = data;
		this.next = next;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
}
