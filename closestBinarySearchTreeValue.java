// Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//
// Note:
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest to the target.
//首先想到的是进行一个中序遍历找到一个arraylist，然后再对arraylist进行一个遍历返回值，这是一个naive的做法
//time Onlogn, space Ologn
Double.POSITIVE_INFINITY
Double.NEGATIVE_INFINITY
public class Solution {
  public int closestValue(TreeNode root, double target) {
    ArrayList<Double> res = new ArrayList<Double>();
    doTraverse(root, res);
    double minDiff = Double.POSITIVE_INFINITY;
    double result = 0;
    for(int i = 0; i < res.size(); i++) {
        if(minDiff > Math.abs(target - res.get(i))) {
            minDiff = Math.abs(target - res.get(i));
            result = res.get(i);
        }
    }
    return (int)result;
  }
  private void doTraverse(TreeNode root, ArrayList<Double> res) {
    if(root == null) {
      return ;
    }
    doTraverse(root.left, res);
    res.add((double)root.val);
    doTraverse(root.right, res);
  }
}
//在naive做法上面的升级就是用到了BST的性质，左右大小判断来进行traverse
//time O(logn), space O(1)
//我始终维护一个closeVal来记录下我比minDiff还要小的那个root节点的值，当我遍历完一遍树的时候
//不管怎么样我的closeVal和minDiff都有值，而我是通过BST的性质来减少不必要的搜索过程
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
    public int closestValue(TreeNode root, double target) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return root.val;
        }
        double minDiff = Double.POSITIVE_INFINITY;
        int closestVal = 0;
        while(root != null) {
            if(minDiff > Math.abs(root.val - target)) {
                minDiff = Math.abs(root.val - target);
                closestVal = root.val;
            }
            if((double)root.val == target) {
                return root.val;
            }
            else if((double)root.val < target) {
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        return closestVal;
    }
}
