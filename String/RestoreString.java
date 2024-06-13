package com.leetcode.String;

public class RestoreString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "codeleet";
		int[] indices = {4,5,6,7,0,2,1,3};
		
		System.out.println("The restored String is : "+restoreString(s,indices));
	}
	
	private static String restoreString(String s, int[] indices) {
        char[] restoreString = new char[s.length()];
        for(int i=0; i< s.length(); i++){
        	restoreString[indices[i]] = s.charAt(i);
        }
        return String.valueOf(restoreString);
    }

}
