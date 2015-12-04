package com.code.stash.geeksforgeeks;

public class BinarySearch {
	
	public int binarySerach(int[] arr, int low, int high, int key){
		int mid = low + (high-low)/2;
		
		if(arr[mid] == key){
			return mid;
		}
		if(key < arr[mid]){
			return binarySerach(arr, 0, mid, key);
		}
		if(key > arr[mid]){
			return binarySerach(arr, mid+1, arr.length - 1, key);
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] arr = {2,3,5,4,1};
		BinarySearch bser = new BinarySearch();
		int pos = bser.binarySerach(arr, 0, arr.length -1, 3);
		System.out.println("Position of 3 is :"+ pos);
	}

}
