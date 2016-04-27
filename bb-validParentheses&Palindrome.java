public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(',')');map.put('[',']');map.put('{','}');
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                if(!stack.isEmpty() && map.get(stack.peek()) == c) {
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
valid palindrome
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        s = s.trim().toLowerCase();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isValid(c)) {
                stack.push(c);
            }
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isValid(c)) {
                if(c == stack.peek()) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private boolean isValid(Character c) {
        if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        else {
            return false;
        }
    }
}