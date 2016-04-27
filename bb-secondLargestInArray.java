public class Solution {
	public int secondLargest(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		Arrays.sort(nums);
		int max = nums[nums.length - 1];
		int index = nums.length - 2;
		while(index >= 0 && nums[index] == max) {
			index--;
		}
		return (index < 0) ? nums[index + 1] : nums[index];
	}
}
public class Solution {
	public int secondLargest(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		Comp cmp = new Comp();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(cmp);
		for(Integer item : nums) {
			maxHeap.offer(item);
		}
		int max = maxHeap.poll();
		int res = maxHeap.poll();
		if(maxHeap.isEmpty() && max == res) {
			return max;
		}
		while(max == res && !maxHeap.isEmpty()) {
			res = maxHeap.poll();
		}
		return res;
	}
}