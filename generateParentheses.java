Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Have you met this question in a real interview? Yes
Example
Given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> res = new ArrayList<String>();
        if(n < 1) {
            return res;
        }
        helper(res, n, n, "");
        return res;
    }
    private void helper(ArrayList<String> res, int left, int right,String s) {
        if(left > right) {
            return;
        }
        if(left == 0 && right == 0) {
            res.add(new String(s));
            return;
        }
        if(left > 0) {
            helper(res, left - 1, right, s + "(");
        }
        if(right > 0) {
            helper(res, left, right - 1, s + ")");
        }
    }
}
