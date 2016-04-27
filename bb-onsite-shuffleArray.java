public class Solution {
	public int[] shuffle(int[] nums) {
		Random r = new Random();
		for(int i = 0; i < nums.length; i++) {
			int randomPos = r.nextInt(nums.length);
			int temp = nums[i];
			nums[i] = nums[randomPos];
			nums[randomPos] = temp;
		}
		return nums;
	}
}