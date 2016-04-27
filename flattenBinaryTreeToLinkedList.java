Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

Have you met this question in a real interview? Yes
Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6
Note
Do not forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

Challenge
Do it in-place without any extra memory.

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
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode temp = root;
        while(temp.right != null) {
            temp = temp.right;
        }
        temp.right = right;
    }
}

public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null) {
                stack.push(temp.left);
            }
            temp.left = null;
            temp.right = (stack.isEmpty()) ? null : stack.peek();
        }
    }
}


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
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return ;
        }
        TreeNode dummy = new TreeNode(0);
        TreeNode prev = dummy;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null) {
                stack.push(temp.left);
            }
            prev.left = null;
            prev.right = temp;
            prev = prev.right;
        }
    }
}