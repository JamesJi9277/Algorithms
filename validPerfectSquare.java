public class Solution {
	public boolean isPerfectSquare(int n) {
		int i = 1;
		for(; n > 0; i += 2) {
			n -= i;
		}
		return n == 0;
	}
}