Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.

On2 time On space
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= lower && nums[i] <= upper) {
                count++;
            }
        }
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int temp = nums[j] - nums[i];
                if(lower <= temp && temp <= upper) {
                    count++;
                }
            }
        }
        return count;
    }
}