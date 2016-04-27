// Given 2*n + 1 numbers, every numbers occurs twice except one, find it.

// Have you met this question in a real interview? Yes
// Example
// Given [1,2,2,1,3,4,3], return 4
//hashmap来记录然后遍历数组两次，一次记录进map，一次扫描map
public class Solution {
	public int singleNumber(int[] A) {
		if(A == null || A.length == 0) {
			return 0;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < A.length; i++) {
			if(map.containsKey(A[i])) {
				map.put(A[i], map.get(A[i]) + 1);
			}
			else {
				map.put(A[i], 1);
			}
		}
		for(int i = 0; i < A.length; i++) {
			if(map.get(A[i]) != 2) {
				return A[i];
			}
		}
		return 0;
	}
}
// Challenge
// One-pass, constant extra space.
//利用XOR的性质，两个数一样则为0，不然则为1，这样子异或下来，最后一个数就是那个落单的数
// XOR特点
// a ^ b = c => a ^ c = b, b ^ c = a
// a ^ a = 0
// a ^ 0 = a
// 相当于是信息抵消
public class Solution {
	/**
	 *@param A : an integer array
	 *return : a integer 
	 */
	public int singleNumber(int[] A) {
		//注意讨论A.length == 0的这种情况
	    if(A == null || A.length == 0) {
	        return 0;
	    }
		int res = A[0];
		for(int i = 1; i < A.length; i++) {
			res = res ^ A[i];
		}
		return res;
	}
}
