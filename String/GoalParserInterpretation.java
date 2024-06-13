package com.leetcode.String;

/*
 * PROBLEM:
 * You own a Goal Parser that can interpret a string command. 
 * The command consists of an alphabet of "G", "()" and/or "(al)" in some order. 
 * The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". 
 * The interpreted strings are then concatenated in the original order.
 * Given the string command, return the Goal Parser's interpretation of command.
 * 
 * Constraints:
 * 1 <= command.length <= 100
 * command consists of "G", "()", and/or "(al)" in some order.
 * 
 * */
public class GoalParserInterpretation {

	public static void main(String[] args) {
		String command = "(";
		
		System.out.println("The interpreted commange is : "+interpret(command));

	}
	
	private static String interpret(String command) {
		StringBuilder interpretedCommand = new StringBuilder();
        for(int i=0; i<command.length(); i++) {
        	if(command.charAt(i) == 'G') {
        		interpretedCommand.append('G');
        	}else if(command.charAt(i) == '(' && i<command.length()-1 && command.charAt(i+1) == ')') {
        		interpretedCommand.append('o');
        		i++;
        	}else if(command.charAt(i) == '(' && i<command.length()-1 && command.charAt(i+1) == 'a'){
        		interpretedCommand.append("al");
        		i += 3;
        	}
        }
		return interpretedCommand.toString();
    }	

}
