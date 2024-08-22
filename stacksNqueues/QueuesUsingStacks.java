package com.leetcode.stacksNqueues;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueuesUsingStacks {
	
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public static void main(String[] args) {
		
		QueuesUsingStacks myQue = new QueuesUsingStacks();
		
		myQue.push(1);
		myQue.push(3);
		myQue.push(2);
		myQue.push(4);
		System.out.println("PEEK "+myQue.peek());
		
		System.out.println(myQue.pop());
		System.out.println("PEEK "+myQue.peek());
		
		System.out.println(myQue.pop());
		System.out.println(myQue.pop());
		

	}
	
	public QueuesUsingStacks() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
    }
    
	//Pop Efficient
	//Time Complexity O(n)
    public void push(int x) {
    	while(!stack1.isEmpty()) {  
    		stack2.push(stack1.pop());
    	}
    	stack1.push(x);
    	while(!stack2.isEmpty()) {
    		stack1.push(stack2.pop());
    	}
    }
    
    public int pop() throws NoSuchElementException{
    	if(stack1.isEmpty()) {
    		throw new NoSuchElementException();
    	}
        return stack1.pop();
    }
    
    public int peek() {
    	return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.empty();
    }

}
