public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0) {
            return nums ;
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = a * nums[i] * nums[i] + b * nums[i] + c;
        }
        Arrays.sort(nums);
        return nums;
    }
}

