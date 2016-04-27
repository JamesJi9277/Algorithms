Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.



public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int length = s.length();
        for(int i = 0; i < length; i++) {
            for(int j = i + 1; j <= length; j++) {
                String temp = s.substring(i, j);
                if(isValid(temp)) {
                    max = Math.max(max, temp.length());
                }
            }
        }
        return max;
    }
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            }
            else {
                if(!stack.isEmpty() && c == ')') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}