public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
          return 0;
        }
        HashSet<Character> set = new HashSet<Character>();
        int left = 0;
        int right = 0;
        int res = 0;
        while(right < s.length()) {
          if(right < s.length() && !set.contains(s.charAt(right))) {
            set.add(s.charAt(right));
            right++;
          }
          else {
            res = Math.max(res, right - left);
            left++;
            right = left;
            set.clear();
          }
        }
        res = Math.max(res, right - left);
        return res;
    }
}

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
          return 0;
        }
        int prev = -1;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
          if(map.containsKey(s.charAt(i))) {
            prev = Math.max(prev, map.get(s.charAt(i)));
          }
          map.put(s.charAt(i), i);
          res = Math.max(res, i - prev);
        }
        return res;
    }
}
