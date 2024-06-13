package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/*
 * PROBLEM:
 * There are n kids with candies. You are given an integer array candies, 
 * 		where each candies[i] represents the number of candies the ith kid has, 
 * and an integer extraCandies, denoting the number of extra candies that you have.
 * Return a boolean array result of length n, where result[i] is true if, 
 * 		after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, 
 * 		or false otherwise.
 * 
 * Note that multiple kids can have the greatest number of candies.
 * 
 * */
public class KidWithGreatestNoOfCandies {

	public static void main(String[] args) {
		int[] candies = {12,1,12}; //{2,3,5,1,3};
		int extraCandies = 10; //3;
		
		System.out.println(kidsWithCandies(candies, extraCandies));

	}
	
	private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int highestCandiesAKidHas = highestNoOfCandies(candies);
        for(int i=0; i<candies.length; i++) {
        	if(candies[i]+extraCandies >= highestCandiesAKidHas)
        		ans.add(i, true);
        	else
        		ans.add(i, false);
        }
        return ans;
    }
	
	private static int highestNoOfCandies(int[] candies) {
		int greatest = -1;
        for(int i=0; i<candies.length; i++) {
        	if(candies[i] > greatest)
        		greatest = candies[i];
        }
        return greatest;
    }

}
