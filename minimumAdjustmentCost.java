// Given an integer array, adjust each integers so that the difference of every adjacent integers are not greater than a given number target.

// If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]|

// Have you met this question in a real interview? Yes
// Example
// Given [1,4,2,3] and target = 1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal.

// Return 2.

// Note
// You can assume each number in the array is a positive integer and not greater than 100.
public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        //f[i][v]表示前i个数，第i个数调整为v，满足相邻两数 <= target，所需要的最小代价
        if(A == null || A.size() == 0) {
        	return 0;
        }
        int[][] f = new int[A.size() + 1][101];
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < 101; j++) {
        	f[0][j] = 0;
        }
        for(int i = 1; i <= A.size(); i++) {
        	for(int j = 1; j <= 100; j++) {
        		f[i][j] = Integer.MAX_VALUE;
        		for(int k = 1; k <= 100; k++) {
        			if(Math.abs(j - k) > target) {
        				continue;
        			}
        			//Math.abs(j - A.get(i - 1))表示第i个数更改为j所需要的cost
        			f[i][j] = Math.min(f[i][j], f[i - 1][k] + Math.abs(j - A.get(i - 1)));
        		}
        	}
        }
        for(int j = 1; j <= 100; j++) {
        	res = Math.min(res, f[A.size()][j]);
        }
        return res;
    }
}
