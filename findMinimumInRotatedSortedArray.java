// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// Have you met this question in a real interview? Yes
// Example
// Given [4, 5, 6, 7, 0, 1, 2] return 0

// Note
// You may assume no duplicate exists in the array.
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[end] > nums[mid]) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
