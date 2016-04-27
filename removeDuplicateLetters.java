Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example:
Given "bcabc"
Return "abc"

Given "cbacdcbc"
Return "acdb"

public class Solution {
    public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack<Character>();
        int[] count = new int[26];
        boolean[] isExisted = new boolean[26];
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i++) {
            count[ch[i] - 'a']++;
        }
        for(Character c : ch) {
            count[c - 'a']--;
            if(isExisted[c - 'a']) {
                continue;
            }
            while(!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] != 0) {
                isExisted[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            isExisted[c - 'a'] = true;
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}


