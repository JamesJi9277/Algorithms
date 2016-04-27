To compute gcd(48,18), divide 48 by 18 to get a quotient of 2 and a remainder of 12. 
Then divide 18 by 12 to get a quotient of 1 and a remainder of 6. 
Then divide 12 by 6 to get a remainder of 0, which means that 6 is the gcd


public class findGCD {
	public int find(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		if(nums.length == 1) {
			return nums[0];
		}
		int res = gcd(nums[0], nums[1]);
		for(int i = 2; i < nums.length; i++) {
			res = gcd(res, nums[i]);
		}
		return res;
	}
	private int gcd(int a, int b) {
		if(a == b) {
			return a;
		}
		int num1 = Math.max(a, b);
		int num2 = Math.min(a, b);
		int rem = num1 % num2;
		if(rem == 0) {
			return num2;
		}
		else {
			return gcd(rem, num2);
		}
	}
	public static void main(String[] args) {
		findGCD f = new findGCD();
		int[] nums = {7,20,30,40};
		System.out.print(f.find(nums));
	}
}
