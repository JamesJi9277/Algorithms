Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O''s into 'X''s in that surrounded region.

Have you met this question in a real interview? Yes
Example
X X X X
X O O X
X X O X
X O X X
After capture all regions surrounded by 'X', the board should be:

X X X X
X X X X
X X X X
X O X X
public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] isUsed = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            doFill(board, isUsed, i, 0);
            doFill(board, isUsed, i, n - 1);
        }
        for(int j = 0; j < n; j++) {
            doFill(board, isUsed, 0, j);
            doFill(board, isUsed, m - 1, j);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void doFill(char[][] board, boolean[][] isUsed,int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] == 'X' || board[i][j] == '#' || isUsed[i][j] == true) {
            return;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        int code = i * n + j;
        queue.offer(code);
        isUsed[i][j] = true;
        board[i][j] = '#';
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            int row = temp / n;
            int col = temp % n;
            if(row > 0 && board[row - 1][col] == 'O') {
                queue.offer((row - 1) * n + col);
                board[row - 1][col] = '#';
                isUsed[row - 1][col] = true;
            }
            if(col > 0 && board[row][col - 1] == 'O') {
                queue.offer(row * n + col - 1);
                board[row][col - 1] = '#';
                isUsed[row][col - 1] = true;
            }
            if(row < m - 1 && board[row + 1][col] == 'O') {
                queue.offer((row + 1) * n + col);
                board[row + 1][col] = '#';
                isUsed[row + 1][col] = true;
            }
            if(col < n - 1 && board[row][col + 1] == 'O') {
                queue.offer(row * n + col + 1);
                board[row][col + 1] = '#';
                isUsed[row][col + 1] = true;
            }
        }
    }
}


public class Solution {
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if(board == null || board.length == 0 || board[0].length == 0) {
        	return;
        }
        //第一行和最后一行进行fill
        for(int i = 0; i < board[0].length; i++) {
        	fill(board, 0, i);
        	fill(board, board.length - 1, i);
        }

        //第一列和最后一列进行fill
        for(int i = 0; i < board.length; i++) {
        	fill(board, i, 0);
        	fill(board, i, board[0].length - 1);
        }
        //对于当前格子中，所有的O变成X，所有的#变成0
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(board[i][j] == 'O') {
        			board[i][j] = 'X';
        		}
        		else if(board[i][j] == '#') {
        			board[i][j] = 'O';
        		}
        	}
        }
    }
    private void fill(char[][] board, int i, int j) {
    	if(board[i][j] != 'O') {
    		return;
    	}
    	board[i][j] = '#';
    	//BFS
    	Queue<Integer> queue = new LinkedList<Integer>();
    	//先将矩阵的横纵坐标编码
    	int code = i * board[0].length + j;
    	queue.add(code);
    	while(!queue.isEmpty()) {
    		code = queue.poll();
    		int row = code / board[0].length;//recover
    		int col = code % board[0].length;
    		//当前元素上下左右是否为O
    		if(row >= 1 && board[row - 1][col] == 'O') {
    			queue.add((row - 1) * board[0].length + col);
    			board[row - 1][col] = '#';
    		}
    		if(row <= board.length - 2 && board[row + 1][col] == 'O') {
    			queue.add((row + 1) * board[0].length + col);
    			board[row + 1][col] = '#';
    		}
    		if(col >= 1 && board[row][col - 1] == 'O') {
    			queue.add(row * board[0].length + col - 1);
    			board[row][col - 1] = '#';
    		}
    		if(col <= board[0].length - 2 && board[row][col + 1] == 'O') {
    			queue.add(row * board[0].length + col + 1);
    			board[row][col + 1] = '#';
    		}
    	}
    }
}




