public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        int length = nums.length;
        int[] local = new int[length];
        int[] gloabl = new int[length];
        local[0] = nums[0];
        global[0] = nums[0];
        for(int i = 1; i < length; i++) {
        	local[i] = Math.max(local[i - 1] + nums[i], nums[i]);
        	global[i] = Math.max(global[i - 1], local[i]);
        }
        return global[length - 1];
    }
}

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	max = Math.max(max, sum);
        	sum = Math.max(sum, 0);
        }
        return max;
        
    }
}
