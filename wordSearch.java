// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Have you met this question in a real interview? Yes
// Example
// Given board =

// [
//   "ABCE",
//   "SFCS",
//   "ADEE"
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.

time 复杂度是m*n*4^(k-1). 也就是m*n*4^k.
m X n is board size, k is word size.

recuision最深是k层，recursive部分空间复杂度应该是O(k) + O(m*n)
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if(board == null || board.length == 0 || board[0].length == 0) {
        	return false;
        }
        if(word == null || word.length() == 0) {
        	return false;
        }
        boolean[][] isUsed = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(wordSearch(board, word, isUsed, 0, i, j)) {
        			return true;
        		}
        	}
        }
        return false;
    }
    private boolean wordSearch(char[][] board, String word, boolean[][] isUsed, int index, int i, int j) {
    	if(index == word.length()) {
    		return true;
    	}
    	if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || isUsed[i][j] == true
    		|| board[i][j] != word.charAt(index)) {
    		return false;
    	}
    	isUsed[i][j] = true;
    	boolean res = wordSearch(board,word,isUsed,index+1,i-1,j)||wordSearch(board,word,isUsed,index+1,i+1,j)||wordSearch(board,word,isUsed,index+1,i,j-1)||wordSearch(board,word,isUsed,index+1,i,j+1);
    	isUsed[i][j] = false;
    	return res;
    }
}
