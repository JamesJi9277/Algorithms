    // Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

// Have you met this question in a real interview? Yes
// Example
// Given the string = "abcdzdcab", return "cdzdc".

// Challenge
// O(n2) time is acceptable. Can you do it in O(n) time.
public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return new String();
        }
        String res = new String();
        if(s.length() == 1) {
            return s;
        }
        for(int i = 0; i < s.length() - 1; i++) {
            String temp = helper(s, i, i);
            if(temp.length() > res.length()) {
                res = temp;
            }
            temp = helper(s, i, i + 1);
            if(temp.length() > res.length()) {
                res = temp;
            }
        }
        return res;
    }
    private String helper(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}

//dp, On2 time, On2 space
public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        String res = "";
        int length = s.length();
        boolean[][] f = new boolean[length][length];
        for(int i = 0; i < length; i++) {
            f[i][i] = true;
        }
        for(int i = 0; i < length - 1; i++) {
            f[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for(int i = 2; i < length; i++) {
            for(int j = 0; i + j < length; j++) {
                f[j][i + j] = f[j + 1][i + j - 1] && (s.charAt(j)== s.charAt(i + j));
            }
        }
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(f[i][j] == true) {
                    String temp = s.substring(i, j + 1);
                    if(temp.length() > res.length()) {
                        res = temp;
                    }
                }
            }
        }
        return res;
    }
}

//dp, On2 time, On2 space
//太屌比了，注意dp构造的方向，是从对角线的方向来构造的，或者说从三角形的低端，自底向上来构造，最后来检测的时候也是一样，自底向上来检测
public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        boolean[][] isPalindrome = helper(s);
        int start = 0;
        int end = 0;
        int maxLength = 0;
        for(int j = 0; j < s.length(); j++) {
            for(int i = 0; i + j < s.length(); i++) {
                if(isPalindrome[i][i + j] && (j + 1) > maxLength) {
                    start = i;
                    end = i + j ;
                    maxLength = j + 1;
                }
            }
        }
        return s.substring(start, end + 1);
    }
    private boolean[][] helper(String s) {
        int length = s.length();
        boolean[][] f = new boolean[length][length];
        for(int i = 0; i < length; i++) {
            f[i][i] = true;
        }
        for(int i = 0; i < length - 1; i++) {
            f[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for(int j = 2; j < length; j++) {
            for(int i = 0; i + j < length; i++) {
                f[i][i + j] = f[i+1][j+i-1] && ( s.charAt(i) == s.charAt(i+j));
    //             if( f[i+1][j+i-1] && ( s.charAt(i) == s.charAt(i+j) ) ){
    //              f[i][i+j] = true;               
    //          }
            }
        }
        return f;
    }
}






//brute force
import java.util.HashMap;

public class longestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        int max = 0;
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if(isPalindrome(sub)) {
                    map.put(sub.length(), sub);
                    max = Math.max(max, sub.length());
                }
            }
        }
        return map.get(max);
    }
    private boolean isPalindrome(String s) {
        if(s == null || s.length() == 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        for(int i = 0; start + i < end - i; i++) {
            if(s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        longestPalindromeSubstring func = new longestPalindromeSubstring();
        String a = "abcbccbcbabddba";
        System.out.println("The longest is: " + func.longestPalindrome(a));
    }
}