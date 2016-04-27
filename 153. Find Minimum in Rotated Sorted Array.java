/*
assume there is no duplicate*/
//时间On，空间O1
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
          return -1;
        }
        int min = Integer.MAX_VALUE;
        for(Integer i : nums) {
          min = Math.min(min, i);
        }
        return min;
    }
}
//时间Ologn，空间O1
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
          return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
          int mid = start + (end - start) / 2;
          //有可能没有rotate，所以trick的是需要用end和mid来判断
          if(nums[mid] < nums[end]) {
            end = mid;
          }
          else {
            start = mid;
          }
        }
        return Math.min(nums[start], nums[end]);
    }
}
