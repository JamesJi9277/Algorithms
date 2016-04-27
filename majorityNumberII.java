// Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

// Find it.

// Have you met this question in a real interview? Yes
// Example
// Given [1, 2, 1, 2, 1, 3, 3], return 1.

// Note
// There is only one majority number in the array.

// Challenge
// O(n) time and O(1) extra space.
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(Integer item : nums) {
            if(map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            }
            else {
                map.put(item, 1);
            }
        }
        for(Integer item : nums) {
            if(map.get(item) > nums.length / 3) {
                if(!set.contains(item)) {
                    res.add(item);
                    set.add(item);
                }
            }
        }
        return res;
    }
}

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        int nums1 = nums[0];
        int nums2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums1) {
                count1++;
            }
            else if(nums[i] == nums2) {
                count2++;
            }
            else if(count1 == 0) {
                nums1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0) {
                nums2 = nums[i];
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums1) {
                count1++;
            }
            else if(nums[i] == nums2) {
                count2++;
            }
        }
        if(count1 > nums.length / 3) {
            res.add(nums1);
        }
        if(count2 > nums.length / 3) {
            res.add(nums2);
        }
        return res;
    }
}


