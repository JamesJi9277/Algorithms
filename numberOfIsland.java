// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
//
// 11110
// 11010
// 11000
// 00000
// Answer: 1
//
// Example 2:
//
// 11000
// 11000
// 00100
// 00011
// Answer: 3
DFS 空间On2和O1两种
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
                    count++;
                    Queue<Integer> queue = new LinkedList<Integer>();
                    queue.offer(i);
                    queue.offer(j);
                    while(!queue.isEmpty()) {
                        int size = queue.size();
                        for(int k = 0; k < size / 2; k++) {
                            int xLoc = queue.poll();
                            int yLoc = queue.poll();
                            grid[xLoc][yLoc] = '#';
                            if(isValid(grid, xLoc - 1, yLoc)) {
                                queue.offer(xLoc - 1);
                                queue.offer(yLoc);
                                grid[xLoc][yLoc] = '#';
                            }
                            if(isValid(grid, xLoc + 1, yLoc)) {
                                queue.offer(xLoc + 1);
                                queue.offer(yLoc);
                                grid[xLoc][yLoc] = '#';
                            }
                            if(isValid(grid, xLoc, yLoc - 1)) {
                                queue.offer(xLoc);
                                queue.offer(yLoc - 1);
                                grid[xLoc][yLoc] = '#';
                            }
                            if(isValid(grid, xLoc, yLoc + 1)) {
                                queue.offer(xLoc);
                                queue.offer(yLoc + 1);
                                grid[xLoc][yLoc] = '#';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    private boolean isValid(char[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || grid[x][y] == '#') {
            return false;
        }
        return true;
    }
}