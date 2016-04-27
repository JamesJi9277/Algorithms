// Implement int sqrt(int x).

// Compute and return the square root of x.

// Have you met this question in a real interview? Yes
// Example
// sqrt(3) = 1

// sqrt(4) = 2

// sqrt(5) = 2

// sqrt(10) = 3

// Challenge
// O(log(x))

public class Solution{
	public int sqrt(int x){
		if(x < 0) {
			return -1;
		}
		long start = 1;
		long end = x;
		while(start + 1 < end) {
			long mid = start + ((end - start)>>1);
			if(mid * mid == x) {
				return (int)mid;
			}
			else if (mid * mid < x) {
				start = mid;
			}
			else{
				end = mid;
			}
		}
		//因为Java里面是四舍五入，所以说应该先来比较end
		if(end * end == x) {
			return (int)end;
		}
		return (int)start;
	}
}
