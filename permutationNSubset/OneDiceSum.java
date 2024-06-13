package com.leetcode.permutationNSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneDiceSum {

	public static void main(String[] args) {
		int sum = 4;
		//int arr[] = new int[] {1,2,3,4,5,6};
		//Arrays.sort(arr);
		
		System.out.println(diceSum("", sum));
	}
	
	private static List<String> diceSum(String p, int sum) {
		List<String> ansList = new ArrayList<>();
		
		if(sum == 0) {
			// System.out.println(p);
			
			ansList.add(p);
			
			return ansList;
		}
		
		for(int i=1; i<=6 && i<=sum; i++) {
			//diceSum(p+i, sum-i);
			ansList.addAll(diceSum(i+p, sum-i));
			//ansList.addAll(diceSum(p, sum-i));
		}
		return ansList;
		
		
	}
	

}
