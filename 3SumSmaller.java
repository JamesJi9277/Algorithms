// Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
//
// For example, given nums = [-2, 0, 1, 3], and target = 2.
//
// Return 2. Because there are two triplets which sums are less than 2:
//
// [-2, 0, 1]
// [-2, 0, 3]
//brute force
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
          return 0;
        }
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
          for(int j = i + 1; j < nums.length - 1; j++) {
            for(int k = j + 1; k < nums.length; k++) {
              if(nums[i] + nums[j] + nums[k] < target) {
                count++;
              }
            }
          }
        }
        return count;
    }
}
// Follow up:
// Could you solve it in O(n2) runtime?
public class Solution {
  public int threeSumSmaller(int[] nums, int target) {
    if(nums == null || nums.length == 0) {
      return 0;
    }
    int count = 0;
    Arrays.sort(nums);
    for(int i = 0; i < nums.length - 2; i++) {
      //这里因为我要求的是满足条件的所有总数，所以说不需要进行去重操作
      int left = i + 1;
      int right = nums.length - 1;
      while(left < right) {
        if(nums[left] + nums[right] >= target - nums[i]) {
          right--;
        }
        else {
          //如果是满足sum < target,那么缩小left只会让sum更小，一样是满足条件，所以说在left-right这个区间中，left可以随意取值
          //所以count加上的总数应该是right -left
          count += (right - left);
          left++;
        }
      }
    }
    return count;
  }
}


public class Solution {
  public int threeSumSmaller(int[] nums, int target) {
    if(nums == null || nums.length < 3) {
      return 0;
    }
    int count = 0;
    Arrays.sort(nums);
    for(int i = 0; i < nums.length; i++) {
      count += twoSumSmaller(nums, i + 1, nums.length - 1, target - nums[i]);
    }
    return count;
  }
  private int twoSumSmaller(int[] nums, int start, int end, int target) {
    int count = 0;
    while(start < end) {
      if(nums[start] + nums[end] >= target) {
        end--;
      }
      else {
        count += (end - (start++));
      }
    }
    return count;
  }
}
