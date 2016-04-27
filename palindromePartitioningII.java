// Given a string s, cut s into some substrings such that every substring is a palindrome.

// Return the minimum cuts needed for a palindrome partitioning of s.

// Have you met this question in a real interview? Yes
// Example
// For example, given s = "aab",

// Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if(s == null || s.length() == 0) {
        	return 0;
        }
        boolean[][] isPalindrome = getIsPalindrome(s);
        int[] f = new int[s.length() + 1];
        for(int i = 0; i <= s.length(); i++) {
        	f[i] = i - 1;
        }
        for(int i = 1; i <= s.length(); i++) {
        	for(int j = 0; j < i; j++) {
        		if(isPalindrome[j][i - 1]) {
        			f[i] = Math.min(f[i], f[j] + 1);
        		}
        	}
        }
        return f[s.length()];
    }
    private boolean[][] getIsPalindrome(String s) {
    	boolean[][] isPalindrome = new boolean[s.length()][s.length()];
    	for(int i = 0; i < s.length(); i++) {
    		isPalindrome[i][i] = true;
    	}
    	for(int i = 0; i < s.length() - 1; i++) {
    		isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
    	}
    	for(int i = 2; i < s.length(); i++) {
    		for(int start = 0; start + i < s.length(); start++) {
    			isPalindrome[start][start + i] = 
    			isPalindrome[start + 1][start + i - 1] && (s.charAt(start) == s.charAt(start + i));
    		}
            //最好写成下面的格式
            // if(res[start+1][start + i - 1] &&
            //     (s.charAt(start) == s.charAt(start + i))){
            //         res[start][start+i] = true;
            //     }
    	}
    	return isPalindrome;
    }
};

//second write, bug free
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if(s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPalindrome = findPalindrome(s);
        int[] res = new int[s.length() + 1];
        for(int i = 0; i <= s.length(); i++) {
            res[i] = i - 1;
        }
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(isPalindrome[j][i - 1])
                res[i] = Math.min(res[i], res[j] + 1);
            }
        }
        return res[s.length()];
    }
    private boolean[][] findPalindrome(String s) {
        boolean[][] res = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            res[i][i] = true;
        }
        for(int i = 0; i < s.length() - 1; i++) {
            res[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for(int i = 2; i < s.length(); i++) {
            for(int start = 0; i + start < s.length(); start++) {
                res[start][start+i] = res[start+1][start + i - 1] &&
                (s.charAt(start) == s.charAt(start + i));
            }
        }
        return res;
    }
};

//
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if(s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int length = s.length();
        boolean[][] isPalindrome = findPalindrome(s);
        int[] dp = new int[length + 1];
        dp[1] = 0;
        for(int i = 2; i < length + 1; i++) {
            dp[i] = i - 1;
            for(int j = 0; j < i; j++) {
                if(isPalindrome[j][i - 1]) {
                    if(j == 0) {
                        dp[i] = 0;
                    }
                    else {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[length];
    }
    private boolean[][] findPalindrome(String s) {
        boolean[][] res = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            res[i][i] = true;
        }
        for(int i = 0; i < s.length() - 1; i++) {
            res[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for(int i = 2; i < s.length(); i++) {
            for(int start = 0; i + start < s.length(); start++) {
                res[start][start+i] = res[start+1][start + i - 1] &&
                (s.charAt(start) == s.charAt(start + i));
            }
        }
        return res;
    }
};
//
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if(s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int length = s.length();
        boolean[][] isPalindrome = findPalindrome(s);
        int[] dp = new int[length + 1];
        dp[1] = 0;
        for(int i = 2; i < length + 1; i++) {
            dp[i] = i - 1;
            if(isPalindrome[0][i - 1]) {
                dp[i] == 0;
                continue;
            }
            for(int j = 1; j < i; j++) {
                if(isPalindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[length];
    }
    private boolean[][] findPalindrome(String s) {
        boolean[][] res = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            res[i][i] = true;
        }
        for(int i = 0; i < s.length() - 1; i++) {
            res[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for(int i = 2; i < s.length(); i++) {
            for(int start = 0; i + start < s.length(); start++) {
                res[start][start+i] = res[start+1][start + i - 1] &&
                (s.charAt(start) == s.charAt(start + i));
            }
        }
        return res;
    }
};



public class Solution {
    public int minCut(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) {
            return 0;
        }
        List<String> temp = new ArrayList<String>();
        findRes(s, res, temp, 0);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < res.size(); i++) {
            min = Math.min(min, res.get(i).size() - 1);
        }
        return min;
    }
    private void findRes(String s, List<List<String>> res, List<String> temp, int pos) {
        if( pos == s.length()) {
            res.add(new ArrayList<String>(temp));
            return;
        }
        for(int i = pos + 1; i <= s.length(); i++) {
            String prefix = s.substring(pos, i);
            if(!isPalindrome(prefix)) {
                continue;//continue skip current loop
            }
            temp.add(prefix);
            findRes(s, res, temp, i);
            temp.remove(temp.size() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}