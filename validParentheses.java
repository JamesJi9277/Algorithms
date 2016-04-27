// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// Have you met this question in a real interview? Yes
// Example
// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        if(s == null || s.length() == 1) {
            return false;
        }
        if(s.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        Stack<Character> stack = new Stack<Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur =='[' || cur == '{' || cur == '(') {
                stack.push(cur);
            }
            else{
                if(!stack.isEmpty() && map.get(stack.peek()) == cur) {
                    stack.pop();
                }
                else return false;
            }
        }
        if( stack.isEmpty()) {
            return true;
        }
        return false;
    }
}


//second write, bug free
public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 1) {
            return false;
        }
        if(s.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        Stack<Character> stack = new Stack<Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            }
            else if(!stack.isEmpty() && map.get(stack.peek()) == cur) {
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
