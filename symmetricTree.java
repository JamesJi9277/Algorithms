// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

// For example, this binary tree is symmetric:

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        if(root.left == null || root.right == null) {
            return false;
        }
        return helper(root.left, root.right);
    }
    private boolean helper(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(root);
        queue2.offer(root);
        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode temp1 = queue1.poll();
            TreeNode temp2 = queue2.poll();
            if(temp1 == null && temp2 == null) {
                continue;
            }
            if(temp1 == null || temp2 == null || temp1.val != temp2.val) {
                return false;
            }
            queue1.offer(temp1.left);
            queue1.offer(temp1.right);
            queue2.offer(temp2.right);
            queue2.offer(temp2.left);
        }
        return true;
    }
}