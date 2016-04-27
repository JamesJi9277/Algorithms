// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// Have you met this question in a real interview? Yes
// Example
// "A man, a plan, a canal: Panama" is a palindrome.

// "race a car" is not a palindrome.

// Note
// Have you consider that the string might be empty? This is a good question to ask during an interview.

// For the purpose of this problem, we define empty string as valid palindrome.
//time O(n), space O(n)
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        s = s.trim();
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isValid(c)) {
                stack.push(c);
                sb.append(c);
            }
        }
        for(int i = 0; i < sb.length(); i++) {
            if(!stack.isEmpty() && stack.pop() != sb.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    private boolean isValid(char c) {
        if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }
}



public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        s = s.trim();
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isValid(c)) {
                stack.push(c);
                sb.append(c);
            }
        }
        int index = 0;
        while(index < sb.length()) {
            if(index < sb.length() && !stack.isEmpty() && stack.peek() == sb.charAt(index)) {
                stack.pop();
                index++;
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    private boolean isValid(char c) {
        if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }
}



public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        s = s.trim();
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++) {
            if(isValid(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
        }
        int index = 0;
        while(!stack.isEmpty()) {
            while(index < s.length() && !isValid(s.charAt(index))) {
                index++;
            }
            if(index < s.length() && !stack.isEmpty() && stack.peek().equals(s.charAt(index))) {
                stack.pop();
                index++;
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    private boolean isValid(char c) {
        if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }
}
//time O(n), space O(1)
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        s = s.trim();
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
            while(left <= right && !isValid(s.charAt(right))) {
                right--;
            }
            while(left <= right && !isValid(s.charAt(left))) {
                left++;
            }
            if(left <= right && s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean isValid(char c) {
        if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }
}

public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if(s == null || s.length() < 2) {
            return true;
        }
        s = s.trim();
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
            while(left <= right && isValid(s.charAt(left)) == false) {
                left++;
            }
            while(left <= right && isValid(s.charAt(right)) == false) {
                right--;
            }
            //注意这种情况下的大的if条件，不可以连起来写，这样会造成判断失误
            if(left <= right) {
                if(s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char c) {
        if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
            return true;
        }
        return false;
    }
}




