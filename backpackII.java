// Given n items with size Ai and value Vi, and a backpack with size m. What's the maximum value can you put into the backpack?

// Have you met this question in a real interview? Yes
// Example
// Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.

// Note
// You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

// Challenge
// O(n x m) memory is acceptable, can you do it in O(m) memory?
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if(A == null || V == null || A.length == 0 || V.length == 0) {
            return 0;
        }
        int[][] f = new int[A.length + 1][m + 1];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= A.length; i++) {
            f[i][0] = 0;
        }
        for(int j = 0; j <= m; j++) {
            f[0][j] = Integer.MIN_VALUE;
        }
        f[0][0] = 0;
        for(int i = 1; i <= A.length; i++) {
            for(int j = 0; j <= m; j++) {
                f[i][j] = Math.max(f[i - 1][j], (j >= A[i-1])?f[i - 1][j - A[i - 1]] + V[i - 1] : 0);
                if(i == A.length) {
                    max = Math.max(max, f[i][j]);
                }
            }
        }
        return max;
    }
}

