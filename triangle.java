// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

// Have you met this question in a real interview? Yes
// Example
// For example, given the following triangle

// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

// Note
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        if(triangle == null || triangle.size() == 0) {
        	return 0;
        }
        if(triangle.size() == 1) {
        	return triangle.get(0).get(0);
        }
        int[] sum = new int[triangle.size()];
        //接下来这三个步骤一定要注意顺序，顺序不能够乱
        sum[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++) {
        	sum[i] = sum[i - 1] + triangle.get(i).get(i);
        	for(int j = i - 1; j >= 1;j--) {
        		sum[j] = (sum[j]<sum[j-1]?sum[j]:sum[j-1] )+ triangle.get(i).get(j);
        	}
        	sum[0] = sum[0] + triangle.get(i).get(0);
        }
        int min = sum[0];
        for(int i = 1; i < sum.length; i++) {
        	min = Math.min(min, sum[i]);
        }
        return min;
    }
}


public class Solution{
    public int minimumTotal(List<List<Integer>> triangle){
        if(triangle.size() == 0)
            return 0;
        int[] res = new int[triangle.size()];
        for(int i =0; i < triangle.size(); i++)
            res[i] = triangle.get(triangle.size() -1).get(i);
        for(int i = triangle.size()-2;i>=0;i--){
            for(int j =0;j<=i;j++){
                res[j] = Math.min(res[j], res[j+1]) + triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}

//third write, bug free

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        if(triangle == null || triangle.size() == 0) {
            return 0;
        }
        int[] res = new int[triangle.size()];
        res[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++) {
            res[i] = res[i - 1] + triangle.get(i).get(i);
            for(int j = i - 1; j >= 1; j--) {
                res[j] = Math.min(res[j], res[j - 1]) + triangle.get(i).get(j);
            }
            res[0] = res[0] + triangle.get(i).get(0);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < res.length; i++) {
            min = Math.min(min, res[i]);
        }
        return min;
    }
}


//重新开始看着视频并且按照视频中的五种方法自己慢慢的写出来的
//1. using DFS, time complexity O(2^n), space complexity O(n)
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        if(triangle == null || triangle.size() == 0) {
            return -1;
        }
        ArrayList<Integer> minPath = new ArrayList<Integer>();
        minPath.add(Integer.MAX_VALUE);
        doDFS(minPath, triangle, 0, 0, 0);
        return minPath.get(0);
    }
    private void doDFS(ArrayList<Integer> minPath, ArrayList<ArrayList<Integer>> triangle, int i, int j, int sum) {
        if(i == triangle.size()) {
            if(sum < minPath.get(0)) {
                minPath.add(0, sum);
            }
            return;
        }
        doDFS(minPath, triangle, i+1, j, sum + triangle.get(i).get(j));
        doDFS(minPath, triangle, i+1, j+1, sum + triangle.get(i).get(j));
    }
}
//2. Up- bottom update, worse case O(2^n)
public class Solution {
    private int n;
    private int[][] minSum;
    private ArrayList<ArrayList<Integer>> triangle;
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return -1;
        }
        this.n = triangle.size();
        this.triangle = triangle;
        this.minSum = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }
        doSearch(0, 0, 0);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            res = Math.min(res, minSum[n - 1][i]);
        }
        return res;
    }
    private void doSearch(int x, int y, int sum) {
        if(x >= n) {
            return;
        }
        if(sum + triangle.get(x).get(y) >= minSum[x][y]) {
            return;
        }
        minSum[x][y] = sum + triangle.get(x).get(y);
        doSearch(x + 1, y, minSum[x][y]);
        doSearch(x + 1, y + 1, minSum[x][y]);
    }
}

//3. Divide & Conquer + memorization search
public class Solution {
    private int n;
    private int[][] minSum;
    private ArrayList<ArrayList<Integer>> triangle;
    private int search(int x, int y) {
        if(x >= n) {
            return 0;
        }
        if(minSum[x][y] != Integer.MAX_VALUE) {
            return minSum[x][y];
        }
        minSum[x][y] = Math.min(search(x + 1, y), search( x + 1, y + 1)) + triangle.get(x).get(y);
        return minSum[x][y];
    }
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return -1;
        }
        this.n = triangle.size();
        this.triangle = triangle;
        this.minSum = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                minSum[i][j] = Integer.MAX_VALUE;
            }
        }
        return search(0, 0);
    }
}

//4.dynamic programming, time complexity O(n^2), space complexity O(n^2)
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) {
            return -1;
        }
        int rowNum = triangle.size();
        int[][] dp = new int[rowNum][rowNum];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < rowNum; i++) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                if( j >= triangle.get(i - 1).size()) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }
                else if(j - 1 < 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < rowNum; i++) {
            min = Math.min(dp[rowNum - 1][i], min);
        }
        return min;
    }
}


