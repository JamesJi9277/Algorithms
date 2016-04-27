// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

// An example is the root-to-leaf path 1->2->3 which represents the number 123.

// Find the total sum of all root-to-leaf numbers.

// For example,

//     1
//    / \
//   2   3
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.
// Return the sum = 12 + 13 = 25.
//传统递归
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
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        doDFS(root, res, 0);
        return res.get(0);
    }
    private void doDFS(TreeNode root, List<Integer> res, int sum) {
        if(root == null) {
            return;
        }
        sum = 10 * sum + root.val;
        doDFS(root.left, res, sum);
        doDFS(root.right, res, sum);
        if(root.left == null && root.right == null) {
            res.set(0, res.get(0) + sum);
        }
    }
}
//divide and conquer
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        return getSum(root, 0);
    }
    private int getSum(TreeNode root, int sum) {
        if(root == null) {
            return sum;
        }
        int res = 0;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) {
            res += sum;
        }
        if(root.left != null) {
            res += getSum(root.left, sum);
        }
        if(root.right != null) {
            res += getSum(root.right, sum);
        }
        return res;
    }
}



