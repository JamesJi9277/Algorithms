// Given an array of integers, find a contiguous subarray which has the largest sum.

// Have you met this question in a real interview? Yes
// Example
// Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

// Note
// The subarray should contain at least one number.

// Challenge
// Can you do it in time complexity O(n)?
//Greedy, time O(n)
public class Solution {
	public int maxSubArray(ArrayList<Integer> nums) {
		if(nums == null || nums.size() == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i < nums.size(); i++) {
			sum += nums.get(i);
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}
		return max;
	}
}
//time complexity O(n2), space O(n2), TLE
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0) {
            return 0;
        }
        int size = nums.size();
        int[][] res = new int[size][size];
        res[0][0] = nums.get(0);
        for(int i = 1; i < size; i++) {
            res[i][i] = nums.get(i);
            for(int j = i; j < size;j++) {
                res[i][j] = res[i][j - 1] + nums.get(j);
            }
        }
        for(int i = 1; i < size; i++) {
            res[0][i] = res[0][i - 1] + nums.get(i);
        }
        return findMax(res);
    }
    private int findMax(int[][] res) {
        int length = res.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                max = Math.max(res[i][j], max);
            }
        }
        return max;
    }
}
    
//DP, time complexity O(n), space O(n)
public class Solution {
	public int maxSubArray(ArrayList<Integer> nums) {
		if(nums == null || nums.size() == 0) {
			return 0;
		}
		int size = nums.size();
		int[] global = new int[size];
		int[] local = new int[size];
		global[0] = nums.get(0);
		local[0] = nums.get(0);
		//记住DP这里一定要从1开始，因为初始状态的DP[0]已经定义过了
		for(int i = 1; i < size; i++) {
			local[i] = Math.max(nums.get(i), local[i - 1] + nums.get(i));
			global[i] = Math.max(local[i], global[i - 1]);
		}
		return global[size - 1];
	}
}