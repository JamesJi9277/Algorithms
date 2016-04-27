// Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

// Note: If the given node has no in-order successor in the tree, return null.

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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
            return root;
        }
        if(root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left == null) ? root : left;
        }
    }
} 

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) {
            return null;
        }
        TreeNode res = null;
        while(root != null) {
            if(root.val > p.val) {
                res = root;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }
        return res;
    }
} 


public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) {
            return root;
        }
        TreeNode next = null;
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        doTraverse(res, root);
        for(int i = 0; i < res.size(); i++) {
            if(res.get(i) == p && i < res.size() - 1) {
                next = res.get(i + 1);
            }
        }
        return next;
    }
    private void doTraverse(ArrayList<TreeNode> res, TreeNode root) {
        if(root == null) {
            return ;
        }
        doTraverse(res, root.left);
        res.add(root);
        doTraverse(res, root.right);
    }
}

