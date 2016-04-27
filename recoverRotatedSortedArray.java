// Given a rotated sorted array, recover it to sorted array in-place.

// Have you met this question in a real interview? Yes
// Example
// [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

// Challenge
// In-place, O(1) extra space and O(n) time.

// Clarification
// What is rotated array?

// For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0) {
            return;
        }
        int start = 0;
        int end = nums.size() - 1;
        int i;
        for(i = 0;i < nums.size() - 1; i++) {
            if(nums.get(i) > nums.get(i + 1)) {
                break;
            }
        }
        doReverse(nums, 0, i);
        doReverse(nums, i + 1, nums.size()-1);
        doReverse(nums, 0, nums.size()-1);
        return;
    }
     private void doReverse(ArrayList<Integer> nums, int start, int end) {
         for(int i = start, j = end; i < j; i++, j--) {
             int temp = nums.get(i);
             nums.set(i, nums.get(j));
             nums.set(j, temp);
         }
         return;
     }
}

