// Given a string S and a string T, count the number of distinct subsequences of T in S.

// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

// Have you met this question in a real interview? Yes
// Example
// Given S = "rabbbit", T = "rabbit", return 3.

// Challenge
// Do it in O(n2) time and O(n) memory.

// O(n2) memory is also acceptable if you do not know how to optimize memory.
public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if(S == null || T == null) {
            return 0;
        }
        if(S.length() == 0 || T.length() == 0) {
            return 0;
        }
        int len1 = S.length();
        int len2 = T.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        for(int i = 0; i < len1; i++) {
            f[i][0] = 1;
        }
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(S.charAt(i - 1) != T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j];
                }
                else {
                    f[i][j] = f[i - 1][j] + f[i - 1][j - 1];
                }
            }
        }
        return f[len1][len2];
    }
}

