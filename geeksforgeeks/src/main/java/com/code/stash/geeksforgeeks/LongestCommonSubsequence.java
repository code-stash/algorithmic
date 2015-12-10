package com.code.stash.geeksforgeeks;

public class LongestCommonSubsequence {
	
	
	private String firstSequence = "AGGTAB";
	private String seconString = "GXTXAYB";
	
	private char[] firstSequenceArray = firstSequence.toCharArray();
	private char[] secondSequenceArray = seconString.toCharArray();
	
	int fLength = firstSequence.length();
	int sLength = seconString.length();
	
	int[][] arr = new int[fLength+1][sLength+1]; 
	
	
	public int lcsLength(){
		for(int i=0; i<= fLength; i++){
			for(int j = 0; j<= sLength; j++){
				if(i==0 || j==0){
					arr[i][j] = 0;
					continue;
				}
				if(firstSequenceArray[i-1] == secondSequenceArray[j-1]){
					arr[i][j] = arr[i-1][j-1] + 1;
				}
				else{
					arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		return arr[fLength][sLength];
	}
	
	public String printLCS(){
		StringBuilder sb = new StringBuilder();
		int len = arr[fLength][sLength];
		for(int i = fLength , j=sLength; i > 0 && j> 0; ){
				if(firstSequenceArray[i-1] == secondSequenceArray[j-1]){
					sb.append(firstSequenceArray[i-1]);
					len--;
					i--; j--;
				}
				else if(arr[i-1][j] > arr[i][j-1]){
					i--;
				}
				else{
					j--;
				}
		}
		
		return sb.reverse().toString();
	}
	
	public static void main(String[] args){
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		lcs.lcsLength();
		System.out.println("The LCS length is :"+ lcs.lcsLength());
		System.out.println("Printing the LCS :"+ lcs.printLCS());
	}

}
