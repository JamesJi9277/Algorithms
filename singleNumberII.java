// Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.

// Have you met this question in a real interview? Yes
// Example
// Given [1,1,2,3,3,3,2,2,4,1] return 4

//最常规的做法还是利用map来记录然后检查, 
//time On, space On
public class Solution {
	public int singleNumberII(int[] A) {
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
			if(map.get(A[i]) != 3) {
				return A[i];
			}
		}
		return 0;
	}
}
//time Onlogn, space O1
//一个比较巧妙的方法，先sort数组，然后i与i+ 1比较，并且i每次进3位
//这里所说的single number指的是这个数只出现过一次，而不是说我其他的书出现了三次，这个数可以出现两次
//好好理解题意
public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        for(int i = 0; i < A.length - 3; i += 3) {
            if(A[i] != A[i + 1]) {
                return A[i];
            }
        }
        return A[A.length - 1];
    }
}

// Challenge
// One-pass, constant extra space.
// 2->010, 3->011, 1->001
// 我们通过统计每一位上的1的个数，来找到落单的数，
// 因为凡是出现过3次的那些数据，他们的二进制为1的那些位，
// 出现的次数加起来后一定能够被3整除。
// 比如2包含1的位是第二位，我们统计第二位有3个1。3包含1的位也有第二位，
// 现在第二位有6个1，最终6%3=0. 而3包含1的为还有第一位，
// 此时有3个1，但是还有个落单的1，因此现在第一位上有4个1。因此4%3不为0.
// 即意味着有一个落单的数，在这一位上多贡献了一个1
// 把XOR进行扩展，让数字三个三个一起抵消，变成三进制的异或，利用不进位加法的特性
// 012
// 012
// 012
// ---
// 036 %3 = 000
public class Solution {
	public int singleNumberII(int[] A) {
		if(A == null || A.length == 0) {
			return 0;
		}
		int res = 0;
		int[] bits = new int[32];
		for(int i = 0; i < 32; i++) {
			for(int j = 0; j < A.length; j++) {
				bits[i] += ((A[j] >> i) & 1);
				bits[i] %= 3;
			}
			//只要我某个位数上最终为1的话，那么我进行|操作，这个位上都是1
			res |= (bits[i] << i);
		}
		return res;
	}
}