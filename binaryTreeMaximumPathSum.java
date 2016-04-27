// Given a binary tree, find the maximum path sum.

// The path may start and end at any node in the tree.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(Integer.MIN_VALUE);
        helper(root, res);
        return res.get(0);
    }
    private int helper(TreeNode root, ArrayList<Integer> res) {
        if(root == null) {
            return 0;
        }
        int leftMax = helper(root.left, res);
        int rightMax = helper(root.right, res);
        int sum = root.val + ((leftMax >= 0) ? leftMax : 0) + ((rightMax >= 0) ? rightMax : 0);
        if(sum >= res.get(0)) {
            res.set(0, sum);
        }
        return root.val + Math.max(leftMax, Math.max(rightMax, 0));
    }
}

