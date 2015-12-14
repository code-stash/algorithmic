package com.code.stash.geeksforgeeks;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	private int[] arr = {3, 1, 2, 3, 6};
	private int[] lis = new int[arr.length];
	
	public int lisLength(){
		int i = 1;
		Arrays.fill(lis, 1);
		while(i < arr.length){
			int j = 0;
			while(j < i){
				if(arr[j] < arr[i] && lis[j]+1> lis[i]){
					lis[i] = lis[j] + 1;
				}
				j++;
			}
			i++;
		}
		
		int max = Integer.MIN_VALUE;
		
		System.out.println("Actual arr :");
		Utils.display(arr);
		
		System.out.println("Lis arr :");
		Utils.display(lis);
		
		int x = 0;
		while(x < lis.length){
			if(max < lis[x]){
				max = lis[x];
			}
			x++;
		}
		return max;
	}
	
	public String printLis(int len){
		StringBuilder sb = new StringBuilder();
		for(int i = len; i>0; i--){
			if(lis[i] == len){
				sb.append(arr[i]);
				len--;
			}
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args){
		LongestIncreasingSubsequence li = new LongestIncreasingSubsequence();
		System.out.println("Length of longest increasing subsequence is :"+ li.lisLength());
		
	    System.out.println("Actual longest increasing subsequence is :"+ li.printLis(li.lisLength()));
	}
	
}
