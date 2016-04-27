/*
nothing fancy, just do binary search to get the first and last position*/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0) {
          return res;
        }
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }
    private int findFirst(int[] nums, int target) {
      int start = 0;
      int end = nums.length - 1;
      while(start + 1 < end) {
        int mid = start + (end - start) / 2;
        if(nums[mid] >= target) {
          end = mid;
        }
        else {
          start = mid;
        }
      }
      if(nums[start] == target) {
        return start;
      }
      else if(nums[end] == target) {
        return end;
      }
      else {
        return -1;
      }
    }
    private int findLast(int[] nums, int target) {
      int start = 0;
      int end = nums.length - 1;
      while(start + 1 < end) {
        int mid = start + (end - start) / 2;
        if(nums[mid] <= target) {
          start = mid;
        }
        else {
          end = mid;
        }
      }
      if(nums[end] == target) {
        return end;
      }
      else if(nums[start] == target) {
        return start;
      }
      else {
        return -1;
      }
    }
}
