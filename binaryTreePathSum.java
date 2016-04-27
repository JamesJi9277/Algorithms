Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

A valid path is from root node to any of the leaf nodes.

Have you met this question in a real interview? Yes
Example
Given a binary tree, and target = 5:

     1
    / \
   2   4
  / \
 2   3
return

[
  [1, 2, 2],
  [1, 4]
]

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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        helper(root, res, temp, target);
        return res;
    }
    private void helper(TreeNode root, List<List<Integer>> res, List<Integer> temp, int target) {
        if(root == null) {
            return;
        }
        target -= root.val;
        temp.add(root.val);
        if(target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<Integer>(temp));
        }
        helper(root.left, res, temp, target);
        helper(root.right, res, temp, target);
        temp.remove(temp.size() - 1);
    }
}
