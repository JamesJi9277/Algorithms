// Medium Set Matrix Zeroes Show result 

// 33% Accepted
// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

// Have you met this question in a real interview? Yes
// Example
// Given a matrix

// [
//   [1,2],
//   [0,3]
// ],
// return [ [0,2], [0,0] ]

// Challenge
// Did you use extra space? A straight forward solution using O(mn) space is probably a bad idea. 
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                res[i][j] = matrix[i][j];
            }
        }
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                if(res[i][j] == 0) {
                    setZero(matrix, i, j);
                }
            }
        }
        return;
    }
    private void setZero(int[][] matrix, int row, int col) {
        for(int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
        return;
    }
}

// A simple improvement uses O(m + n) space, but still not the best solution. 

//Could you devise a constant space solution?
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean rowHasZero = false;
        boolean colHasZero = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }
        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) {
                rowHasZero = true;
                break;
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowHasZero) {//看清楚ij对应的行列并且看清楚boolean所对应的值
            for(int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if(colHasZero) {
            for(int j = 0; j < m; j++) {
                matrix[j][0] = 0;
            }
        }
        return;
    }
}