// Given two strings, find the longest common substring.

// Return the length of it.

// Have you met this question in a real interview? Yes
// Example
// Given A = "ABCD", B = "CBCE", return 2.

// Note
// The characters in substring should occur continuously in original string. This is different with subsequence.

// Challenge
// O(n x m) time and memory.
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || B == null) {
        	return 0;
        }
        if(A.length() == 0 || B.length() == 0) {
        	return 0;
        }
        int aLen = A.length();
        int bLen = B.length();
        int[][] res = new int[aLen + 1][bLen + 1];
        int max = 0;
        for(int i = 1; i <= aLen; i++) {
        	for(int j = 1; j <= bLen; j++) {
        		if(A.charAt(i - 1) == B.charAt(j - 1)) {
        			f[i][j] = f[i - 1][j - 1] + 1;
        		}
        		else
        			f[i][j] = 0;
        		max = Math.max(max, f[i][j]);
        	}
        }
        return max;
    }
}


public class Solution {
	public int longestCommonSubstring(String A, String B) {
		if(A == null || B == null) {
			return 0;
		}
		if(A.length() == 0 || B.length() == 0) {
			return 0;
		}
		int maxLen = 0;
		int aLen = A.length();
		int bLen = B.length();
		for(int i = 0; i < aLen; ++i) {
			for(int j = 0; j < bLen; ++j) {
				int len = 0;
				while(i + len < aLen && j + len < bLen && A.charAt(i + len) == B.charAt(j + len)) {
					len++;
					maxLen = Math.max(maxLen, len);
				}
			}
		}
		return maxLen;
	}
}