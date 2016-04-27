// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

// Have you met this question in a real interview? Yes
// Example
// For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

// Note
// You may assume that each input would have exactly one solution.

// Challenge
// O(n^2) time, O(1) extra space
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        if(numbers == null || numbers.length == 0 || numbers.length < 3) {
        	return 0;
        }
        Arrays.sort(numbers);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < numbers.length - 2; i++) {
        	int left = i + 1;
        	int right = numbers.length - 1;
        	while(left < right) {
        		int sum = numbers[i] + numbers[left] + numbers[right];
        		if(Math.abs(target - sum) < min) {
        			min = Math.abs(target - sum);
        			res = sum;
        		}
        		if(target == sum) {
                    res = sum;
        			return res;
        		}
        		else if(target > sum) {
        			left++;
        		}
        		else {
        			right--;
        		}
        	}
        }
        return res;
    }
}

