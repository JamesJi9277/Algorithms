// Given a sequence of integers, find the longest increasing subsequence (LIS).

// You code should return the length of the LIS.

// Have you met this question in a real interview? Yes
// Example
// For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3

// For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4

// Challenge
// Time complexity O(n^2) or O(nlogn)

// Clarification
// What's the definition of longest increasing subsequence?

//    * The longest increasing subsequence problem is to find 
// a subsequence of a given sequence in which the subsequence's elements are in sorted order, 
// lowest to highest, and in which the subsequence is as long as possible. 
// This subsequence is not necessarily contiguous, or unique.  
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
                    //这个状态表示的是前i个数字中以i结尾的LIS的长度，加上等号是考虑有重复元素的出现
                    //所以就要在当前nums[i] >= nums[j]的情况下，从前往后扫。来不断更新最长的那个长度来作为res【i】
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }
}

public class Solution {
public int lengthOfLIS(int[] nums) {
    if(nums == null || nums.length == 0) {
        return 0;
    }
    int[] res = new int[nums.length];
    int len = 0;
    res[len] = nums[0];
    len++;
    for(int i = 1; i < nums.length; i++) {
        if(nums[i] < res[0]) {
            res[0] = nums[i];
        }
        else if(nums[i] > res[len - 1]) {
            res[len] = nums[i];
            len++;
        }
        else {
            int index = doBinarySearch(res, 0, len - 1, nums[i]);
            res[index] = nums[i];
        }
    }
    return len;
}
private int doBinarySearch(int[] nums, int start, int end, int target) {
    while(start + 1 < end) {
        int mid = start + (end - start)/2;
        if(nums[mid] == target) {
            return mid;
        }
        else if(nums[mid] < target) {
            start = mid;
        }
        else {
            end = mid;
        }
    }
    if(nums[start] == target) {
        return start;
    }
    else {
        return end;
    }
}}