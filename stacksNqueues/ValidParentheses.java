package com.leetcode.stacksNqueues;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s = "((";
		
		System.out.println(isValid(s));

	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[') {
				stack.push(c);
			}else {
				if(stack.isEmpty())
					return false;
				else {
					char peeked = stack.peek();
					if((peeked == '(' && c == ')') || (peeked == '{' && c == '}') || (peeked == '[' && c == ']')) {
						stack.pop();
					}else {
						return false;
					}
				}
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}

}
