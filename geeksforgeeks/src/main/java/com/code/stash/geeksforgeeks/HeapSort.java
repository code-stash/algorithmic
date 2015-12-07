package com.code.stash.geeksforgeeks;

public class HeapSort {

	public void build(int[] array) {
		for(int i=0; i< array.length; i++){
			Utils.heapify(array, i);
		}
	}
	public void sort(int[] arr){
		build(arr);
		int heapSize = arr.length -1;
		for(int i = heapSize; i> 0 ; i--){
			Utils.swap(arr, 0, i);
			heapSize--;
			Utils.heapify(arr, 0);
		}
	}
	public static void main(String[] args){
	   int[] arr = {2,3,1,5,4};
	   HeapSort hs = new HeapSort();
	   System.out.println("Before");
	   Utils.display(arr);
	   hs.sort(arr);
	   System.out.println("After");
	   Utils.display(arr);
	}

}
