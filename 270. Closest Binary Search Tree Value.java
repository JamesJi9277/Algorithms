/*
直接暴力将这个树遍历一边即可*/
public class Solution {
    public int closestValue(TreeNode root, double target) {
        if(root == null) {
          return -1;
        }
        double minDiff = Double.POSITIVE_INFINITY;
        int res = 0;
        while(root != null) {
          if(minDiff > Math.abs((double)root.val - target)) {
            minDiff = Math.abs((double)root.val - target);
            res = root.val;
          }
          if((double)root.val == target) {
            return root.val;
          }
          else if((double)root.val < target) {
            root = root.right;
          }
          else {
            root = root.left;
          }
        }
        return res;
    }
}
