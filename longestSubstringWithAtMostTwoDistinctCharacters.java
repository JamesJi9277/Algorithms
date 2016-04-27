Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
brute force ,TLE
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) {
        	return 0;
        }
        if(s.length() == 1 || s.length() == 2) {
        	return s.length();
        }
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
        	for(int j = i + 1; j <= s.length(); j++) {
        		String temp = s.substring(i, j);
        		if(isValid(temp)) {
        			max = Math.max(max, temp.length());
        		}
        	}
        }
        return max;
    }
    private boolean isValid(String s) {
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	for(int i = 0; i < s.length(); i++) {
    		if(map.containsKey(s.charAt(i))) {
    			map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
    		}
    		else {
    			map.put(s.charAt(i), 1);
    		}
    	}
    	return map.size() < 3;
    }
}

优化，双指针，时间On2空间On
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0) {
        	return 0;
        }
        if(s.length() == 1 || s.length() == 2) {
        	return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int max = 0;
        while(end < s.length()) {
        	if(!map.containsKey(s.charAt(end)) && map.size() < 2) {
        		map.put(s.charAt(end), 1);
        		end++;
        		max = Math.max(max, end - start);
        	}
        	else if(map.containsKey(s.charAt(end))) {
        		map.put(s.charAt(end), map.get(s.charAt(end)) + 1);
        		end++;
        		max = Math.max(max, end - start);
        	}
        	else {
        		start++;
        		end = start;
        		map.clear();
        	}
        }
        return max;
    }
}