Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Have you met this question in a real interview? Yes
Example
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        int i = 0;
        int j = 0;
        int star = -1;
        int mark = -1;
        while(i < s.length()) {
        	if(j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
        		i++;
        		j++;
        	}
        	else if(j < p.length() && p.charAt(j) == '*') {
        		star = j++;
        		mark = i;
        	}
        	else if(star != -1) {
        		j = star + 1;
        		i = ++mark;
        	}
        	else {
        		return false;
        	}
        }
        while(j < p.length() && p.charAt(j) == '*') {
        	j++;
        }
        return j == p.length();
     }
}