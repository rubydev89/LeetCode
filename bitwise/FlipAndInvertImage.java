package com.leetcode.bitwise;

import java.util.Arrays;

/*
 * PROBLEM:
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
 * 		To flip an image horizontally means that each row of the image is reversed.
 * 			For example, flipping [1,1,0] horizontally results in [0,1,1].
 * 		To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * 			For example, inverting [0,1,1] results in [1,0,0].
 * */
public class FlipAndInvertImage {
	public static void main(String[] args) {
		int nums[][] = {{1,1,0},{1,0,1},{0,0,0}};
		System.out.println(nums);
		
		System.out.println(Arrays.toString(flipAndInvertImage(nums)));
	}
	
	private static int[][] flipAndInvertImage(int[][] image) {
        for(int row=0; row<image.length; row++) {
        	int start = 0;
        	int end = image[row].length-1;
        	while(start <= end) {
        		int temp = image[row][start] ^ 1;
        		image[row][start] = image[row][end] ^ 1;
        		image[row][end] = temp;
        		start++;
        		end--;
        	}
        }
        return image;
    }
}
