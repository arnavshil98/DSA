package com.ds.hash;
/*
 * actual data structure hash table , store data in k,v pair
 * average case insertion , search, delete O(1).
 */
public class HashTable {

	private int tsize; // size of the buckets
	private int count; // no of elements stored
	private HashTableNode[] table; 

	public int getTsize() {
		return tsize;
	}

	public HashTable(int size) {
		this.tsize = size;
		this.count =0;
		this.table = new HashTableNode[size];
	}
	
	public void setTsize(int tsize) {
		this.tsize = tsize;
		this.table = new HashTableNode[tsize];
		
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public HashTableNode[] getTable() {
		return table;
	}

	public void setTable(HashTableNode[] table) {
		this.table = table;
	}

	public HashTable() {

	}


	
	
}
