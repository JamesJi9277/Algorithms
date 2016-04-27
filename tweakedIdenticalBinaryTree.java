Check two given binary trees are identical or not. Assuming any number of tweaks are allowed. A tweak is defined as a swap of the children of one node in the tree.

Have you met this question in a real interview? Yes
Example
    1             1
   / \           / \
  2   3   and   3   2
 /                   \
4                     4
are identical.

    1             1
   / \           / \
  2   3   and   3   4
 /                   \
4                     2
are not identical.
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
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
    	if(a == null && b == null) {
    		return true;
    	}
    	if(a == null || b == null) {
    		return false;
    	}
    	if(a.val != b.val) {
    		return false;
    	}
    	return (isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right) || 
    		(isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left)));
    }
}






































