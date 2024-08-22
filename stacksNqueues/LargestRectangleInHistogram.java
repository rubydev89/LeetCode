package com.leetcode.stacksNqueues;

import java.util.Stack;

/*
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
 * 		return the area of the largest rectangle in the histogram.
 * 
 * */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int[] height = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(height));

	}
	
	public static int largestRectangleArea(int[] heights) {
		int max = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int i=1; i<heights.length; i++) {
			int topOfStack = stack.peek();
			while(heights[topOfStack] > heights[i]) {
				max = getMax(heights, stack, i, max);
			}
			stack.push(i);
		}
		
		return max;
		//return largestRectangleArea(heights, 0, 0);
    }
	
	private static int getMax(int[] heights, Stack<Integer> stack, int i, int max) {
		int maxArea = 0;
		
		return 0;
	}

	public static int largestRectangleArea(int[] heights, int barPosition, int maxArea) {
        if(barPosition >= heights.length) {
        	return maxArea;
        }
        
        if(heights.length == 1) {
        	return heights[0];
        }
        
        int barArea = heights[barPosition];
        
        int barHistogramArea = 0;
        int position = barPosition+1;
        int equalCount = barPosition;
        
        while(position <= heights.length-1 && heights[position] >= barArea) {
        	barHistogramArea += barArea;
        	position++;
        }
        
        position = barPosition-1;
        while(position >= 0 && heights[position] >= barArea) {
        	barHistogramArea += barArea;
        	position--;
        }
        
        return largestRectangleArea(heights, equalCount+1, Math.max((barArea + barHistogramArea), maxArea));
    }
	

}
