// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Have you met this question in a real interview? Yes
// Example
// Clarification
// What constitutes a word?
// A sequence of non-space characters constitutes a word.
// Could the input string contain leading or trailing spaces?
// Yes. However, your reversed string should not contain leading or trailing spaces.
// How about multiple spaces between two words?
// Reduce them to a single space in the reversed string.
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        s = s.trim();
        String[] str = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i = str.length - 1; i >= 0; i--) {
            if(str[i].length() > 0) {
                sb.append(str[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

