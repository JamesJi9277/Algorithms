Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
You may assume both pattern and str contains only lowercase letters.

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashSet<String> words = new HashSet<String>();
        return isMatch(pattern, str, map, words);
    }
    private boolean isMatch(String pattern, String str, HashMap<Character, String> map, Set<String> words) {
    if (pattern.length() == 0) {
            return (str.length() == 0);
        } else if (str.length() == 0) {
            return false;
        }
    	char c = pattern.charAt(0);
    	if(map.containsKey(c)) {
    		String word = map.get(c);
    		int length = word.length();
    		if((str.length() < length) || !str.substring(0, length).equals(word)) {
    			return false;
    		}
    		else {
    			return isMatch(pattern.substring(1), str.substring(length), map, words);
    		}
    	}
    	else {
    		for(int i = 1; i <= str.length(); i++) {
    			String word = str.substring(0, i);
    			if(!words.contains(word)) {
    				map.put(c, word);
    				words.add(word);
    				if(isMatch(pattern.substring(1), str.substring(i),map, words)) {
    					return true;
    				}
    				map.remove(c);
    				words.remove(word);
    			}
    		}
    		return false;
    	}
    }
}