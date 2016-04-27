Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Have you met this question in a real interview? Yes
Example
An example:

  2
 / \
1   3
   /
  4
   \
    5
The above binary tree is serialized as {2,1,3,#,#,4,#,#,5} (in level order).
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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root, long left, long right) {
        if(root == null) {
            return true;
        }
        if(left < root.val && root.val < right) {
            return helper(root.left, left, root.val) && helper(root.right, root.val, right);
        }
        return false;
    }
}


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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null) {
            return true;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        doInorderTraversal(res, root);
        for(int i = 0; i < res.size() - 1; i ++) {
            if(res.get(i) >= res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    private void doInorderTraversal(ArrayList<Integer> res, TreeNode root) {
        if(root == null) {
            return ;
        }
        doInorderTraversal(res, root.left);
        res.add(root.val);
        doInorderTraversal(res, root.right);
        return;
    }
}
