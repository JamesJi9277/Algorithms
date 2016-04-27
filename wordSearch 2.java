// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// For example,
// Given board =

// [
//   ["ABCE"],
//   ["SFCS"],
//   ["ADEE"]
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.

public class Solution{
    public boolean exist(char[][] board, String word){
           if(word==null || word.length()==0)  
        return true;  
    if(board==null || board.length==0 || board[0].length==0)  
        return false;  
        boolean[][] mark = new boolean[board.length][board[0].length];
        for(int i =0; i< board.length; i++)
        {
            for(int j =0; j < board[0].length; j++)
            {
                if(wordSearch(i,j,board,mark,word,0))
                    return true;
            }
        }
        return false;
    }
    private boolean wordSearch( int i, int j, char[][] board, boolean[][] mark, String word, int index)
    {
        if(index == word.length())
            return true;
        if(i<0|| j< 0|| i >= board.length|| j >= board[0].length||mark[i][j] || board[i][j]!=word.charAt(index))  
        return false;  
        
        mark[i][j] = true;
        boolean res = wordSearch(i+1,j,board,mark,word,index+1)||
        wordSearch(i-1,j,board,mark,word,index+1)||
        wordSearch(i,j+1,board,mark, word, index+1)||
        wordSearch(i, j-1,board,mark,word,index+1);
        mark[i][j] = false;
        return res;
    }
}


//second write, ac, but not bug free,注意private函数里面的退出条件，不能够越界
public class Solution{
	public boolean exist(char[][] board, String word){
		if(board == null || board.length == 0 || board[0].length == 0)
			return false;
		if(word == null || word.length() == 0)
			return true;
		boolean[][] isUsed = new boolean[board.length][board[0].length];
		for(int i =0;i<board.length;i++){
			for(int j =0;j<board[0].length;j++){
				isUsed[i][j] = false;
			}
		}
		for(int i =0;i<board.length;i++){
			for(int j =0;j<board[0].length;j++){
				if(wordSearch(board,word,isUsed,0,i,j))
					return true;
			}
		}
		return false;
	}
	private boolean wordSearch(char[][] board, String word, boolean[][] isUsed, int index, int i, int j){
		if(index == word.length())
			return true;
		if(i<0|| j< 0|| i >= board.length|| j >= board[0].length||isUsed[i][j] == true|| board[i][j]!=word.charAt(index))  
			return false; 
		isUsed[i][j] = true;
		boolean res = wordSearch(board,word,isUsed,index+1,i-1,j)||wordSearch(board,word,isUsed,index+1,i+1,j)||wordSearch(board,word,isUsed,index+1,i,j-1)||wordSearch(board,word,isUsed,index+1,i,j+1);
		isUsed[i][j] = false;
		return res;
	}
}


































