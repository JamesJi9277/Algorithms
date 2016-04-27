// Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

// All elements < k are moved to the left
// All elements >= k are moved to the right
// Return the partitioning index, i.e the first index i nums[i] >= k.

// Have you met this question in a real interview? Yes
// Example
// If nums = [3,2,2,1] and k=2, a valid answer is 1.

// Note
// You should do really partition in array nums instead of just counting the numbers of integers smaller than k.

// If all elements in nums are smaller than k, then return nums.length
这一题跟挖坑quick select不一样的地方是挖坑是有一个空，然后不断地swap，将空上的那个element作为pivot
但是这一题是pivot已经选好了，只需要不断地比较然后不断地swap就好了，所以在while循环的时候，挖坑是left < right，
因为需要给坑留一个空来填当时挖出来的元素，但是这一题里面，不存在挖坑，只需要不断地swap就好
1.快排，时间On空间O1
public class Solution {
    public int partitionArray(int[] nums, int k) {
	    if(nums == null || nums.length == 0) {
	        return 0;
	    }
	    int left = 0;
	    int right = nums.length - 1;
	    int pivot = k;
	    while(left <= right) {
	        while(left <= right && nums[right] >= k) {
	            right--;
	        }
	        while(left <= right && nums[left] < k) {
	            left++;
	        }
	        if(left <= right) {
	            doSwap(nums, left, right);
	            left++;
	            right--;
	        }
	    }
	    return left;
    }
    private void doSwap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        return;
    }
}
简化版的swap
时间On空间O1
public class Solution {
    public int partitionArray(int[] nums, int k) {
	    if(nums == null || nums.length == 0) {
	        return 0;
	    }
	    int smaller = 0;
	    for(int i = 0; i < nums.length; i++) {
	        if(nums[i] < k) {
	            doSwap(nums, smaller, i);
	            smaller++;
	        }
	    }
	    return smaller;
    }
    private void doSwap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        return;
    }
}

额外数组，时间On空间On
public class Solution {
    public int partitionArray(int[] nums, int k) {
	    if(nums == null || nums.length == 0) {
	    	return 0;
	    }
	    int length = nums.length;
	    int[] copy = new int[length];
	    int left = 0;
	    int right = length - 1;
	    for(int i = 0; i < length; i++) {
	        if(nums[i] >= k) {
	            copy[right--] = nums[i];
	        }
	        else if(nums[i] < k) {
	            copy[left++] = nums[i];
	        }
	    }
	    for(int i = 0; i < length; i++) {
	        nums[i] = copy[i];
	    }
	    return left;
    }
}
先排序再找
时间Onlogn空间O1
public class Solution {
    public int partitionArray(int[] nums, int k) {
	    if(nums == null || nums.length == 0) {
	    	return 0;
	    }
	    Arrays.sort(nums);
	    for(int i = 0; i < nums.length; i++) {
	        if(nums[i] >= k) {
	            return i;
	        }
	    }
	    return nums.length;
    }
}
跟sortColor类似，双指针
时间On空间O1
public class Solution {
    public int partitionArray(int[] nums, int k) {
	    if(nums == null || nums.length == 0) {
	    	return 0;
	    }
	    int nextSmaller = 0;
	    int nextBigger = nums.length - 1;
	    int index = 0;
	    while(index <= nextBigger) {
	        if(nums[index] < k) {
	            doSwap(nums, nextSmaller, index);
	            index++;
	            nextSmaller++;
	        }
	        else if(nums[index] >= k) {
	            doSwap(nums, nextBigger, index);
	            nextBigger--;
	        }
	        else {
	            index++;
	        }
	    }
	    return nextSmaller;
    }
    private void doSwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

































