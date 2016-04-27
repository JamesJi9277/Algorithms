// Write an efficient algorithm that searches for a value in an m x n matrix.

// This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// Have you met this question in a real interview? Yes
// Example
// Consider the following matrix:

// [
//     [1, 3, 5, 7],
//     [10, 11, 16, 20],
//     [23, 30, 34, 50]
// ]
// Given target = 3, return true.

// Challenge
// O(log(n) + log(m)) time
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        // find the row index, the last number <= target 
        int start = 0, end = row - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }
        
        // find the column index, the number equal to target
        start = 0;
        end = column - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        } else if (matrix[row][end] == target) {
            return true;
        }
        return false;
    }
}
//search once
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length - 1;
        int n = 0;
        while(m >= 0 && n < matrix[0].length) {
            if(matrix[m][n] == target) {
                return true;
            }
            else if(matrix[m][n] > target) {
                m--;
            }
            else if(matrix[m][n] < target) {
                n++;
            }
        }
        return false;
    }
}
//search once
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            //code = col * i + j
            int i = mid / col;
            int j = mid % col;
            if(matrix[i][j] == target) {
                return true;
            }
            else if(matrix[i][j] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if(matrix[start / col][start % col] == target) {
            return true;
        }
        else if(matrix[end / col][end % col] == target) {
            return true;
        }
        else {
            return false;
        }
    }
}