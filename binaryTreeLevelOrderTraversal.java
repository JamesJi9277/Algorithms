// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// Have you met this question in a real interview? Yes
// Example
// Given binary tree {3,9,20,#,#,15,7},

//     3
//    / \
//   9  20
//     /  \
//    15   7


// return its level order traversal as:

// [
//   [3],
//   [9,20],
//   [15,7]
// ]
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

 //bug free~
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
             TreeNode temp = queue.poll();
             arr.add(temp.val);
             if(temp.left != null) {
                 queue.offer(temp.left);
             }
             if(temp.right != null) {
                 queue.offer(temp.right);
             }
            }
            res.add(arr);
        }
        return res;
    }
}
//recursive,这一题既然说了是要用递归来做，那么自然而然的，递归的过程就是不断的将问题缩小，这里所指的就是不断地按照斜对角线的
//顺序来添加元素
//     1
//    / \
//   2   5
//  / \   \
// 3   4   6
// 我先不断地去new arraylist进入res作为基础，然后在不断地以level递增顺序来添加元素进入res中每一个元素
// 顺序是 1 2 3 4 5 6
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        doTraverse(root, res, 0);
        return res;
    }
    private void doTraverse(TreeNode root, List<List<Integer>> res, int level) {
        if(root != null) {
            if(res.size() == level) {
                res.add(new ArrayList<Integer>());
            }
            res.get(level).add(root.val);
            doTraverse(root.left, res, level + 1);
            doTraverse(root.right, res, level + 1);
        }
    }
}

//second write
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
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
          ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
          return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
          int size = queue.size();
          ArrayList<Integer> temp = new ArrayList<Integer>();
          for(int i = 0; i < size; i++) {
            TreeNode cur = queue.poll();
            temp.add(cur.val);
            if(cur.left != null) {
              queue.offer(cur.left);
            }
            if(cur.right != null) {
              queue.offer(cur.right);
            }
          }
          res.add(temp);
        }
        return res;
    }
}
