public class Unique {
	public int find(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums[0] < 0 || nums[0] > nums.length - 1) {
			return -1;
		}
		for(int i = 0; i < nums.length; i++) {
			if(i == nums[i]) {
				return i;
			}
		}
		return -1;
	}
}