// Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

// You have the following 3 operations permitted on a word:

// Insert a character
// Delete a character
// Replace a character
// Have you met this question in a real interview? Yes
// Example
// Given word1 = "mart" and word2 = "karma", return 3.

//要先直接讨论！=的情况
//f[i-1][j]指的是word1 进行delete操作，所以就是利用之前的结果然后加上一次delete操作
//f[i][j - 1]指的是word1进行add操作，加上一个数之后再跟word2的前j个比较
//f[i - 1][j - 1]指的是直接让word1的i替换成word2的j，所以也是直接用上之前的结果然后加上一个替换的1的复杂度
//综上，因为说的是最小操作，所以在三种类型的操作中选一个min，然后加上一次操作时间即可

public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) {
            return word1 == null ? word2.length() : word1.length();
        }
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] f = new int[length1 + 1][length2 + 1];
        for(int i = 0; i < length1 + 1; i++) {
            f[i][0] = i;
        }
        for(int j = 0; j < length2 + 1; j++) {
            f[0][j] = j;
        }
        for(int i = 1; i < length1 + 1; i++) {
            for(int j = 1; j < length2 + 1; j++) {
                if(word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                }
                else {
                    f[i][j] = f[i - 1][j - 1];
                }
            }
        }
        return f[length1][length2];
    }
}

public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) {
            return word1 == null ? word2.length() : word1.length();
        }
        int[] prev = new int[word2.length() + 1];
        int[] curr = new int[word2.length() + 1];
        for(int i = 1; i <= word2.length(); i++) {
            prev[i] = i;
        }
        for(int i = 1; i <= word1.length(); i++) {
            curr[0] = i;
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                }
                else {
                    curr[j] = Math.min(prev[j - 1], Math.min(curr[j - 1], prev[j])) + 1;
                }
            }
            prev = Arrays.copyOf(curr, curr.length);
        }
        return prev[word2.length()];
    }
}