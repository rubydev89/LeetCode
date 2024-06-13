package com.leetcode.arrays;

public class RichestCustomerWealth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int accounts[][] = {{2,8,7},{7,1,3},{1,9,5}};//{{1,2,3},{3,2,1}};
		
		System.out.println("The wealthiest amount is : "+maximumWealth(accounts));

	}
	
	private static int maximumWealth(int[][] accounts) {
        int richestAmount = -1;
        for(int row=0; row<accounts.length; row++){
            int wealthOfI = 0;
            for(int col=0; col<accounts[row].length; col++){
                wealthOfI += accounts[row][col];
            }
            if(wealthOfI > richestAmount)
                richestAmount = wealthOfI;
        }
        return richestAmount;
    }

}
