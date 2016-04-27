Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number. Please return the number of pairs.

Have you met this question in a real interview? Yes
Example
numbers=[2, 7, 11, 15], target=24

return 1

Challenge
Either of the following solutions are acceptable:

O(1) Space, O(nlogn) Time
public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while(left < right) {
            if(nums[left] + nums[right] <= target) {
                left++;
            }
            if(left < right && nums[left] + nums[right] > target) {
                count += (right - left);//这里很容易犯错！！！
                right--;
            }
        }
        return count;
    }
}
