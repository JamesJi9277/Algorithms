// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k < 1) {
            return 0;
        }
        List<Integer> res = new ArrayList<Integer>();
        doTraverse(root, res,k);
        return res.get(k - 1);
    }
    private void doTraverse(TreeNode root, List<Integer> res,int k) {
        //这里加上条件很重要
        if(root == null) {
            return;
        }
        if(res.size() == k) {
            return;
        }
        doTraverse(root.left, res,k);
        res.add(root.val);
        doTraverse(root.right, res,k);
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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k < 1) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            k--;
            if(k == 0) {
                return temp.val;
            }
            root = temp.right;
        }
        return 0;
    }
}