//A square number is 1+3+5+7+...
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

public class Solution {
	public boolean isPerfectSquare(int n) {
		long r = n;
		while(r * r > n) {
			r = (r + n / r) / 2;
		}
		return r * r == n;
	}
}