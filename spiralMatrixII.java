//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
//跟sprial matrix一样的做法，注意矩阵下标的关系以及最后的条件判断
public class Solution {
    public int[][] generateMatrix(int n) {
    	int[][] res = new int[n][n]();
    	if(n < 1 )
    		return res;
    	int num = 1;
    	int levelNum = n/2;
    	for(int level = 0;level < levelNum;level++)
    	{
    		for(int i = level; i<n-level-1;i++)
    			res[level][i] = num++;
    		for(int i = level; i < n-1-level;i++)
    			res[i][n-level-1] = num++;
    		for(int i = n-level-1;i>level;i--)
    			res[n-level-1][i] = num++；
    		for(int i = n-level-1; i >level;i--)
    			res[i][n-level-1] = num ++；
    	}
    	if(n%2 == 1)
    		res[levelNum][levelNum] = num;
    	return res;
    }
}

public class Solution {
    public int[][] generateMatrix(int n) {
        int count = 1;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int[][] res = new int[n][n];
        while(count <= n * n) {
            for(int i = left; i <= right; i++) {
                res[top][i] = count;
                count++;
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                res[i][right] = count;
                count++;
            }
            right--;
            for(int i = right; i >= left; i--) {
                res[bottom][i] = count;
                count++;
            }
            bottom--;
            for(int i = bottom; i >= top; i--) {
                res[i][left] = count;
                count++;
            }
            left++;
        }
        return res;
    }
}