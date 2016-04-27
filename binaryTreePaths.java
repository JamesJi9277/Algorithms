// Given a binary tree, return all root-to-leaf paths.
//
// For example, given the following binary tree:
//
//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:
//
// ["1->2->5", "1->3"]
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
     public List<String> binaryTreePaths(TreeNode root) {
         List<String> res = new ArrayList<String>();
         if(root == null) {
           return res;
         }
         helper(root, "", res);
         return res;
     }
     private void helper(TreeNode root, String path, List<String> res) {
       if(root.left == null && root.right == null) {
         res.add(path + root.val);
         return;
       }
       if(root.left != null) {
         helper(root.left, path + root.val + "->", res);
       }
       if(root.right != null) {
         helper(root.right, path + root.val + "->", res);
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) {
            return res;
        }
        helper(root, res, "");
        return res;
    }
    private void helper(TreeNode root, List<String> res, String path) {
        if( root == null ){
            return;
        }
        path += root.val;
        if( root.left == null && root.right == null ){
            res.add(path);
            return;
        }
        helper(root.left, res, path + "->");
        helper(root.right, res, path + "->");
    }
}