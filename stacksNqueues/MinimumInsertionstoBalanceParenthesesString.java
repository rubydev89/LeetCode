package com.leetcode.stacksNqueues;

import java.util.Stack;

public class MinimumInsertionstoBalanceParenthesesString {

	public static void main(String[] args) {
		String s = "(()))(()))()())))";//"))())(";
		
		System.out.println(minInsertions(s));

	}
	
	public static int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        
        for(char c : s.toCharArray()) {
        	if(c == '(') {
        		count += emptyStack(stack);
        		stack.push(c);
        	}else {
        		if(!stack.isEmpty() && stack.peek() == ')') {
        			stack.pop();
                    if(!stack.isEmpty() && stack.peek() == '(')
                        stack.pop();
                    else
                    	count++;
        		}else {
        			stack.push(c);
        		}
        	}
        }
        
        while(!stack.isEmpty()) {
        	char c = stack.pop();
        	if(c == '(')
        		count += 2;
        	else { // if the character is ')'
        		if(!stack.isEmpty() && stack.peek() == '(') {
        			stack.pop();
            		count++;
        		}else if(!stack.isEmpty() && stack.peek() == ')') {
        			stack.pop();
        			count++;
        		}else{
                    count += 2;
                }
                    
        	}
        		
        }
        
        return count;
    }

	private static int emptyStack(Stack<Character> stack) {
		if(stack.isEmpty())
			return 0;
		int count = 0;
		while(!stack.isEmpty()) {
			char c = stack.peek();
			if(c == '(')
				return 0;
			else {
				int openCount = 0;
				while(!stack.isEmpty() && stack.peek() != '(') {
					stack.pop();
					openCount++;
				}
				stack.pop();
				count = (openCount/2) + (openCount%2)*2;
			}
		}
		System.out.println(count);
		return count;
	}

}
