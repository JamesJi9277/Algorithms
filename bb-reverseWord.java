"the sky is blue"
"blue is sky the"
这个题的特殊case有只有一个单词，单词间有多个空格，
需要跟面试官讨论能不能够使用split函数
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
反向思维
import java.util.*;
public class Solution {
    public String reverseWords(String s) {
        // write your code
        if(s == null || s.length() == 0) {
            return new String();
        }
        s = s.trim();
        int right = s.length() - 1;
        int left = right;
        StringBuffer sb = new StringBuffer();
        while(left >= 0) {
            while(left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            sb.append(s.substring(left + 1, right + 1));
            sb.append(" ");
            while(left >= 0 && s.charAt(left) == ' ') {
                left--;
            }
            right = left;
        }
        return sb.toString().trim();
    }
}


正向思维
import java.util.*;
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return new String();
        }
        int left = 0;
        int right = 0;
        s = s.trim();
        StringBuffer sb = new StringBuffer();
        while(right < s.length()) {
            while(right < s.length() && s.charAt(right) != ' ') {
                right++;
            }
            sb.append(reverse(s.substring(left, right)));
            sb.append(" ");
            while(right < s.length() && s.charAt(right) == ' ') {
                right++;
            }
            left = right;
        }
        return reverse(sb.toString().trim());
    }
    private String reverse(String s) {
        StringBuffer sb = new StringBuffer(s);
        int start = 0;
        int end = sb.length() - 1;
        for(int i = 0; start + i < end - i; i++) {
            char c = sb.charAt(start + i);
            sb.setCharAt(start + i, sb.charAt(end - i));
            sb.setCharAt(end - i, c);
        }
        return sb.toString();
    }
}