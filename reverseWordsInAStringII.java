// Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

// The input string does not contain leading or trailing spaces and the words are always separated by a single space.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Could you do it in-place without allocating extra space?
//the sky -> yks eht -> sky eht -> (外层)sky the
public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) {
            return;
        }
        int left = 0;
        int right = 0;
        doReverse(s, 0, s.length - 1);
        while(right < s.length) {
            if(right < s.length && s[right] != ' ') {
                right++;
            }
            else {
                doReverse(s, left, right - 1);
                right++;
                left = right;
            }
        }
        doReverse(s, left, right - 1);
    }
    private void doReverse(char[] s, int start, int end) {
        for(int i = 0; start + i < end - i; i++) {
            char c = s[start + i];
            s[start + i] = s[end - i];
            s[end - i] = c;
        }
    }
}

public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) {
            return;
        }
        int left = 0;
        int right = 0;
        doReverse(s, 0, s.length - 1);
        while(right < s.length) {
            while(right < s.length && s[right] != ' ') {
                right++;
            }
            doReverse(s, left, right - 1);
            right++;
            left = right;
        }
        doReverse(s, left, right - 1);
    }
    private void doReverse(char[] s, int left, int right) {
        for(int i = 0; left + i < right - i; i++) {
            char temp = s[left + i];
            s[left + i] = s[right - i];
            s[right - i] = temp;
        }
    }
}