Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isnt one, return 0 instead.

Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

Follow Up:
Can you do it in O(n) time?

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                int sum = getSum(nums, i, j);
                if(sum == k) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max;
    }
    private int getSum(int[] nums, int i, int j) {
        int sum = 0;
        for(int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }
}

public class Solution {
	public int maxSubArrayLen(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		//注意前缀和这里的初始化问题！！！
		int[] prefixSum = new int[nums.length + 1];
		prefixSum[0] = 0;
		for(int i = 1; i <= nums.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
		}
		int max = 0;
		for(int i = 0; i <= nums.length; i++) {
			for(int j = i + 1; j <= nums.length; j++) {
				if(prefixSum[j] - prefixSum[i] == k) {
					max = Math.max(max, j - i);
				}
			}
		}
		return max;
	}
}

public class Solution {
	public int maxSubArrayLen(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int[] prefixSum = new int[nums.length + 1];
		prefixSum[0] = 0;
		for(int i = 1; i <= nums.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
		}
		int max = 0;
		for(int i = 0; i <= nums.length; i++) {
			for(int j = i + 1; j <= nums.length; j++) {
				if(prefixSum[j] - prefixSum[i] == k) {
					max = Math.max(max, j - i);
				}
			}
		}
		return max;
	}
}

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(nums[0], 0);
        //不用为前缀和数组新开辟空间，直接在原数组的基础上模拟前缀和数组就好
        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            //这一步添加也十分的巧妙。只添加第一次出现过的，这样子保证了结果的顺序始终是最大的
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        int max = 0;
        //在比较的时候从后往前比较
        for(int j = nums.length - 1; j >= 0; j--) {
            int target = nums[j] - k;
            if(target == 0) {
                max = Math.max(max, j + 1);
            }
            else if(map.containsKey(target)) {
                max = Math.max(max, j - map.get(target));
            }
        }
        return max;
    }
}


