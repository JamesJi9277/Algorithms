// Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

// Have you met this question in a real interview? Yes
// Example
// Given s = "lintcode", dict = ["lint", "code"].

// Return true because "lintcode" can be break as "lint code".
// 求解词典中最大单词长度，时间复杂度为词典长度乘上最大单词长度 O(L_D \cdot L_w)O(L
// ​D
// ​​ ⋅L
// ​w
// ​​ )
// 词典中找单词的时间复杂度为 O(1)O(1)(哈希表结构)
// 两重 for 循环，内循环在超出最大单词长度时退出，故最坏情况下两重 for 循环的时间复杂度为 O(n L_w)O(nL
// ​w
// ​​ ).
// 故总的时间复杂度近似为 O(n L_w)O(nL
// ​w
// ​​ ).
//好好理解
public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here  
        if(s == null ) {
            return false;
        }
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        int maxLength = getMaxLength(dict);
        for(int i = 1; i <= s.length(); i++) {
        	//这里之所以要从后往前开始，是因为如果从前往后，即使i - j>maxLength，我后面单词还是可以被切分的
        	//所以说这样子所没有意义，所以要从后往前开始，遇到了大于最大单词长度的我就break，相当于是一个单词一个单词的去探索
            //而且这样也避免了去判断是由一个或者多个单词组成的情况，只从后面作为一个新的单词去添加，然后不管前面的步骤
            //只去管前面的结果是不是true就好了
            for(int j = i - 1; j >= 0; j--) {
                if(i - j> maxLength) {
                    break;
                }
                if(res[j] == true && dict.contains(s.substring(j, i))) {//写成j，不会漏掉j == 0的特殊情况
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for(String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}


//nine chapter solution
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0) {
            return true;
        }
        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(i - j > maxLength) {
                    break;
                }
                String word = s.substring(j, i);
                if(canSegment[j] && dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }
        return canSegment[s.length()];
    }
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for(String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}



//write by myself, TLE，因为缺少了剪枝过程的判断
public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here   
        //f[i]表示前i个能不能完美的break
        if(s == null || s.length() == 0) {
            return false;
        }
        if(dict == null || dict.size() == 0) {
            return false;
        }
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i = 1; i <= f.length; i++) {
            for(int j = 0; j < i; j++) {
                f[i] = f[j] && isValid(s.substring(j + 1, i), dict);
            }
        }
        return f[s.length()];
    }
    private boolean isValid(String str, Set<String> dict) {
        if(str == null) {
            return false;
        }
        if(dict.contains(str)) {
            return true;
        }
        return false;
    }
}



public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null) {
            return false;
        }

        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if(f[j] && wordDict.contains(word)) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
