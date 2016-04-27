/*
递归来添加*/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n < 1) {
          return res;
        }
        helper(res, "", n, n);
        return res;
    }
    private void helper(List<String> res, String s, int left, int right) {
      if(right < left) {
        return;
      }
      if(left == 0 && right == 0) {
        res.add(new String(s));
        return;
      }
      if(left > 0) {
          helper(res, s + "(", left - 1, right);
      }
      if(right > 0) {
          helper(res, s + ")", left, right - 1);
      }
    }
}
