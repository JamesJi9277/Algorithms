Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

Have you met this question in a real interview? Yes
Example
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

Challenge
The replacement must be in-place, do not allocate extra memory.



public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if(nums == null || nums.length < 2) {
            return;
        }
        int i = 0;
        for(i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                break;
            }
            else if(i == 0) {
                doReverse(nums, 0, nums.length - 1);
                return;
            }
        }
        int j = 0;
        for(j = nums.length - 1; j > i; j--) {
            if(nums[j] > nums[i]) {
                break;
            }
        }
        doSwap(nums, i, j);
        doReverse(nums, i + 1, nums.length - 1);
        return;
    }
    private void doReverse(int[] nums, int start, int end) {
        for(int i = 0; start + i < end - i; i++) {
            int temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }
    private void doSwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
