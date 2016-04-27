Given a binary tree, return all root-to-leaf paths.

Have you met this question in a real interview? Yes
Example
Given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
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
        if(root.left == null && root.right == null) {
            s += (root.val + "");
            res.add(new String(s));
            return;
        }
        helper(root.left, res, s + (root.val + "" + "->"));
        helper(root.right, res, s + (root.val + "" + "->"));
    }
}
