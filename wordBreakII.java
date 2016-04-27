Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].


public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
    	List<String> res = new ArrayList<String>();
    	if(s == null || s.length() == 0 || wordDict == null) {
    		return res;
    	}
    	if(!canBreak(s, wordDict)) {
    		return res;
    	}
    	StringBuffer sb = new StringBuffer();
    	helper(s, wordDict, res, sb, 0);
    	return res;
    }
    private void helper(String s, Set<String> wordDict, List<String> res, StringBuffer sb, int start) {
    	if(start == s.length()) {
    		res.add(sb.toString().trim());
    		return;
    	}
    	for(int i = start; i < s.length(); i++) {
    		String temp = s.substring(start, i + 1);
    		if(wordDict.contains(temp)) {
    			int length = temp.length();
    			sb.append(" ");
    			sb.append(temp);
    			length++;
    			helper(s, wordDict, res, sb, i + 1);
    			sb.delete(sb.length() - length, sb.length());
    		}
    	}
    }
    private boolean canBreak(String s, Set<String> dict) {
    	if(s == null ) {
            return false;
        }
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        int maxLength = getMax(dict);
        for(int i = 1; i <= s.length(); i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(i - j> maxLength) {
                    break;
                }
                if(res[j] == true && dict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[s.length()];
    }
    private int getMax(Set<String> dict) {
    	int maxLength = 0;
    	for(String str : dict) {
    		maxLength = Math.max(maxLength, str.length());
    	}
    	return maxLength;
    }
}




public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // assume s is not null/empty and wordDict is not null/empty
        List<String> res = new ArrayList<String>();
        List<String> eachBreak = new ArrayList<String>();

        // 先用DP方法，即类似word break I的方法，得到所有子串是否能够被正确切分的boolean情况。
        // 调整一下，dp[i]表示后i个字符组成的子串能否被正确切分。
        int length = s.length();
        boolean[] dp = new boolean[length+1];
        dp[0] = true;
        for(int i = 1; i < length + 1; i++){
            for(int j = 0; j < i; j++){
                if( dp[j] && wordDict.contains(s.substring(length - i, length - j)) ){
                    dp[i] = true;
                    break;
                }
            }
        }
        // 注意我们做DFS的时候，是类似up - down的思路。因此，我们希望的是知道后面的i个字符是否能够被正确切分
        // 而我们上面DP的思路，记录的是前i个字符是否能够正确被切分。因此，需要做一下调整。重新定义一下状态，如上。
        dfs(s.length(), s, wordDict, res, eachBreak, dp, 0);
        return res;
    }
    
    private void dfs(int total, String s, Set<String> wordDict, List<String> res, List<String> eachBreak, boolean[] dp, int index){
        // recursive terminated situation
        if( s.length() == 0 ){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < eachBreak.size(); i++){
                if( i == eachBreak.size() - 1 ){
                    sb.append(eachBreak.get(i));
                }else{
                    sb.append(eachBreak.get(i));
                    sb.append(" ");
                }
            }
            res.add(sb.toString());
            return;
        }
        // 表示后面i个字符是否能够被正确切分
        if( dp[total - index] == false ){
            return;
        }

        // recursive body
        for(int i = 1; i <= s.length(); i++){
            // pruning
            if( !wordDict.contains(s.substring(0, i)) ){
                continue;
            }
            eachBreak.add(s.substring(0, i));
            if( i == s.length() ){
                // 注意这个分支不能用s.substring()否则会index out of boundary
                dfs(total, "", wordDict, res, eachBreak, dp, index + i);    
            }else{
                dfs(total, s.substring(i, s.length()), wordDict, res, eachBreak, dp, index + i);
            }
            eachBreak.remove(eachBreak.size()-1);
        }
        
    }
}