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
		long end = n;
		while(end * end > n) {
			end = (end + n / end) / 2;
		}
		return end * end == n;
	}
}

public class Solution {
	public boolean isPerfectSquare(int n) {
		if(n < 1) {
			return false;
		}
		if(n == 1) {
			return true;
		}
		long start = 1;
		long end = n;
		while(start + 1 < end) {
			long mid = start + (end - start) / 2;
			if(mid * mid == (long)n) {
				return true;
			}
			else if(mid * mid > (long)n) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
		if(start * start == (long)n) {
			return true;
		}
		else if(end * end == (long)n) {
			return true;
		}
		else {
			return false;
		}
	}
}