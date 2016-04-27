public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) {
            return res;
        }
        List<String> temp = new ArrayList<String>();
        findRes(s, res, temp, 0);
        return res;
    }
    private void findRes(String s, List<List<String>> res, List<String> temp, int pos) {
        if( pos == s.length()) {
            res.add(new ArrayList<String>(temp));
            return;
        }
        for(int i = pos + 1; i <= s.length(); i++) {//这里i的范围很重要
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




//second write and also contains a better Solution
public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) {
          return res;
        }
        List<String> temp = new ArrayList<String>();
        helper(s, res, temp, 0);
        return res;
    }
    private void helper(String s, List<List<String>> res, List<String> temp, int index) {
      if(index == s.length()) {
        res.add(new ArrayList<String>(temp));
        return;
      }
      String str = "";
      for(int i = index; i < s.length(); i++) {
          str += s.charAt(i);
          if(isPalindrome(str)) {
              temp.add(str);
              helper(s, res, temp, i + 1);
              temp.remove(temp.size() - 1);
          }
      }
    }
    private boolean isPalindrome(String s) {
      int start = 0;
      int end = s.length() - 1;
      for(int i = 0; start + i < end - i; i++) {
        if(s.charAt(start + i) != s.charAt(end - i)) {
          return false;
        }
      }
      return true;
    }
}





public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) {
          return res;
        }
        List<String> temp = new ArrayList<String>();
        helper(s, res, temp, 0);
        return res;
    }
    private void helper(String s, List<List<String>> res, List<String> temp, int index) {
      if(index == s.length()) {
        res.add(new ArrayList<String>(temp));
        return;
      }
      //因为都要进一位，所以i从index + 1开始
      for(int i = index + 1; i <= s.length(); i++) {
        String pre = s.substring(index, i);
        if(!isPalindrome(pre)) {
          continue;
        }
        temp.add(pre);
        helper(s, res, temp, i);
        temp.remove(temp.size() - 1);
      }
    }
    private boolean isPalindrome(String s) {
      int start = 0;
      int end = s.length() - 1;
      for(int i = 0; start + i < end - i; i++) {
        if(s.charAt(start + i) != s.charAt(end - i)) {
          return false;
        }
      }
      return true;
    }
}
