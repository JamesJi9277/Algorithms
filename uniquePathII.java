// Easy Unique Paths II

// 27% Accepted
// Follow up for "Unique Paths":

// Now consider if some obstacles are added to the grids. How many unique paths would there be?

// An obstacle and empty space is marked as 1 and 0 respectively in the grid.

// Have you met this question in a real interview? Yes
// Example
// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.

// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.

// Note
// m and n will be at most 100.
public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
        	return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        if(obstacleGrid[0][0] == 0) {
        	res[0][0] = 1;
        }
        else {
        	res[0][0] = 0;
        }
        for(int i = 1; i < m; i++) {
        	if(obstacleGrid[i][0] == 1 || res[i - 1][0] == 0) {
        		res[i][0] = 0;
        	}
        	else {
        		res[i][0] = 1;
        	}
        }
        for(int i = 1; i < n; i++) {
        	if(obstacleGrid[0][i] == 1 || res[0][i - 1] == 0) {
        		res[0][i] = 0;
        	}
        	else {
        		res[0][i] = 1;
        	}
        }
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		if(obstacleGrid[i][j] == 1) {
        			res[i][j] = 0;
        		}
        		else {
        			res[i][j] = res[i - 1][j] + res[i][j - 1];
        		}
        	}
        }
        return res[m - 1][n - 1];
    }
}


滚动数组，时间Omn，空间On
public class Solution {
    public int uniquePathsWithObstacles(int[][] nums) {
        if(nums == null || nums.length == 0 || nums[0].length == 0) {
            return 0;
        }
        int m = nums.length;
        int n = nums[0].length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            if(nums[0][i] == 1) {
                break;
            }
            else {
                res[i] = 1;
            }
        }
        
        for(int i = 1; i < m; i++) {
            if(nums[i][0] == 1) {
                res[0] = 0;
            }
            for(int j = 1; j < n; j++) {
                if(nums[i][j] == 1) {
                    res[j] = 0;
                }
                else {
                    res[j] += res[j - 1];
                }
            }
        }
        return res[n - 1];
    }
}