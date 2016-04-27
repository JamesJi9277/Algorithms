// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

// For example, given the following matrix:

// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
// Return 4.
public class Solution {
	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] f = new int[m][n];
		int max = 0;
		for(int i = 0; i < m; i++) {
			if(matrix[i][0] == '1') {
				f[i][0] = 1;
			}
		}
		for(int j = 0; j < n; j++) {
			if(matrix[0][j] == '1') {
				f[0][j] = 1;
			}
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(matrix[i][j] == '1') {
					f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
				}
				max = Math.max(max, f[i][j]);
			}
		}
		return max * max;
	}
}
public class Solution {
	public int maximalSquare(char[][] a) {
		if(a == null || a.length == 0 || a[0].length == 0) {
			return 0;
		}
		//f[x][y]表示以坐标(x, y)为右下角元素的全1正方形矩阵的最大长度（宽度）
		int[][] f = new int[a.length + 1][a[0].length + 1];
		int max = 0;
		for(int i = 1; i <= a.length; i++) {
			for(int j = 1; j <= a[0].length; j++) {
				if(a[i - 1][j - 1] == '1') {
					f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
					max = Math.max(f[i][j], max);
				}
			}
		}
		return max* max;
	}
}



public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int x = matrix.length, y = matrix[0].length;
        int[][] m = new int[x][y];
        int max = 0;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(i == 0 || j == 0) m[i][j] = matrix[i][j] - '0';
                else if(matrix[i][j] == '0'){
                    m[i][j] = 0;
                }else{
                    int min = Math.min(m[i - 1][j - 1], Math.min(m[i - 1][j], m[i][j - 1]));
                    m[i][j] = (int)Math.pow(((int)Math.sqrt(min) + 1), 2); 
                }
                if(m[i][j] > max) max = m[i][j];
            }
        }
        return max;
    }
}	