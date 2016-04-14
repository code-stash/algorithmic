package com.code.stash.geeksforgeeks;

public class MinEditDistance {
	
	private String str1 = "geek";
	private String str2 = "gesek";
	
	private char[] str1Char = str1.toCharArray();
	private char[] str2Char = str2.toCharArray();
	
	
	private int[][] dMatrix = new int[str1.length() + 1][str2.length() + 1]; 
    
	public int getMinEditDistance(){
		
		for(int i=0;i<= str1.length(); i++){
			for(int j=0; j<= str2.length(); j++){
			    if(i==0){
			    	dMatrix[i][j] = j;
			    }
			    else if(j==0){
			    	dMatrix[i][j] = i;
			    }
				else if(str1Char[i-1] == str2Char[j-1]){
				    dMatrix[i][j] = dMatrix[i-1][j-1];
				}
				else{
					dMatrix[i][j] = getMin(dMatrix[i-1][j-1],dMatrix[i-1][j], dMatrix[i][j-1]) + 1;
				}
				
			}
		}
		return dMatrix[str1.length()][str2.length()];
	}
	
	public int getMin(int val1, int val2, int val3){
		int l1 = val1 < val2 ? val1 : val2;
		int retVal = l1 < val3 ? l1 : val3;	
		return retVal;
	}
	
	public static void main(String[] args){
		MinEditDistance med = new MinEditDistance();
		System.out.println("The min edit distance between the strings :"+med.str1+" and "+med.str2 +" is :"+ med.getMinEditDistance());
	}
}
