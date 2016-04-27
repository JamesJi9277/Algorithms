// Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.

// Have you met this question in a real interview? Yes
// Example
// Given binary search tree as follow, after Insert node 6, the tree should be:

//   2             2
//  / \           / \
// 1   4   -->   1   4
//    /             / \ 
//   3             3   6
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
 //recursive
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null) {
            return node;
        }
        if(node.val < root.val) {
            root.left = insertNode(root.left, node);
        }
        if(node.val > root.val) {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
}
//iterative
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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null) {
            return node;
        }
        TreeNode crt = root;
        while(crt != null) {
            if(crt.val > node.val) {
                if(crt.left == null) {
                    crt.left = node;
                    break;
                }
                crt = crt.left;
            }
            else {
                if(crt.right == null) {
                    crt.right = node;
                    break;
                }
                crt = crt.right;
            }
        }
        return root;
    }
}

