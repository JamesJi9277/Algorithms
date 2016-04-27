Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.

On3
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[k] > nums[j] && nums[j] > nums[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
On
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for(Integer i : nums) {
            if(i > first && i < second) {
                second = i;
            }
            if(i > second) {
                return true;
            }
            if(i < first) {
                first = i;
            }
        }
        return false;
    }
}