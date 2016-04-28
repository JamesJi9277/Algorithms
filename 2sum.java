// Given an array of integers, find two numbers such that they add up to a specific target number.

/ The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.

// Have you met this question in a real interview? Yes
// Example
// numbers=[2, 7, 11, 15], target=9

// return [1, 2]

// Note
// You may assume that each input would have exactly one solution

// Challenge
// Either of the following solutions are acceptable:

// O(1) Space, O(nlogn) Time
// O(n) Space, O(n) Time
public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] res = new int[2];
        if(numbers == null || numbers.length == 0) {
        	return res;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++) {
        	if(map.containsKey(target - numbers[i])) {
        		res[0] = map.get(target - numbers[i]) + 1;
                res[1] = i + 1;
        	}
        	else {
        		map.put(numbers[i], i);
        	}
        }
        return res;；；；；；；
    }
}
//second write
public class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    if(numbers == null || numbers.length == 0) {
      return res;
    }
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i = 0; i < numbers.length; i++) {
      if(map.containsKey(target - numbers[i])) {
        res[0] = map.get(target - numbers[i]) + 1;
        res[1] = i + 1;
      }
      else {
        map.put(numbers[i], i);
      }
    }
    return res;
  }
}
//second write and time complexity is Onlogn, space complexity O(n)
public class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];
    int[] copy = new int[numbers.length];
    if(numbers == null || numbers.length == 0) {
      return res;
    }

    for(int i = 0; i < numbers.length; i++) {
      copy[i] = numbers[i];
    }
    Arrays.sort(numbers);
    int start = 0;
    int end = numbers.length - 1;
    while(start < end) {
      int sum = numbers[start] + numbers[end];
      if(sum == target) {
        break;
      }
      else if(sum < target) {
        start++;
      }
      else {
        end--;
      }
    }
    int m, n;
    for(m = 0; m < copy.length; m++) {
      if(copy[m] == numbers[start]) {
        break;
      }
    }
    for(n = 0; n < copy.length; n++) {
      if(copy[n] == numbers[end] && m != n) {
        break;
      }
    }
    res[0] = Math.min(m + 1, n + 1);
    res[1] = Math.max(m + 1, n + 1);
    return res;
  }
}
//time complexity O(nlogn), space O(n), hashmap and two pointer
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if( nums == null || nums.length < 2 ){
        	return result;
        }
        int length = nums.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < length; i++){
        	if( map.containsKey(nums[i]) ){
        		map.get(nums[i]).add(i);
        	}else{
        		ArrayList<Integer> temp = new ArrayList<Integer>();
        		temp.add(i);
        		map.put(nums[i], temp);
        	}
        }

        Arrays.sort(nums);
        int left = 0, right = length - 1;
        while( left < right ){
        	if( nums[left] + nums[right] < target ){
        		left++;
        	}else if( nums[left] + nums[right] > target ){
        		right--;
        	}else{
        		if( nums[left] == nums[right] ){
        			int temp1 = map.get(nums[left]).get(0);
        			int temp2 = map.get(nums[left]).get(1);
        			result[0] = Math.min(temp1, temp2) + 1;
        			result[1] = Math.max(temp1, temp2) + 1;
        		}else{
        			int temp1 = map.get(nums[left]).get(0);
        			int temp2 = map.get(nums[right]).get(0);
        			result[0] = Math.min(temp1, temp2) + 1;
        			result[1] = Math.max(temp1, temp2) + 1;
        		}
        		return result;
        	}
        }
        return result;
    }
}

//third write with hashmap and nlogn two pointer
public class Solution {
  public int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    if(nums == null || nums.length < 2) {
      return res;
    }
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    for(int i = 0; i < nums.length; i++) {
      if(map.containsKey(nums[i])) {
        map.get(nums[i]).add(i);
      }
      else {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(i);
        map.put(nums[i], temp);
      }
    }

    Arrays.sort(nums);
    int left = 0;
    int right = nums.length - 1;
    while(left < right) {
      int sum = nums[left] + nums[right];
      if(sum == target) {
        if(nums[left] == nums[right]) {
          int x = map.get(nums[left]).get(0);
          int y = map.get(nums[left]).get(1);
          res[0] = Math.min(x, y) + 1;
          res[1] = Math.max(x, y) + 1;
          return res;
        }
        else {
          int x = map.get(nums[left]).get(0);
          int y = map.get(nums[right]).get(0);
          res[0] = Math.min(x, y) + 1;
          res[1] = Math.max(x, y) + 1;
          return res;
        }
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
