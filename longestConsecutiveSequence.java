// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

// Have you met this question in a real interview? Yes
// Example
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

// Clarification
// Your algorithm should run in O(n) complexity.
//Onlogn time
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        int maxLength = 1;
        int temp = 1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                continue;
            }
            else if(nums[i] + 1 == nums[i + 1]) {
                temp++;
                maxLength = Math.max(maxLength, temp);
            }
            else {
                temp = 1;
            }
        }
        return maxLength;
    }
}
//On time, On space
public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        int maxLength = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            int pivot = nums[i];
            int count = 1;
            set.remove(pivot);
            pivot++;
            while(set.contains(pivot)) {
                set.remove(pivot);
                pivot++;
                count++;
            }
            pivot = nums[i] - 1;
            while(set.contains(pivot)) {
                set.remove(pivot);
                pivot--;
                count++;
            }
            maxLength = Math.max(count, maxLength);
        }
        return maxLength;
    }
}
