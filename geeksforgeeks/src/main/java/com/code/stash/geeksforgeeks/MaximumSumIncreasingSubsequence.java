package com.code.stash.geeksforgeeks;

public class MaximumSumIncreasingSubsequence {
	
	private int[] arr = {4,6,1,3,8,4,6};
	private int[] sumArr = {4,6,1,3,8,4,6};
	private int[] indexArr = {0,1,2,3,4,5,6};
	
	public int maxSumSubSequence(){
		int i=1;
		
		while(i<arr.length){
			int j=0;
			while(j<i){
				if(arr[j] < arr[i] && arr[i] + sumArr[j] > sumArr[i]){
					sumArr[i] = arr[i] + sumArr[j];
					indexArr[i] = j;
				}
				j++;
			}
			i++;
		}
		
		return findMax(sumArr);
		
	}
	
	public int findMax(int[] arr){
		int max = Integer.MIN_VALUE;
		int i = 0;
		while(i< arr.length){
			if(arr[i] > max ){
				max = arr[i];
			}
			i++;
		}
		return max;
	}
	
	public int findMaxIndex(int[] arr){
		int max = Integer.MIN_VALUE;
		int i = 0;
		int maxIndex = -1;
		while(i< arr.length){
			if(arr[i] > max ){
				max = arr[i];
				maxIndex = i;
			}
			i++;
		}
		return maxIndex;
	}
	
	public String printActualSequence(){
		StringBuilder sb = new StringBuilder();
		int readIndex = findMaxIndex(sumArr);
		sb.append(arr[readIndex]);
		sb.append(",");
		while(readIndex > 0){
			sb.append(arr[indexArr[readIndex]]);
			sb.append(",");
			readIndex = indexArr[readIndex];
		}
		sb.replace(sb.length()-1, sb.length(), "");
		return sb.reverse().toString();
	}
	
	public static void main(String[] args){
		MaximumSumIncreasingSubsequence msis = new MaximumSumIncreasingSubsequence();
		System.out.println("Printing the max sum of the increasing sub sequence : "+msis.maxSumSubSequence());
		System.out.println("Actual Sequence : "+ msis.printActualSequence());
	}
	

}
