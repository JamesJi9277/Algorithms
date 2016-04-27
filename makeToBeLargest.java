Given four integers, 
make F(S) = abs(S[0] - S[1]) + abs(S[1] - S[2]) + abs(S[2] - S[3]) to be largest.


import java.util.Arrays;

public class findLargest {
	public void largestSum(int[] nums) {
		if(nums == null || nums.length == 0) {
			return ;
		}
		Arrays.sort(nums);
		doSwap(nums, 1, 3);
		doSwap(nums, 2, 3);
		int res = Math.abs(nums[0] - nums[1]) + Math.abs(nums[1] - nums[2]) + Math.abs(nums[2] - nums[3]);
		System.out.println("The optimal result is " + res);
	}
	public void doSwap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public static void main(String[] args) {
		findLargest f = new findLargest();
		int[] nums = {5,7,88,99};
		f.largestSum(nums);
	}
}