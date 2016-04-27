Given a binary tree, find the maximum path sum from root.

The path may end at any node in the tree.

Have you met this question in a real interview? Yes
Example
Given the below binary tree:

  1
 / \
2   3
return 4. (1->3)

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
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(Integer.MIN_VALUE);
        helper(root, 0, stack);
        return stack.peek();
    }
    private void helper(TreeNode root, int sum, Stack<Integer> stack) {
        if(root == null) {
            return;
        }
        sum += root.val;
        if(sum > stack.peek()) {
            stack.pop();
            stack.push(sum);
        }
        helper(root.left, sum, stack);
        helper(root.right, sum, stack);
    }
}
