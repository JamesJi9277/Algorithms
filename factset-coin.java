/*
- given a set of denomination of coins (1, 5, 10, 25, 50)
- write a method that returns that value in the least number of coins possible                                                                                                                         
- result should be the number of coins needed for each denomination                                                                                                                   . 1point 3acres 璁哄潧
*/
//但是不能够保证最优解，因为是greedy算法
public class Solution {
	public int[] leastNumberCoinChange(int[] denomination, int target) {
		if(denomination == null || denomination.length == 0) {
			return denomination;
		}
		int length = denomination.length;
		int[] res = new int[length];
		//币值是从小到大的顺序
		Arrays.sort(denomination);
		int index = length - 1;
		while(target >= 0) {
			if(target >= denomination[index]) {
				target -= denomination[index];
				res[index]++;
			}
			else {
				index--;
			}
		}
		return res;
	}
}
DP solution 
public class Solution {
	public int leastNumberCoinChange(int[] denomination, int target) {
		if(denomination == null || denomination.length == 0) {
			return 0;
		}
		int[] f = new int[target + 1];
		Arrays.sort(denomination);
		f[0] = 0;
		for(int i = 1; i < f.length; i++) {
			f[i] = Integer.MAX_VALUE;
		}
		for(int i = 1; i <= target; i++) {
			for(int j = 0; j < denomination.length; j++) {
				if(denomination[j] <= i && f[i - denomination[j]] + 1 < f[i]) {
					f[i] = f[i - denomination[j]] + 1;
				}
			}
		}
		return f[target];
	}
}
return all possible combination
币值是1，2，5，10
public class coin {
	//recursive
	public int allPossible(int[] denomination, int target) {
		if(denomination == null || denomination.length == 0 || target < 1) {
			return 0;
		}
		if(target == 0) {
			return 1;
		}
		int length = denomination.length;
		return count(denomination, length, target);
	}
	private int count(int[] denomination, int m, int n) {
		if(n == 0) {
			return 1;
		}
		if(n < 0) {
			return 0;
		}
		if(m < 1 && n >= 1) {
			return 0;
		}
		return count(denomination, m - 1, n) + count(denomination, m, n - denomination[m - 1]);
	}
	//dp
	public int allPossible1(int[] denomination, int target) {
		if(denomination == null || denomination.length == 0 || target < 1) {
			return 0;
		}
		int[] res = new int[target + 1];
		res[0] = 1;
		int length = denomination.length;
		for(int i = 0; i < length; i++) {
			for(int j = denomination[i]; j <= target; j++) {
				res[j] += res[j - denomination[i]];
			}
		}
		return res[target];
	}
	public static void main(String[] args) {
		coin c = new coin();
		int[] denomination = {1,2,5,10};
		int target = 20;
		System.out.println("The result is: " + c.allPossible(denomination, target));
	}
}