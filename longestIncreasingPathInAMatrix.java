Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] copy = new int[m][n];
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                count = Math.max(count, helper(matrix, copy , i, j, Integer.MIN_VALUE));
            }
        }
        return count;
    }
    private int helper(int[][] matrix, int[][] copy, int i, int j, int min) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= min) {
            return 0;
        }
        if(copy[i][j] > 0) {
            return copy[i][j];
        }
        min = matrix[i][j];
        int res = 0;
        int a = helper(matrix, copy, i + 1, j, min) + 1;
        int b = helper(matrix, copy, i - 1, j, min) + 1;
        int c = helper(matrix, copy, i, j + 1, min) + 1;
        int d = helper(matrix, copy, i, j - 1, min) + 1;
        res = Math.max(a, Math.max(b, Math.max(c, d)));
        copy[i][j] = res;
        return res;
    }
}