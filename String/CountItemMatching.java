package com.leetcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 
 * PROBLEM:
 * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. 
 * You are also given a rule represented by two strings, ruleKey and ruleValue.
 * The ith item is said to match the rule if one of the following is true:
 * 		ruleKey == "type" and ruleValue == typei.
 * 		ruleKey == "color" and ruleValue == colori.
 * 		ruleKey == "name" and ruleValue == namei.
*/
public class CountItemMatching {

	public static void main(String[] args) {
		// items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]]
		
		List<List<String>> items = new ArrayList<List<String>>() {{
            add(Arrays.asList("phone","blue","pixel"));
            add(Arrays.asList("computer","silver","phone"));
            add(Arrays.asList("phone","gold","iphone"));
        }};
        
        String ruleKey = "type", ruleValue = "phone";
        
        System.out.println("Count of Matching Item is : "+countMatches(items,ruleKey,ruleValue));
	}
	
	private static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for(int i=0; i<items.size(); i++) {
        	List<String> item = items.get(i);
        	if(ruleKey.equals("type")) {
        		if(item.get(0).equals(ruleValue))
        			count++;
        	}else if(ruleKey.equals("color")) {
        		if(item.get(1).equals(ruleValue))
        			count++;
        	}else if(ruleKey.equals("name")) {
        		if(item.get(2).equals(ruleValue))
        			count++;
        	}
        }
        return count;
    }

}
