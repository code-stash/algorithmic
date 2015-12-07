package com.code.stash.geeksforgeeks;

public class MinHeap implements IHeap {

	int[] arr = new int[5];
	int heapCurrent = 0;

	@Override
	public void insert(int value) throws Exception {
		System.out.println("Heapcurrent : "+heapCurrent );
		if (heapCurrent > arr.length-1 ) {
			throw new Exception("heap is full");
		} else {

			arr[heapCurrent] = value;

			while (Utils.getParent(heapCurrent) >=0 && arr[heapCurrent] < arr[Utils.getParent(heapCurrent)]) {
				Utils.swap(arr, Utils.getParent(heapCurrent), heapCurrent);
			}
			heapCurrent++;
		}
	}
	
	

	@Override
	public int delete() throws Exception {
		if(heapCurrent-1 < 0){
			throw new Exception("Heap is empty");
		}
		
		int retVal = arr[0];
       
		arr[0] = arr[heapCurrent-1]; //copy the last element to root and shift down the root
		
		heapCurrent--;
		int i = 0;
		while(Utils.getLeft(i) <= heapCurrent  || Utils.getRight(i) <=heapCurrent){
			int left = Utils.getLeft(i);
			int right = Utils.getRight(i);
			
			if(left <= heapCurrent && right <= heapCurrent){
				if(arr[left] < arr[right]){
					if(arr[left]<arr[i]){
						Utils.swap(arr, left, i);
					}
				}
				if(arr[right] < arr[left]){
					if(arr[right]<arr[i]){
						Utils.swap(arr, right, i);
					}
				}
			}
			
			if(left <= heapCurrent && !(right <= heapCurrent)){
				
					if(arr[left]<arr[i]){
						Utils.swap(arr, left, i);
					}
				
			}
			
			if(!(left <= heapCurrent) && (right <= heapCurrent)){
			
					if(arr[right]<arr[i]){
						Utils.swap(arr, right, i);
					}
				
			}
		i++;			
		}
		arr[heapCurrent] = 0;
		return retVal;
	}
	
	public void display(){
		Utils.display(arr);
	}
	
	public static void main(String[] args){
		MinHeap heap = new MinHeap();
		try{
		
		heap.insert(2);
		heap.insert(3);
		heap.insert(1);
		heap.insert(5);
		heap.insert(4);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		System.out.println("Display heap after inserting 5 elements");
		heap.display();
		try {
	    System.out.println("Two :"+heap.delete());
		
//		
		System.out.println("Three");
		heap.display();
		System.out.println("Four :"+heap.delete());
		
		
		heap.display();
		
        System.out.println("Five :"+heap.delete());
		
		
		heap.display();
		
        System.out.println("Six :"+heap.delete());
		
		
		heap.display();
		
        System.out.println("Seven :"+heap.delete());
		
		
		heap.display();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
