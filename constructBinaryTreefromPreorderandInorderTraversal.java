// Given preorder and inorder traversal of a tree, construct the binary tree.

// Have you met this question in a real interview? Yes
// Example
// Given in-order [1,2,3] and pre-order [2,1,3], return a tree:

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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int rootIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, preStart + 1, preStart + len, inorder, inStart, inStart + len - 1);
        root.right = helper(preorder, preStart + len + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}




public class Solution {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
        	return null;
        }
        int preLength = preorder.length;
        int inLength = inorder.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inLength; i++) {
        	map.put(inorder[i], i);
        }
        return helper(preorder, 0, preLength - 1, inorder, 0, inLength - 1, map);
    }
    private TreeNode helper(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map) {
    	if(preL > preR ||inL > inR) {
    		return null;
    	}
    	if(preorder == null || inorder == null) {
    	    return null;
    	}
    	TreeNode root = new TreeNode(preorder[preL]);
    	int rootPos = map.get(root.val);
    	root.left = helper(preorder, preL + 1, rootPos - inL + preL, inorder, inL, rootPos - 1, map);
    	root.right = helper(preorder, preL + rootPos - inL + 1, preR, inorder, rootPos + 1, inR, map);
    	return root;
    }
}