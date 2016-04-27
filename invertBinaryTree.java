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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if(root == null) {
            return;
        }
        TreeNode newRoot = helper(root);
        root = newRoot;
    }
    private TreeNode helper(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode left = helper(root.right);
        TreeNode right = helper(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}


public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if(root == null) {
            return;
        }
        TreeNode newRoot = helper(root);
        root = newRoot;
        return;
    }
    private TreeNode helper(TreeNode root) {
        if(root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                TreeNode cur = temp.left;
                temp.left = temp.right;
                temp.right = cur;
                if(temp.left != null) {
                    queue.offer(temp.left);
                }
                if(temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return root;
    }
}