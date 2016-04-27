// Design an iterator over a binary search tree with the following rules:

// Elements are visited in ascending order (i.e. an in-order traversal)
// next() and hasNext() queries run in O(1) time in average.
// Have you met this question in a real interview? Yes
// Example
// For the following binary search tree, in-order traversal by using iterator is [1, 6, 10, 11, 12]

//    10
//  /    \
// 1      11
//  \       \
//   6       12
// Challenge
// Extra memory usage O(h), h is the height of the tree.
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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    //@param root: The root of binary tree.
    Stack<TreeNode> stack;
    TreeNode crt;
    public Solution(TreeNode root) {
        // write your code here
        stack = new Stack<TreeNode>();
        crt = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        if(crt != null || !stack.isEmpty()) {
            return true;
        }
        return false;
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        while(crt != null) {
            stack.push(crt);
            crt = crt.left;
        }
        TreeNode res = stack.pop();
        crt = res.right;
        return res;
    }
}

// Super Star: Extra memory usage O(1)
/// Morris traversal: O(1) space.
public class Solution {
    //@param root: The root of binary tree.
    TreeNode runner = null;
    
    public Solution(TreeNode root) {
        // write your code here
        runner = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        // using morris traversal we make sure
        // runner pointer will always not be null
        // untill traversal is done.
        return runner != null;
    }
    
    //@return: return next node
    public TreeNode next() {
        // first check left subtree, if null then we visit
        // current node and move to its right subtree.
        if (runner.left == null) {
            // visit runner
            TreeNode res = runner;
            runner = runner.right;
            return res;
        } else {
            // if left subtree not null, means we either
            // havent visit the substree or current node.
            // 
            // first while loop continues untill we find next
            // in-order element.
            while (runner.left != null) {
                // check whether predecessor's right pointer
                // points to current node.
                TreeNode pre = runner.left;
            
                while (pre.right != null && pre.right != runner) {
                    pre = pre.right;
                }
                
                if (pre.right == runner) {
                    // already visited left subtree. visit current node.
                    pre.right = null;
                    TreeNode res = runner;
                    runner = runner.right;
                    return res;
                } else {
                    // visit left subtree first.
                    pre.right = runner;
                    runner = runner.left;
                }
            }
            
            TreeNode res = runner;
            runner = runner.right;
            return res;
            
        }
    }

}