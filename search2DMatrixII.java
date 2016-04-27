// Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

// This matrix has the following properties:

//     * Integers in each row are sorted from left to right.

//     * Integers in each column are sorted from up to bottom.

//     * No duplicate integers in each row or column.

// Have you met this question in a real interview? Yes
// Example
// Consider the following matrix:

// [

//     [1, 3, 5, 7],

//     [2, 4, 7, 8],

//     [3, 5, 9, 10]

// ]

// Given target = 3, return 2.

// Challenge
// O(m+n) time and O(1) extra space
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return 0;
        }
        int count = 0;
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		if(matrix[i][j] == target) {
        			count++;
        		}
        	}
        }
        return count;
    }
}

//quadrate search
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return 0;
        }
        int i = matrix.length - 1;
        int j =0;
        int count = 0;
        while((i >= 0 && i <= matrix.length - 1) && (j >= 0 && j <= matrix[0].length - 1)) {
        	if(matrix[i][j] == target) {
        		count++;
        		i--;
        		j++;
        	}
        	else if(matrix[i][j] > target) {
        		i--;
        	}
        	else if(matrix[i][j] < target) {
        		j++;
        	}
        }
        return count;
    }
}



