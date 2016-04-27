Partition an integers array into odd number first and even number second.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 3, 4], return [1, 3, 2, 4]

Challenge
Do it in-place.
看到一左一右的数列题，并且是要in place的，就考虑双指针两头往中间夹逼
public class Solution {
    public void partitionArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int odd = 0;
        int even = nums.length - 1;
        while(odd < even) {
            while(odd < even && nums[odd] % 2 == 1) {
                odd++;
            }
            while(odd < even && nums[even] % 2 == 0) {
                even--;
            }
            if(odd < even) {
                doSwap(nums, odd, even);
                odd++;
                even--;
            }
        }
        return;
    }
    private void doSwap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}