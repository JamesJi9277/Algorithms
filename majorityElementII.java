//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
//The algorithm should run in linear time and in O(1) space.
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