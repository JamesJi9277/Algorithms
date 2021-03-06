// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

// Have you met this question in a real interview? Yes
// Example
// Given [3, 8, 4], return 8.

// Challenge
// O(n) time and O(1) memory.
public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
            return (long)0;
        }
        long[] f = new long[A.length + 1];
        f[0] = (long)0;
        f[1] = (long)A[0];
        for(int i = 2; i <= A.length; i++) {
            f[i] = Math.max(f[i-1], f[i - 2] + A[i - 1]);
        }
        return (long)f[A.length];
    }
}
