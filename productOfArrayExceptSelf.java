public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }
        int length = nums.length;
        int[] res = new int[length];
        res[0] = 1;
        for(int i = 1; i < length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int weight = nums[length - 1];
        for(int i = length - 2; i >= 0; i--) {
            res[i] *= weight;
            weight *= nums[i];
        }
        return res;
    }
}

