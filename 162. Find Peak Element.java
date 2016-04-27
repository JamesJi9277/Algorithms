public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
          return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
          int mid = start + (end - start) / 2;
          if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
            return mid;
          }
          else if(nums[mid - 1] < nums[mid]) {
            start = mid;
          }
          else if(nums[mid - 1] > nums[mid]) {
            end = mid;
          }
        }
        if(nums[start] > nums[end]) {
          return start;
        }
        else {
          return end;
        }
    }
}


public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
          return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
          int mid = start + (end - start) / 2;
          if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
            return mid;
          }
          else if(nums[mid + 1] < nums[mid]) {
            end = mid;
          }
          else if(nums[mid + 1] > nums[mid]) {
            start = mid;
          }
        }
        if(nums[start] > nums[end]) {
          return start;
        }
        else {
          return end;
        }
    }
}
