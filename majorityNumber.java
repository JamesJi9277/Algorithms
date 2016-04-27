// Given an array of integers, 
//the majority number is the number that occurs more than half of the size of the array. Find it.

// Have you met this question in a real interview? Yes
// Example
// Given [1, 1, 1, 1, 2, 2, 2], return 1
public class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[index] == nums[i]) {
                count++;
            }
            else {
                count--;
            }
            if(count == 0) {
                index = i;
                count = 1;
            }
        }
        return nums[index];
    }
}
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.size(); i++) {
            if(map.containsKey(nums.get(i))) {
                int j = map.get(nums.get(i));
                map.put(nums.get(i), j + 1);
            }
            else {
                map.put(nums.get(i), 1);
            }
        }
        for(int i = 0; i < nums.size();i++) {
            if(map.get(nums.get(i)) > (nums.size()/2))  {
                return nums.get(i);
            }
        }
        return 0;
    }
}


// Challenge
// O(n) time and O(1) extra space
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0) {
            return 0;
        }
        int index = 0;
        int count = 1;
        for(int i = 1; i < nums.size(); i++) {
            if(nums.get(index) == nums.get(i)) {
                count++;
            }
            else {
                count--;
            }
            if(count == 0) {
                index = i;
                count = 1;
            }
        }
        return nums.get(index);
    }
}


