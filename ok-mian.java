1) Given an array of unsorted non-negative integers of length z, 
write a function that returns the value of the maximum element. What is the running time?

2)  Same question, you need to return the maximum k elements, not just one.

Input - 5, 2, 3, 4, 1
k = 3
Output - 5, 4, 3

public class Solution {
  public int[] find(int[] nums,int k) {
    if(nums == null || nums.length == 0) {
       return 0;
    }
    int[] res = new int[k];
    int index = 0;
    int count = 1;
    while(k-- > 0) {
       res[index++] = findKth(nums, 0, nums.length - 1, nums.length - count + 1);
       count++;
    }
    return res;
  }
  //[1,2,3] k = 2,start = 0, end = 2
  private int findKth(int[] nums, int start, int end, int k) {
    if(start < 0 || end >= nums.length || start > end) {
      return 0;
    }
    int left = start;
    int right = end;
    int pivot = nums[left];
    while(left < right) {
      while(left < right && nums[right] > pivot) {
        right--;
      }
      if(left < right) {
        nums[left] = nums[right];
        left++;
      }
      while(left < right && nums[left] <= pivot) {
        left++;
      }
      if(left < right) {
        nums[right] = nums[left];
        right--;
      }
    }
    nums[left] = pivot;
    if(left + 1 == k) {
      return pivot;
    }
    else if(left + 1 < k) {
      return findKth(nums, left + 1, end, k);
    }
    else {
      return findKth(nums, start, left - 1, k);
    }
  }
}



