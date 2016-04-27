You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
        	return res;
        }
        int length = nums.length;
        for(int i = 0; i < length; i++) {
        	int[] temp = getSubarray(i, nums);
        	int count = doBinarySearch(nums[i], temp);
        	res.add(count);
        }
        return res;
    }
    private int[] getSubarray(int first, int[] nums) {
    	int length = nums.length;
    	int[] res = new int[length - first];
    	int newLength = res.length;
    	int index = 0;
    	while(index < newLength) {
    		res[index] = nums[first + index ];
    		index++;
    	}
    	Arrays.sort(res);
    	return res;
    }
    private int doBinarySearch(int target, int[] nums) {
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
    	if(nums[start] >= target) {
    		return start;
    	}
    	else if(nums[end] >= target) {
    		return end;
    	}
    	else {
    		return 0;
    	}
    }
}