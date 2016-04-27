// Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.

// Find it.

// Have you met this question in a real interview? Yes
// Example
// Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.

// Note
// There is only one majority number in the array.

// Challenge
// O(n) time and O(k) extra space
public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
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
            if(map.get(nums.get(i)) > (nums.size()/k))  {
                return nums.get(i);
            }
        }
        return 0;
    }
}
