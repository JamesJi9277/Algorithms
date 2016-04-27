Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.


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
    public int longestConsecutive(TreeNode root) {
     
        if( root == null ){
            return 0;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1); // at least 1
        helper(root, res);
        return res.get(0);
    }


    private int helper(TreeNode root, ArrayList<Integer> res){

        if( root  == null ){
            return 0;
        }
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int max = 1;
        int tmpLeft = 0, tmpRight = 0;
        if( root.left != null ){
            if( root.left.val - root.val == 1 ){
                tmpLeft = left + 1;
            }
        }

        if( root.right != null ){
            if( root.right.val - root.val == 1 ){
                tmpRight = right + 1;
            }
        }

        max = Math.max(Math.max(tmpLeft, tmpRight), max);
        if( max > res.get(0) ){
            res.set(0, max);
        }
        return max;
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
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) {
          return 0;
        }
        helper(root);
        return res;
    }
    private int helper(TreeNode root) {
      if(root == null) {
        return 0;
      }
      int left = helper(root.left);
      int right = helper(root.right);
      int max = 1;
      if(left > 0) {
        if(root.val + 1 == root.left.val) {
          max = Math.max(left + 1, max);
        }
      }
      if(right > 0) {
        if(root.val + 1 == root.right.val) {
          max = Math.max(right + 1, max);
        }
      }
      res = Math.max(res, max);
      return max;
    }
}