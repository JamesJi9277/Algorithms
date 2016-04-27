// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

// Have you met this question in a real interview? Yes
// Example
// Given an example n=3 , 1+1+1=2+1=1+2=3

// return 3
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if(n < 1) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        
        for(int i = 3; i < n+1; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }
}

