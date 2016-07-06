public class Solution {
	public boolean isPerfectSquare(int n) {
		int i = 1;
		while(n > 0) {
			n -= i;
			i += 2;
		}
		return n == 0;
	}
}