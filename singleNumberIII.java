// Given 2*n + 2 numbers, every numbers occurs twice except two, find them.

// Have you met this question in a real interview? Yes
// Example
// Given [1,2,2,3,4,4,5,3] return 1 and 5

//首先能够想到的brute force还是利用hash
public class Solution {
	public List<Integer> singleNumberIII(int[] A) {
		List<Integer> res = new ArrayList<Integer>();
		if(A == null || A.length == 0) {
			return res;
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
				res.add(A[i]);
			}
		}
		return res;
	}
}
// Challenge
// O(n) time, O(1) extra space.
//参考https://leetcode.com/discuss/52351/accepted-java-space-easy-solution-with-detail-explanations
//找到一种拆分的方法把2n+2的问题变成2n+1的问题， 2n' + 1, 2n'' + 1,然后在两个单数组中进行跟number I 一样的做法XOR一下就好了
public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        if(A == null || A.length == 0) {
        	return res;
        }
        int xor = 0;
        for(int i = 0; i < A.length; i++) {
        	xor ^= A[i];
        }
        int lastBit = xor - (xor & (xor - 1));
        int group0 = 0;
        int group1 = 0;
        for(int i = 0; i < A.length; i++) {
        	if((lastBit & A[i]) == 0) {
        		group0 ^= A[i];
        	}
        	else {
        		group1 ^= A[i];
        	}
        }
        res.add(group0);
        res.add(group1);
        return res;
    }
}


// 在上面的算法上进行优化，因为我需要找到两个数不一样的bit，有一个比较好的方法就是 s & (-s)
// 已知s求得-s的方法是按位取反然后加一，就正好得到的是不一样的那一位。
// 然后就可以直接将只有那一位不同的结果与对原来的数组进行XOR，
// 在XOR操作的时候利用if将原数组分成两个group，
// 一个是位数一样的，一个是位数上不一样的，这样就可以得到结果了
public class Solution {
	public List<Integer> singleNumberIII(int[] A) {
		List<Integer> res = new ArrayList<Integer>();
		//设置一个初值为0后，进行一次所有的遍历，找到两个落单的数额XOR值
		int diff = 0;
		for(int i = 0; i < A.length; i++) {
			diff ^= A[i];
		}
		//找到different bit
		diff &= (-diff);
		int m = 0;
		int n = 0;
		//进行for循环的时候顺便将原来的group分组
		for(int i = 0; i < A.length; i++) {
			if((A[i] & diff) == 0) {
				m ^= A[i];
			}
			else {
				n ^= A[i];
			}
		}
		res.add(m);
		res.add(n);
		return res;
	}
}
