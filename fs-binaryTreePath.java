public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) {
            return res;
        }
        helper(root, res, "");
        return res;
    }
    private void helper(TreeNode root, List<String> res, String s) {
        if(root == null) {
            return;
        }
        //因为我每一步加的都是他妈的有效解，并不存在无效的，所以说不需要remove
        if(root.left == null && root.right == null) {
            s += (root.val + "");
            res.add(new String(s));
        }
        helper(root.left, res, s + root.val + "->");
        helper(root.right, res, s + root.val + "->");
    }
}