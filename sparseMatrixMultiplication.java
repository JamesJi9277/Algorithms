Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |




//TLE,利用最最基本的矩阵乘法，时间复杂度是On3,造成TLE是因为重复计算出现在了如果存在大量0的情况，就没必要去计算
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0) {
        	return null;
        }
        int am = A.length;
        int an = A[0].length;
        int bm = B.length;
        int bn = B[0].length;
        int[][] res = new int[am][bn];
        for(int i = 0; i < am; i++) {
        	for(int j = 0; j < bn; j++) {
        		res[i][j] = helper(A, B, i, j);
        	}
        }
        return res;
    }
    private int helper(int[][] A, int[][] B, int left, int right) {
    	int am = A.length;
        int an = A[0].length;
        int bm = B.length;
        int bn = B[0].length;
        int i = 0;
        int res = 0;
        while(i >= 0 && i < an && i < bm) {
        	res += (A[left][i] + B[i][right]);
        	i++;
        }
        return res;
    }
}


public class Solution {
	public int[][] multiply(int[][] A, int[][] B) {
		if(A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0) {
        	return null;
        }
        int am = A.length;
        int an = A[0].length;
        int bm = B.length;
        int bn = B[0].length;
        int[][] res = new int[am][bn];
        for(int i = 0; i < am; i++) {
        	for(int k = 0; k < an; k++) {
        		if(A[i][k] != 0) {
        			for(int j = 0; j < bn; j++) {
        				if(B[k][j] != 0) {
        					res[i][j] += (A[i][k] * B[k][j]);
        				}
        			}
        		}
        	}
        }
        return res;
	}
}