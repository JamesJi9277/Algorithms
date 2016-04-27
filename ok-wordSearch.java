时间Omn*4^k 有多少个单词就代表有多少个四种选择需要走
空间Omn recursion 最多递归k层，k是平均单词长度
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) {
        	return false;
        }
        if(word == null || word.length() == 0) {
        	return true;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] isUsed = new boolean[m][n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(doSearch(board, word, i, j, isUsed, 0)) {
        			return true;
        		}
        	}
        }
        return false;
    }
    private boolean doSearch(char[][] board, String word, int i, int j, boolean[][] isUsed, int index) {
    	if(index == word.length()) {
    		return true;
    	}
    	if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || isUsed[i][j] == true || board[i][j] != word.charAt(index)) {
    		return false;
    	}
    	isUsed[i][j] = true;
    	boolean res = doSearch(board, word, i + 1, j, isUsed, index + 1) ||
    	doSearch(board, word, i - 1, j, isUsed, index + 1) ||
    	doSearch(board, word, i, j + 1, isUsed, index + 1) ||
    	doSearch(board, word, i, j - 1, isUsed, index + 1);
    	isUsed[i][j] = false;
    	return res;
    }
}