/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.*/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<Character>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < s.length()) {
            if(right < s.length() && set.contains(s.charAt(right))) {
                right++;
            }
            else if(right < s.length() && !set.contains(s.charAt(right))) {
                if(set.size() < k) {
                    set.add(s.charAt(right));
                    right++;
                }
                else {
                    max = Math.max(max, right - left);
                    set.clear();
                    left++;
                    right = left;
                }
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}
