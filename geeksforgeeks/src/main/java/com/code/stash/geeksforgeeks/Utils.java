package com.code.stash.geeksforgeeks;

public class Utils {
	
	public static int[] swap(int [] arr, int from, int to){
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
		return arr;
	}
	
	public static int getRight(int position) {
		return 2*(position + 1);
	}


	public static int getLeft(int position) {
		return 2*position + 1;
	}

	public static int getParent(int position) {
		return (position -1)/2;
	}
	
	public static void heapify(int[] arr, int position) {
		int left = getLeft(position);
		int right = getRight(position);
		int min = position;
		
		if(left <= arr.length -1 && arr[left] < arr[min]){
			min = left;
		}
		
		if(right <= arr.length -1 && arr[right]< arr[min]){
			min = right;
		}
		if(min != position){
			Utils.swap(arr, position, min);
			heapify(arr, min);
		}
	}
	
	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i] + "\t");
	}

}
