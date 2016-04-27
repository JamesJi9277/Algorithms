// Given two strings, find the longest common subsequence (LCS).

// Your code should return the length of LCS.

// Have you met this question in a real interview? Yes
// Example
// For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

// For "ABCD" and "EACB", the LCS is "AC", return 2.
public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || B == null) {
            return 0;
        }
        if(A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int aLen = A.length();
        int bLen = B.length();
        int f[][] = new int[aLen +1][bLen +1];
        for(int i = 0; i < aLen ; i++) {
        	for(int j = 0; j < bLen ; j++) {
        		f[i+1][j+1] = Math.max(f[i+1][j], f[i][j + 1]);
        		if(A.charAt(i) == B.charAt(j)) {
        			f[i+1][j+1] = f[i][j] + 1;
        		}
        	}
        }
        return f[aLen][bLen];
    }
}


//second write, bug free
public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A == null || B == null) {
            return 0;
        }
        if(A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int len1 = A.length();
        int len2 = B.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                if(A.charAt(i - 1) != B.charAt(j - 1)) {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
                else {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
            }
        }
        return f[len1][len2];
    }
}



