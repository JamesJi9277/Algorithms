public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, 1);
        int max = 0;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }
}