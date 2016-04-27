Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)
Have you met this question in a real interview? Yes
Example
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

首先理解题意，
'a'匹配'a'是肯定的
任意字母匹配'.'
0到多个相同字符x，对应"x*"，比起普通正则，这里多出来一个前缀x，x表示相同的字符提取出来一个，比如说aaaaaab对应a*b
还需要注意的一个地方是"*"的贪婪性，贪婪性有一个限度，比如aaaaa不能写成a*，而是说要写成a*a

正则表达式如果期望着一个一个字符的去匹配是不现实的，而这个匹配的问题，容易转换成匹配了一部分，看剩下的匹配情况
这就很好的把一个大的问题转换成了规模较小的问题
如果pattern是x*类型的话，那么pattern每次要两个两个的减少，否则就是一个一个的减少
public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if(p.length() == 0) {
        	return s.length() == 0;
        }
        //length == 1 is the case easy to forget
        if(p.length() == 1) {
        	return (s.length() == 1) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }
        //next char is not '*': must match current char
        if(p.charAt(1) != '*') {
        	if(s.length() == 0) {
        		return false;
        	}
        	else {
        		return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
        	}
        }
        else {
        	//next char is *
        	while(s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
        		if(isMatch(s, p.substring(2))) {
        			return true;
        		}
        		s = s.substring(1);
        	}
        	return isMatch(s, p.substring(2));
        }
    }
}