// Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k).
// Originally, the 2D matrix is all 0 which means there is only sea in the matrix.
// The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid matrix[A[i].x][A[i].y] from sea to island.
// Return how many island are there in the matrix after each operator.
//
// Have you met this question in a real interview? Yes
// Example
// Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
//
// return [1,1,2,2].
//
// Note
// 0 is represented as the sea, 1 is represented as the island.
// If two 1 is adjacent, we consider them in the same island.
// We only consider up/down/left/right adjacent.
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 public class Solution {
     /**
      * @param n an integer
      * @param m an integer
      * @param operators an array of point
      * @return an integer array
      */
     public List<Integer> numIslands2(int n, int m, Point[] operators) {
         // Write your code here
         List<Integer> res = new ArrayList<Integer>();

         if(operators == null) {
           return res;
         }
         int[][] grid = new int[n][m];
         boolean[][] isUsed = new boolean[n][m];
         for(int i = 0; i < operators.length; i++) {
           grid[operators[i].x][operators[i].y] = 1;
           isUsed[operators[i].x][operators[i].y] = true;
           int numberOfIsland = helper(grid, isUsed);
           res.add(numberOfIsland);
         }
         return res;
     }
     private int helper(int[][] grid, boolean[][] isUsed) {
       int count = 0;
       for(int i = 0; i < grid.length; i++) {
         for(int j = 0; j < grid[0].length; j++) {
           if(grid[i][j] == 1 && isUsed[i][j] == false) {
             count++;
             floodFill(grid, isUsed, i, j);
           }
         }
       }
       return count;
     }
     private void floodFill(int[][] grid, boolean[][] isUsed, int i, int j) {
       if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1&& isUsed[i][j] == false) {
         isUsed[i][j] = true;
         floodFill(grid, isUsed, i - 1, j);
         floodFill(grid, isUsed, i, j - 1);
         floodFill(grid, isUsed, i + 1, j);
         floodFill(grid, isUsed, i, j + 1);
       }
     }
 }
