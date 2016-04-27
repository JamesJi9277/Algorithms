// Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return -1 instead.

// Have you met this question in a real interview? Yes
// Example
// Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.

// Challenge
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
//On
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right < nums.length) {
            sum += nums[right];
            while(sum >= s) {
            	minLen = Math.min(minLen, right - left + 1);
            	sum -= nums[left];
            	left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE? -1 : minLen;
    }
}
//Onlogn, space On
public class Solution {
	public int minimumSize(int[] nums, int s) {
		if(nums == null || nums.length == 0) {
			return -1;
		}
		int minLen = Integer.MAX_VALUE;
		int[] sum = new int[nums.length + 1];
		for(int i = 0; i < nums.length; i++) {
			sum[i + 1] = sum[i] + nums[i];
			if(sum[i + 1] >= s) {
				int j = doBinarySearch(0, i, sum[i + 1] - s + 1, sum);
				if(j != -1) {
					minLen = Math.min(minLen, i - j + 1);
				}
			}
		}
		return minLen == Integer.MAX_VALUE? -1: minLen;
	}
	private int doBinarySearch(int left, int right, int target, int[] sum) {
		while(left + 1 < right) {
			int mid = left + (right - left) / 2;
			if(sum[mid] >= target) {
				right = mid;
			}
			else if(sum[mid] < target) {
				left = mid;
			}
		}
		if(sum[right] < target) {
			return right;
		}
		else if(sum[left] < target) {
			return left;
		}
		else {
			return -1;
		}
	}
}
