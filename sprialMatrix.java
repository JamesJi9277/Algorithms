//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while(true) {
            for(int i = left; i <= right; i++) {
                count++;
                res.add(matrix[top][i]);
                if(count == m * n) {
                    return res;
                }
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                count++;
                res.add(matrix[i][right]);
                if(count == m * n) {
                    return res;
                }
            }
            right--;
            for(int i = right; i >= left; i--) {
                count++;
                res.add(matrix[bottom][i]);
                if(count == m * n) {
                    return res;
                }
            }
            bottom--;
            for(int i = bottom; i >= top; i--) {
                count++;
                res.add(matrix[i][left]);
                if(count == m * n) {
                    return res;
                }
            }
            left++;
        }
    }
}


public class Solution{
	public List<Integer> spiralOrder(int[][] matrix){
		
		List<Integer> res = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0|| matrix[0].length == 0)
			return res;
		//要先判断之后，在进行定义，不然就会产生越界
		int row = matrix.length;
		int col = matrix[0].length;
		int min = Math.min(row,col);
		int levelNum = min/2;
		for(int level = 0; level< levelNum;level++)
		{
			for(int i =level; i< col -1 - level;i++)
				res.add(matrix[level][i]);

			for(int i = level; i< row -1-level;i++)
				res.add(matrix[i][col-1-level]);

			for(int i = col-level-1; i>level;i--)
				res.add(matrix[row-level-1][i]);

			for(int i = row-1-level;i>level;i--)
				res.add(matrix[i][level]);
		}
		if(min%2 == 1)
		{
			if(row > col)
			{
				for(int i = levelNum; i< row -levelNum;i++)
					res.add(matrix[i][levelNum]);
			}
			else
			{
				for(int i = levelNum; i < col-levelNum;i++)
					res.add(matrix[levelNum][i]);
			}
		}
		return res;
	}
}




package leetcode;
import java.util.ArrayList;
import java.util.List;
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		int m = matrix.length;//the number of rows in matrix
		//check step
		if(m == 0)
			return result;
		int n = matrix[0].length;
		if(n == 0)
			return result;
		int[][] status = new int[m][n];
		goRight(0, 0, matrix, status, result);
		return result;
	}
	public void goRight(int i, int j, int[][] matrix, int[][] status, List<Integer> result)
	{
		int m = matrix.length;
		int n = matrix[0].length;
		if(i < 0 || i >= m || j < 0 || j>= n)
			return;
		if(status[i][j] == 1)
			return;
		do
		{
			result.add(matrix[i][j]);
			status[i][j] = 1;
			j++;
		}
		while((j < n - 1 && status[i][j + 1] != 1) || j == n - 1);
		goDown(++i, --j, matrix, status, result);
	}
	public void goDown(int i, int j, int[][] matrix, int[][] status, List<Integer> result)
	{
		int m = matrix.length;
		int n = matrix[0].length;
		if(i < 0 || i >= m || j < 0 || j>= n)
			return;
		if(status[i][j] == 1)
			return;
		do
		{
			result.add(matrix[i][j]);
			status[i][j] = 1;
			i++;
		}
		while((i < m - 1 && status[i + 1][j] != 1) || i == m - 1);
		goLeft(--i, --j, matrix, status, result);
	}
	public void goLeft(int i, int j, int[][] matrix, int[][] status, List<Integer> result)
	{
		int m = matrix.length;
		int n = matrix[0].length;
		if(i < 0 || i >= m || j < 0 || j>= n)
			return;
		if(status[i][j] == 1)
			return;
		do
		{
			result.add(matrix[i][j]);
			status[i][j] = 1;
			j--;
		}
		while((j > 0 && status[i][j - 1] != 1) || j == 0);
		goUp(--i, ++j, matrix, status, result);
	}
	public void goUp(int i, int j, int[][] matrix, int[][] status, List<Integer> result)
	{
		int m = matrix.length;
		int n = matrix[0].length;
		if(i < 0 || i >= m || j < 0 || j>= n)
			return;
		if(status[i][j] == 1)
			return;
		do
		{
			result.add(matrix[i][j]);
			status[i][j] = 1;
			i--;
		}
		while((i >= 0 && status[i][j] != 1));
		goRight(++i, ++j, matrix, status, result);
	}
}




