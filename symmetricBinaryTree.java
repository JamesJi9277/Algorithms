Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Have you met this question in a real interview? Yes
Example
    1
   / \
  2   2
 / \ / \
3  4 4  3
is a symmetric binary tree.

    1
   / \
  2   2
   \   \
   3    3
is not a symmetric binary tree.

Challenge
Can you solve it both recursively and iteratively?

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
time On, space Ologn
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}


time On, space On
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(root);
        q2.add(root);
        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode temp1 = q1.poll();
            TreeNode temp2 = q2.poll();
            if(temp1 == null && temp2 == null) {
                continue;
            }
            if(temp1 == null || temp2 == null || temp1.val != temp2.val) {
                return false;
            }
            q1.add(temp1.left);
            q1.add(temp1.right);
            q2.add(temp2.right);
            q2.add(temp2.left);
        }
        return q1.size() == q2.size();
    }
}