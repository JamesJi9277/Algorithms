// Print numbers from 1 to the largest number with N digits by recursion.

// Have you met this question in a real interview? Yes
// Example
// Given N = 1, return [1,2,3,4,5,6,7,8,9].

// Given N = 2, return [1,2,3,4,5,6,7,8,9,10,11,12,...,99].

// Note
// It's pretty easy to do recursion like:

// recursion(i) {
//     if i > largest number:
//         return
//     results.add(i)
//     recursion(i + 1)
// }
// however this cost a lot of recursion memory as the recursion depth maybe very large. Can you do it in another way to recursive with at most N depth?
public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        if(n <= 0) {
            return res;
        }
        for(int i = 1; i < (int)Math.pow(10, n) ;i++) {
            res.add(i);
        }
        return res;
    }
}
public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        helper((int)Math.pow(10, n) - 1, res);
        Collections.reverse(res);
        return res;
    }
    private void helper(int n, List<Integer> res) {
        if(n == 0) {
            return;
        }
        res.add(n);
        helper(n - 1, res);
    }
}
// Challenge
// Do it in recursion, not for-loop.
public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        if(n <= 0) {
            return res;
        }
        for(int i = 1; i <= 9; i++) {
            helper(res, i, 1, (int)Math.pow(10,n));
        }
        Collections.sort(res);
        return res;
    }
    private void helper(List<Integer> res, int i, int start, int end) {
        if(i < start || i >= end) {
            return;
        }
        res.add(i);
        for(int j = 0; j <= 9; j++) {
            helper(res, i*10 + j, start, end);
        }
    }
}
