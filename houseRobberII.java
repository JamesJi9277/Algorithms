// Note: This is an extension of House Robber.

// After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        if(nums.length == 1) {
        	return nums[0];
        }
        if(nums.length == 2) {
        	return Math.max(nums[0], nums[1]);
        }
        int length = nums.length;
        //include first, not include last
        int[] f = new int[length + 1];
        f[0] = 0;
        f[1] = nums[0];
        for(int i = 2; i < length; i++) {
        	f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
        }
        //include last, not include first
        int[] f1 = new int[length + 1];
        f1[0] = 0;
        f1[1] = nums[1];
        for(int i = 2; i < n; i++) {
        	f1[i] = Math.max(f1[i - 1], f1[i - 2] + nums[i]);
        }
        return Math.max(f[length - 1], f1[length - 1]);
    }
}


public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        if(nums.length == 1) {
        	return nums[0];
        }
        if(nums.length == 2) {
        	return Math.max(nums[0], nums[1]);
        }
        int length = nums.length;
        //include first, not include last
        int[] f = new int[length ];
        f[0] = 0;
        f[1] = nums[0];
        for(int i = 2; i < length; i++) {
        	f[i] = Math.max(f[i - 1], f[i - 2] + nums[i - 1]);
        }
        //include last, not include first
        int[] f1 = new int[length ];
        f1[0] = 0;
        f1[1] = nums[1];
        for(int i = 2; i < length; i++) {
        	f1[i] = Math.max(f1[i - 1], f1[i - 2] + nums[i]);
        }
        return Math.max(f[length - 1 ], f1[length - 1]);
    }
}