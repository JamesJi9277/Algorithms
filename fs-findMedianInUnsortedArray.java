import java.util.*;
public class find {
	public double findMedian(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length % 2 == 1) {
			return findKth(nums, 0, nums.length - 1, (nums.length  + 1) /2);
		}
		else {
			return (findKth(nums, 0, nums.length - 1, nums.length / 2) + findKth(nums, 0, nums.length - 1, nums.length / 2 + 1)) / 2.0;
		}
	}
	private int findKth(int[] nums, int start, int end, int k) {
		int left = start;
		int right = end;
		int pivot = nums[start];
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
	public static void main(String[] args) {
		find f = new find();
		int[] nums = {1,3,4,5};
		System.out.print("median is " + f.findMedian(nums));
	}
}