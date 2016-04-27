// Given a boolean 2D matrix, find the number of islands.
//
// Have you met this question in a real interview? Yes
// Example
// Given graph:
//
// [
//   [1, 1, 0, 0, 0],
//   [0, 1, 0, 0, 1],
//   [0, 0, 0, 1, 1],
//   [0, 0, 0, 0, 0],
//   [0, 0, 0, 0, 1]
// ]
// return 3.
//
// Note
// 0 is represented as the sea,
// 1 is represented as the island.
// If two 1 is adjacent, we consider them in the same island.
// We only consider up/down/left/right adjacent.

//DFS,空间On2和O1

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isUsed = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    doFill(grid, isUsed, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void doFill(char[][] grid, boolean[][] isUsed, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || isUsed[i][j] == true || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        isUsed[i][j] = true;
        doFill(grid, isUsed, i + 1, j);
        doFill(grid, isUsed, i - 1, j);
        doFill(grid, isUsed, i, j + 1);
        doFill(grid, isUsed, i, j - 1);
    }
}

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    doFill(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void doFill(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '#' || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '#';
        doFill(grid, i + 1, j);
        doFill(grid, i - 1, j);
        doFill(grid, i, j + 1);
        doFill(grid, i, j - 1);
    }
}
//BFS
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if( grid == null || grid.length == 0 || grid[0].length == 0 ){
        	return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        boolean[][] isVisited = new boolean[row][col];
        for(int i = 0; i < row; i++){
        	for(int j = 0; j < col; j++){
        		if( grid[i][j] == true ){
        			Queue<Integer> queue = new LinkedList<Integer>();
        			queue.offer(i);
        			queue.offer(j);
        			while( !queue.isEmpty() ){
        				int size = queue.size()/2;
        				for(int k = 0; k < size; k++){
        					int xLoc = queue.poll();
        					int yLoc = queue.poll();
        					grid[xLoc][yLoc] = false;
        					if(isLocValid(xLoc - 1, yLoc, grid, isVisited)){
        						queue.offer(xLoc - 1);
        						queue.offer(yLoc);
        						isVisited[xLoc-1][yLoc] = true;
        					}
        					if(isLocValid(xLoc + 1, yLoc, grid, isVisited)){
        						queue.offer(xLoc + 1);
        						queue.offer(yLoc);
        						isVisited[xLoc+1][yLoc] = true;
        					}
        					if(isLocValid(xLoc, yLoc - 1, grid, isVisited)){
        						queue.offer(xLoc);
        						queue.offer(yLoc - 1);
        						isVisited[xLoc][yLoc-1] = true;
        					}
        					if(isLocValid(xLoc, yLoc + 1, grid, isVisited)){
        						queue.offer(xLoc);
        						queue.offer(yLoc + 1);
        						isVisited[xLoc][yLoc + 1] = true;
        					}
        				}
        			}
        			count++;
        		}

        	}
        }
        return count;
    }

    private boolean isLocValid(int x, int y, boolean[][] grid, boolean[][] isVisited){
    	if( x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == false || isVisited[x][y] == true ){
    		return false;
    	}
    	return true;
    }
}



//flood fill， 类似于抵消法，即当找到了一个1之后，就将与这个1相连的所有1全部置为0，并且将结果加1.
//这样子即可以保证一次性探索完了一个点的所有相关节点，又可以保证下一次探索的时候不会重复探索
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
          return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
          for(int j = 0; j < grid[0].length; j++) {
            if(grid[i][j] == true) {
              floodFill(grid, i, j);
              count++;
            }
          }
        }
        return count;
    }
    private void floodFill(boolean[][] grid, int x, int y) {
      if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
        return;
      }
      if(grid[x][y] == false) {
        return;
      }
      grid[x][y] = false;
      floodFill(grid, x, y - 1);
      floodFill(grid, x, y + 1);
      floodFill(grid, x - 1, y);
      floodFill(grid, x + 1, y);
    }
}
