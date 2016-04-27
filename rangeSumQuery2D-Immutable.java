Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.

brute force, time On2, space On 
因为题目中明确说了这个函数要call很多次，所以时间上肯定不可行，考虑跟前缀和数组一样的优化思想
public class NumMatrix {
    int[][] copy;
    public NumMatrix(int[][] matrix) {
        copy = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 > row2 || col1 > col2) {
            return 0;
        }
        int res = 0;
        for(int i = row1; i <= row2; i++) {
            for(int j = col1; j <= col2; j++) {
                res += copy[i][j];
            }
        }
        return res;
    }
}

时间Omn，空间Omn
public class NumMatrix {
	int[][] copy;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        	return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        copy = new int[m][n];
        copy[0][0] = matrix[0][0];
        for(int i = 1; i < m; i++) {
        	copy[i][0] = matrix[i][0] + copy[i - 1][0];
        }
        for(int j = 1; j < n; j++) {
        	copy[0][j] = matrix[0][j] + copy[0][j - 1];
        }
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		copy[i][j] = matrix[i][j] + copy[i - 1][j] + copy[i][j -  1] - copy[i - 1][j - 1];
        	}
        } 
    }
    //因为在变量中只会有col1或者row1存在着越界的可能，经过画图后知道需要考虑三种情况，分别是两者都为0或者二者其一为0
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	if(copy == null)
    		return 0;
    	if(row1 == 0 && col1 == 0)
    		return copy[row2][col2];
    	if(row1 == 0)
    		return copy[row2][col2] - copy[row2][col1 - 1];
    	if(col1 == 0)
    		return copy[row2][col2]-copy[row1 - 1][col2];
    	return copy[row2][col2] - copy[row1 - 1][col2] - copy[row2][col1 - 1] + copy[row1 - 1][col1 - 1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);

// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
