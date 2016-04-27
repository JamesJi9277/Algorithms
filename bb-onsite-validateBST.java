public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if(!((long)root.val > min && (long)root.val < max)) {
            return false;
        }
        return helper(root.left, min, (long)root.val) && helper(root.right, (long)root.val, max);
    }
}