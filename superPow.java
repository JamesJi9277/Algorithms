/*
Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024
*/
public class Solution {
	public int superPow(int a, int[] b) {
		if(a == 0) {
			return 0;
		}
		if(b == null || b.length == 0) {
			return 1;
		}
		long weight = 1;
		long m = 0;
		for(int i = b.length - 1; i >= 0; i--) {
			m += weight * (long)b[i];
			weight *= 10;
		}
		int res = 0;
		for(long i = 0; i < m; i++) {
			res += (a % 1337);
		}
		return res;
	}
}