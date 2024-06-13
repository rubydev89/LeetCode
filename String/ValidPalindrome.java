package com.leetcode.String;

public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "A man, a plan, a canal: Panama";
		System.out.println("Is the string palindrome : "+isWordPalindrome(a.trim().toUpperCase()));

	}
	
	private static boolean isWordPalindrome(String s) {
        int start=0;
        int end = s.length() - 1;
        while(start <= end) {
        	char sChar = s.charAt(start);
            char eChar = s.charAt(end);
        	
        	boolean startIsAlphaNumeric = (sChar-0 >= 48 && sChar-0 <= 57) || (sChar-0 >= 65 && sChar-0 <= 90);
        	boolean endIsAlphaNumeric = (eChar-0 >= 48 && eChar-0 <= 57) || (eChar-0 >= 65 && eChar-0 <= 90);
        	if(!startIsAlphaNumeric){
				start++;
        	}
        	if(!endIsAlphaNumeric){
        		end--;
        	}
        	if(startIsAlphaNumeric && endIsAlphaNumeric) {

            	if(s.charAt(start) != s.charAt(end))
            		return false;
            	start++;
            	end--;
        	}
        }
		return true;
    }

}
