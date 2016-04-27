Given an integer matrix, find a submatrix where the sum of numbers is zero. Your code should return the coordinate of the left-up and right-down number.

Have you met this question in a real interview? Yes
Example
Given matrix

[
  [1 ,5 ,7],
  [3 ,7 ,-8],
  [4 ,-8 ,9],
]
return [(1,1), (2,2)]

Challenge
O(n3) time.


public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int[][] res = {{-1, -1}, {-1, -1}};
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int x = i; x < m; x++) {
                    for(int y = j; y < n; y++) {
                        int sum = getSum(matrix, i, j, x, y);
                        if(sum == 0) {
                            res[0][0] = i;
                            res[0][1] = j;
                            res[1][0] = x;
                            res[1][1] = y;
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }
    private int getSum(int[][] matrix, int x1, int y1, int x2, int y2) {
        int sum = 0;
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}