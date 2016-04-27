// Given a sorted (increasing order) array, Convert it to create a binary tree with minimal height.
//
// Have you met this question in a real interview? Yes
// Example
// Given [1,2,3,4,5,6,7], return
//
//      4
//    /   \
//   2     6
//  / \    / \
// 1   3  5   7
// Note
// There may exist multiple valid solutions, return any of them.
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
 //bug free
 public class Solution {
     /**
      * @param A: an integer array
      * @return: a tree node
      */
     public TreeNode sortedArrayToBST(int[] A) {
         // write your code here
         if(A == null || A.length == 0) {
           return null;
         }
         return helper(A, 0, A.length - 1);
     }
     private TreeNode helper(int[] A, int start, int end) {
       //注意这里是start > end， 没有等于号，因为如果只有一个元素的话，start是等于end的
       if(start > end) {
         return null;
       }
       int mid = start + (end - start) / 2;
       TreeNode root = new TreeNode(A[mid]);
       root.left = helper(A, start, mid - 1);
       root.right = helper(A, mid + 1, end);
       return root;
     }
 }
