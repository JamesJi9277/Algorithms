// Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.

// Have you met this question in a real interview? Yes
// Example
// Given N = 3 and the array [0, 1, 3], return 2.

// Challenge
// Do it in-place with O(1) extra memory and O(n) time.
public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)  {
            return 0;
        }
        int res = 0;
        for(int i = 1; i <= nums.length; i++) {
            res ^= i;
        }
        for(int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}

public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}

public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)  {
            return 0;
        }
        int start = 0;
        int end = nums.length;
        int sum = (start + end) * (end - start + 1) / 2;
        for(int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }
}

public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0)  {
            return 0;
        }
        for(int i = 0; i < nums.length;) {
            if(nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
            else {
                i++;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
