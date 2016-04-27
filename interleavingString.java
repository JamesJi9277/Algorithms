// Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

// Have you met this question in a real interview? Yes
// Example
// For s1 = "aabcc", s2 = "dbbca"

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.
// Challenge
// O(n2) time or better
public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if(s1 == null || s2 == null || s3 == null) {
        	return false;
        }
        if(s1.length() + s2.length() != s3.length()) {
        	return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        f[0][0] = true;
        for(int i = 1; i <= len1; i++) {
        	//一再强调string判断要用equals而不是 ==
        	f[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for(int j = 1; j <= len2; j++) {
        	f[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
        }
        for(int i = 1; i <= len1; i++) {
        	for(int j = 1; j <= len2; j++) {
        		//这里注意boolean数组不像int数组可以初始化
        		f[i][j] = false;
        		if(s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
        			f[i][j] = f[i][j] || f[i - 1][j];
        		}
        		if(s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
        			f[i][j] = f[i][j] || f[i][j - 1];
        		}
        	}
        }
        return f[len1][len2];
    }
}
