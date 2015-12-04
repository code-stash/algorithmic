package com.code.stash.geeksforgeeks;

public class FirstLastIndex {

	public int getFirstIndex(int[] arr, int low, int high, int key, int firstIndex) {
		int mid = low + (high - low) / 2;
		if (low <= high) {
			if (arr[mid] == key) {
				return getFirstIndex(arr, low, mid - 1, key, mid);
			}
			if (key < arr[mid]) {
				return getFirstIndex(arr, 0, mid, key, firstIndex);
			}
			if (key > arr[mid]) {
				return getFirstIndex(arr, mid + 1, high, key, firstIndex);
			}
		}

		return firstIndex;
	}

	public int getLastIndex(int[] arr, int low, int high, int key, int lastIndex) {
		int mid = low + (high - low) / 2;
		System.out.println("mid val: " + mid);
		if (low <= high) {
			if (arr[mid] == key) {
				return getLastIndex(arr, mid + 1, high, key, mid);
			}
			if (key < arr[mid]) {
				return getLastIndex(arr, low, mid-1, key, lastIndex);
			}
			if (key > arr[mid]) {
				return getLastIndex(arr, mid + 1, high, key, lastIndex);
			}
		}
		return lastIndex;
	}

	public static void main(String[] args) {
		FirstLastIndex fil = new FirstLastIndex();
		int[] arr = {2, 3, 3, 3, 3, 3, 6 };
		int firstIndex = fil.getFirstIndex(arr, 0, arr.length - 1, 3, -1);
	    int lastIndex = fil.getLastIndex(arr, 0, arr.length - 1, 3, -1);

		System.out.println("First index of 3 : " + firstIndex);
	    System.out.println("Last index of 3 : "+lastIndex );
	}

}
