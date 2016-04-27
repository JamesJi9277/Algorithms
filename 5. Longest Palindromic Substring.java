public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
          return "";
        }
        if(s.length() == 1) {
          return s;
        }
        String res = s.substring(0, 1);
        for(int i = 0; i < s.length() - 1; i++) {
          String temp = helper(s, i, i);
          if(temp.length() > res.length()) {
            res = temp;
          }
          temp = helper(s, i, i + 1);
          if(temp.length() > res.length()) {
            res = temp;
          }
        }
        return res;
    }
    private String helper(String s, int left, int right) {
      while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }
      return s.substring(left + 1, right);
    }
}
