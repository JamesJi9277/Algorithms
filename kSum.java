// Given n distinct positive integers, integer k (k <= n) and a number target.

// Find k numbers where sum is target. Calculate how many solutions there are?

// Have you met this question in a real interview? Yes
// Example
// Given [1,2,3,4], k = 2, target = 5.

// There are 2 solutions: [1,4] and [2,3].

// Return 2.
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        int[][][] f = new int[A.length + 1][k + 1][target + 1];
        for(int i = 0; i <= A.length; i++) {
            f[i][0][0] = 1;
        }
        for(int i = 1; i <= A.length; i++) {
            for(int j = 1; j <= k && j <= i; j++) {
                for(int t = 1; t <= target; t++) {
                    f[i][j][t] = f[i - 1][j][t] + ((t >= A[i - 1])? f[i - 1][j - 1][t - A[i - 1]] : 0);
                }
            }
        }
        return f[A.length][k][target];
    }
}



//backtracking, correct but memory limit exceeded
public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        int count = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        helper(res, temp, A, 0);
        for(int i = 0; i < res.size(); i++) {
            if(res.get(i).size() != 2) {
                continue;
            }
            int sum = getSum(res.get(i));
            if(sum == k) {
                count++;
            }
        }
        return count;
    }
    private int getSum(ArrayList<Integer> arr) {
        int sum = 0;
        for(int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] A, int pos) {
        res.add(new ArrayList<Integer>(temp));
        for(int i = pos; i < A.length; i++) {
            temp.add(A[i]);
            helper(res, temp, A, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

