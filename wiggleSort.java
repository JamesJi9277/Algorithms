Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

//brute force,先排序数组，然后按照题目的要求，只要相邻的两位大小不一样就好，所以就在相邻的两位进行swap的操作就好了
public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return;
    }
}

//On
public class Solution {
	public void wiggleSort(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}
		for(int i = 0; i < nums.length - 1; i++) {
			//这题的意思就是奇数位上的数要大于两边的数，所以思路比较暴力，全部撸一遍数组，
			//只要发现奇数位上的数小于其前面一个数
			//或者这个数是偶数位上的但是他却大于后面一个奇数位上的数，就要将他们进行swap操作
			if(((i % 2 == 0) && (nums[i] > nums[i + 1])) || ((i % 2 == 1) && (nums[i] < nums[i + 1]))) {
				int temp = nums[i];
				nums[i] = nums[i + 1];
				nums[i + 1] = temp;
			}
		}
	}
}

public class Solution {
	public void wiggleSort(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}
		for(int i = 0; i < nums.length - 1; i++) {
			if((i % 2 == 0) == (nums[i] > nums[i + 1])) {
				int temp = nums[i];
				nums[i] = nums[i + 1];
				nums[i + 1] = temp;
			}
		}
		return;
	}
}