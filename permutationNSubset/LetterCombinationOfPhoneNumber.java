package com.leetcode.permutationNSubset;

import java.util.ArrayList;
import java.util.List;

/*
 * 
 * Given a string containing digits from 2-9 inclusive, 
 * 		return all possible letter combinations that the number could represent. 
 * 		Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 		2 - abc
 * 		3 - def
 * 		4 - ghi
 * 		5 - jkl
 * 		6 - mno
 * 		7 - pqrs
 * 		8 - tuv
 * 		9 - wxyz
 * 
*/
public class LetterCombinationOfPhoneNumber {

	public static void main(String[] args) {
		String digits = "234";
		
		System.out.println(letterCombinations(digits, ""));
		System.out.println(letterCombinationsCount(digits, ""));
		
		
		
		
		/*
		 * for(int i=0; i< digits.length(); i++) { // for each digit in digits ->
		 * 2,3,... String str1 = letterSequence(digits.charAt(i)); // -> a,b,c... String
		 * seq = ""; for(int j=0; j<str1.length(); j++) { // for each character in the
		 * charsequence for that digit String str2 = letterSequence(digits.charAt(j)); }
		 * }
		 */

	}
	
	private static List<String> letterCombinations(String digits, String processed) {
        List<String> ans = new ArrayList<String>();
        
        if(digits.length() <= 0) {
        	if(processed.equals(""))
        		return ans;
        	ans.add(processed);
        	return ans;
        }
        
        String str1 = letterSequence(digits.charAt(0)); //  a, b, c

    	for(int j=0; j<str1.length(); j++) { // for each character in the charsequence for that digit -> for each a, b, c ...
    		 ans.addAll( letterCombinations(digits.substring(1), processed+str1.charAt(j)));
    	}

		return ans;
        
    }
	
	private static int letterCombinationsCount(String digits, String processed) {
        List<String> ans = new ArrayList<String>();
        int count = 0;
        
        if(digits.length() <= 0) {
        	if(processed.equals(""))
        		return 0;
        	ans.add(processed);
        	return 1;
        }
        
        String str1 = letterSequence(digits.charAt(0)); //  a, b, c

    	for(int j=0; j<str1.length(); j++) { // for each character in the charsequence for that digit -> for each a, b, c ...
    		 count += letterCombinationsCount(digits.substring(1), processed+str1.charAt(j));
    	}

		return count;
        
    }
	
	private static String letterSequence(char str) {
		switch (str) {
			case '2' : 
				return "abc";
			case '3' : 
				return "def";
			case '4' : 
				return "ghi";
			case '5' : 
				return "jkl";
			case '6' : 
				return "mno";
			case '7' : 
				return "pqrs";
			case '8' : 
				return "tuv";
			case '9' : 
				return "wxyz";
		}
		return "";
	}

}
