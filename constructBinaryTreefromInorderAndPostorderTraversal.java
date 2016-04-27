// Given inorder and postorder traversal of a tree, construct the binary tree.

// Have you met this question in a real interview? Yes
// Example
// Given inorder [1,2,3] and postorder [1,3,2], return a tree:

//   2
//  / \
// 1   3
// Note
// You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + len - 1);
        root.right = helper(inorder, rootIndex + 1, inEnd, postorder, postStart + len, postEnd - 1);
        return root;
    }
 }
 
public class Solution {
    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int inLength = inorder.length;
        int postLength = postorder.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inLength; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inLength - 1, postorder, 0, postLength - 1, map);
    }
    private TreeNode helper(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR, HashMap<Integer, Integer> map) {
        if(inL > inR || postL > postR) {
            return null;
        }
        if(inorder == null || postorder == null) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postR]);
        int rootPos = map.get(root.val);
        root.left = helper(inorder, inL, rootPos - 1, postorder, postL, postL + rootPos - inL - 1, map);
        root.right = helper(inorder, rootPos + 1, inR, postorder, postL + rootPos - inL, postR - 1, map);
        return root;
    }
}
