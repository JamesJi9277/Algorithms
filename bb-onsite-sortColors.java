public class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}


public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return;
        }
        int[] count = new int[3];
        for(Integer item : nums) {
        	count[item]++;
        }
        int index = 0;
        for(int i = 0; i < 3; i++) {
        	while(count[i] > 0) {
        		nums[index++] = i;
        		count[i]--;
        	}
        }
    }
}


public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return;
        }
        int nextZero = 0;
        int nextTwo = nums.length - 1;
        int index = 0;
        while(index <= nextTwo) {
        	if(nums[index] == 0) {
        		doSwap(nums, index, nextZero);
        		index++;
        		nextZero++;
        	}
        	else if(nums[index] == 1) {
        		index++;
        	}
        	else {
        		doSwap(nums, index, nextTwo);
        		nextTwo--;
        	}
        }
    }
    private void doSwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return;
        }
        helper(nums, 0, nums.length - 1);
    }
    private void helper(int[] nums, int start, int end) {
    	if(start > end) {
    		return;
    	}
    	int left = start;
    	int right = end;
    	int pivot = nums[left];
    	while(left < right) {
    		while(left < right && nums[right] > pivot) {
    			right--;
    		}
    		if(left < right) {
    			doSwap(nums, left, right);
    			left++;
    		}
    		while(left < right && nums[left] <= pivot) {
    			left++;
    		}
    		if(left < right) {
    			doSwap(nums, left, right);
    			right--;
    		}
    	}
    	nums[left] = pivot;
    	helper(nums, start, left - 1);
    	helper(nums, left + 1, end);
    }
    private void doSwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
