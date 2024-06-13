package com.leetcode.recursion;

/* 
 * Given a string find its first uppercase letter
 * 
 * */
public class FirstUpperCaseLetterInString {

	public static void main(String[] args) {
		String str = "geekS";
		System.out.println("The index of first upper case is : "+firstUpperCaseLetterInString(str, 0));

	}
	
	private static char firstUpperCaseLetterInString(String str, int start) {
		if(start > str.length()-1)
			return '-';
		if(str.charAt(start)-0 >= 65 && str.charAt(start)-0 <= 97)
			return str.charAt(start);
		else
			return firstUpperCaseLetterInString(str, start+1);
	}

}
