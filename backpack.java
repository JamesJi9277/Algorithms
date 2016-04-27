// Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

// Have you met this question in a real interview? Yes
// Example
// If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

// You function should return the max size we can fill in the given backpack.

// Note
// You can not divide any item into small pieces.

// Challenge
// O(n x m) time and O(m) memory.

// O(n x m) memory is also acceptable if you do not know how to optimize memory.
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        //f[i][j]表示的是，前i个数，能否组成和为j
        if(A == null || A.length == 0) {
            return 0;
        }
        boolean[][] f = new boolean[A.length + 1][m + 1];
        f[0][0] = true;
        for(int i = 1; i <= A.length; i++) {
            //注意这里的j的范围。应该从0开始
            for(int j = 0; j <= m; j++) {
                f[i][j] = f[i - 1][j]; 
                if(j >= A[i - 1] && f[i - 1][j - A[i - 1]]) {
                    f[i][j] = true;
                }
            }
        }
        for(int i = m ; i >=0; i--) {
            if(f[A.length][i]) {
                return i;
            }
        }
        return 0;
    }
}
//通过滚动数组来省空间，因为i只跟i-1有关系
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        //f[i][j]表示的是，前i个数，能否组成和为j
        if(A == null || A.length == 0) {
            return 0;
        }
        boolean[][] f = new boolean[2][m + 1];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j <= m; j++) {
                //一定要注意下标
                f[(i + 1) % 2][j] = f[i % 2][j]; //第i个不取的情况
                //第i个取的情况, 然后应该是状态上是 i + 1
                if(j >= A[i] && f[i % 2][j - A[i]]) {
                    f[(i + 1) % 2][j] = true;
                }
            }
        }
        for(int i = m; i >=0; i--) {
            if(f[A.length % 2][i]) {
                return i;
            }
        }
        return 0;
    }
}

//subsets变种, correct but memory limit exceeded.
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(A == null || A.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        helper(res, temp, A, 0);
        for(int i = 0; i < res.size(); i++) {
            if(m - getSum(res.get(i)) >= 0) {
                min = Math.min(min, m - getSum(res.get(i)));
            }
        }
        return m - min;
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
        return;
    }
}

