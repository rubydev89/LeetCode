package com.leetcode.recursion.subsetNCombination;

import java.util.Arrays;

/*
 * 
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * 		The word can be constructed from letters of sequentially adjacent cells, 
 * 		where adjacent cells are horizontally or vertically neighboring. 
 * 		The same letter cell may not be used more than once.
 * 
*/
public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
		String word = "AAB";
		
		System.out.println(exist(board, word, 0, 0, 0));
	}
	
	private static boolean exist(char[][] board, String word, int row, int col, int wordIndex) {
		//System.out.println("row : "+row +" | col : "+col);
		//System.out.println("wordIndex : "+wordIndex);
		if(row>board.length-1 || wordIndex>word.length()-1) {
			//System.out.println("wordIndex : "+wordIndex);
			
			if(wordIndex > word.length()-1) {
				return true;
			}else {
				//System.out.println("False");
				return false;
			}
		}else {
			char letterToFind = word.charAt(wordIndex);
			char boardChar = board[row][col];
			
			if(letterToFind == boardChar) {
				boolean ans = false;
				board[row][col] = '-';
				if(row > 0) {
					ans = ans || exist(board, word, row-1, col, wordIndex+1);
				}if(row < board.length -1) {
					board[row][col] = '-';
					ans = ans || exist(board, word, row+1, col, wordIndex+1);
				}if(col > 0) {
					board[row][col] = '-';
					ans = ans || exist(board, word, row, col-1, wordIndex+1);
				}if(col < board[row].length-1) {
					board[row][col] = '-';
					ans = ans || exist(board, word, row, col+1, wordIndex+1);
				}else {
					board[row][col] = '-';
					ans = ans || exist(board, word, row+1, col, wordIndex+1);
				}
				board[row][col] = boardChar;
				return ans;
			}else {
				if(col >= board[row].length-1) {
					return exist(board, word, row+1, 0, 0);
				}else {
					return exist(board, word, row, col+1, 0);
				}
			}
		}
		
		
	}

}
