package com.ds.hash;

public class HashTableOperations {

	public final static int LOADFACTOR = 20;
	
	// creating hash table
	
	public static HashTable createHashTable(int size) {
		HashTable hashTable = new HashTable();
		hashTable.setTsize(size/LOADFACTOR);
		
		// set all the nodes initially to the table as null;
		for(int i=0;i<hashTable.getTsize();i++) {
			 hashTable.getTable()[i].setStartNode(null);
		}
		return hashTable;
	}
}
