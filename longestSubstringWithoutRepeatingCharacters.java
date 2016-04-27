// Given a string, find the length of the longest substring without repeating characters.

// Have you met this question in a real interview? Yes
// Example
// For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

// For "bbbbb" the longest substring is "b", with the length of 1.

// Challenge
// O(n) time
//O(n^3) time, O(n) space
public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        if(s.length() == 1) {
            return 1;
        }
        for(int i = 0; i < s.length(); i++) {
            for(int j = i ; j < s.length(); j++) {
                String str = s.substring(i, j+1);
                if(!isUnique(str)) {
                    continue;
                }
                max = Math.max(max, str.length());
            }
        }
        return max;
    }
    private boolean isUnique(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                return false;
            }
            else {
                set.add(s.charAt(i));
            }
        }
        return true;
    } 
}
//On2time， On space
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int start = 0;
        int end = 0;
        HashSet<Character> set = new HashSet<Character>();
        while(end < s.length()) {
            if(!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
            }
            else {
                max = Math.max(max, end - start );
                set.clear();
                start++;
                end = start;
            }
        }
        max = Math.max(max, end - start );
        return max;
    }
}
//O(n) time, O(n) space
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if(!map.containsKey(s.charAt(right))) {
                map.put(c, right);
            }
            else {
                if(map.get(c) < left) {
                    map.put(c, right);
                }
                else {
                    max = Math.max(max, right - left);
                    left = map.get(c) + 1;
                    map.put(c, right);
                }
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}



public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int prev = -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                int temp = map.get(s.charAt(i));
                prev = Math.max(prev , temp);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - prev);
        }
        return max;
    }
}