// Given a complete binary tree, count the number of nodes.

// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
//TLE but correct
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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        doTraversal(root, res);
        return res.size();
    }
    private void doTraversal(TreeNode root, ArrayList<Integer> res) {
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null) {
                stack.push(temp.left);
            }
        }
    }
}
//
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//注意完全二叉树的定义，最后一层可以允许空的节点，但是必须是从左往右依次为空，所以当最左和最右相等时，就代表这个树是一个满二叉树
public class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = 0;
        TreeNode temp = root;
        while(temp != null) {
            left++;
            temp = temp.left;
        }
        int right = 0;
        temp = root;
        while(temp != null) {
            right++;
            temp = temp.right;
        }
        if(left == right) {
            return (1 << (left)) - 1;
        }
        else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}