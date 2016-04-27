/*
第一种是输入是无序的
第二种是输入是有序的*/
//时间On空间On
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0) {
          return res;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
          if(!map.containsKey(target - nums[i])) {
            map.put(nums[i], i);
          }
          else {
            res[0] = map.get(target - nums[i]);
            res[1] = i;
            return res;
          }
        }
        return res;
    }
}
//时间On2空间O1
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0) {
          return res;
        }
        for(int i = 0; i < nums.length - 1; i++) {
          for(int j = i + 1; j < nums.length; j++) {
            if(nums[i] + nums[j] == target) {
              res[0] = i;
              res[1] = j;
              return res;
            }
          }
        }
        return res;
    }
}

//input is sorted
//time On
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        if(numbers == null || numbers.length == 0) {
          return res;
        }
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
          int sum = numbers[left] + numbers[right];
          if(sum == target) {
            res[0] = left + 1;
            res[1] = right + 1;
            return res;
          }
          else if(sum < target) {
            left++;
          }
          else {
            right--;
          }
        }
        return res;
    }
}
//time Onlogn
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = {-1, -1};
        if(numbers == null || numbers.length == 0) {
          return res;
        }
        for(int i = 0; i < numbers.length - 1; i++) {
          int pos = doBinarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
          if(pos != -1) {
            res[0] = i + 1;
            res[1] = pos + 1;
            return res;
          }
        }
        return res;
    }
    private int doBinarySearch(int[] nums, int start, int end, int target) {
      while(start + 1 < end) {
        int mid = start + (end - start) / 2;
        if(nums[mid] == target) {
          return mid;
        }
        else if(nums[mid] > target) {
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
}


//data structure design
public class TwoSum {

    // Add the number to an internal data structure.
  ArrayList<Integer> res = new ArrayList<Integer>();
	public void add(int number) {
	    res.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      for(int i = 0; i < res.size(); i++) {
        if(!map.containsKey(value - res.get(i))) {
          map.put(res.get(i), i);
        }
        else {
          return true;
        }
      }
      return false;
	}
}
