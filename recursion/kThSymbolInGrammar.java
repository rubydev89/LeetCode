package com.leetcode.recursion;


/*
 * 
 * We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. 
 * 		Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * 		For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.
 * 		Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
*
*/
public class kThSymbolInGrammar {
	
	static {
		System.out.println("I am static");
	}
	
	public static void main(String[] args) {
		
		System.out.println("I am main");
		
		kThSymbolInGrammar ex = new kThSymbolInGrammar();
		
		int n=30;
		int k=434991989;
		//System.out.println(Math.pow(2, 29)/2);
		//System.out.println(kthGrammar(n,k));
		
		// prevK = 
		/* for nth row
		 * if(k > Math.pow(2,n-1)/2)
		 * */

	}
	
	private static int kthGrammar(int n, int k) {
		String nThGrammar = kthGrammar(n);
		return Character.digit(nThGrammar.charAt(k-1),10);
    }
	
	private static String kthGrammar(int n) {
		if(n==1)
			return "0";
		
		return replace(kthGrammar(n-1));
	}
	
	private static String replace(String str) {
		StringBuilder ans = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '0')
				ans.append("01");
			else
				ans.append("10");	
		}
		return ans.toString();
	}

}
