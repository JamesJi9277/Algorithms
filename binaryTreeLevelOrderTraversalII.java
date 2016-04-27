// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

// Have you met this question in a real interview? Yes
// Example
// Given binary tree {3,9,20,#,#,15,7},

//     3
//    / \
//   9  20
//     /  \
//    15   7


// return its bottom-up level order traversal as:

// [
//   [15,7],
//   [9,20],
//   [3]
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


public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
            res.add(0, arr);
        }
        return res;
    }
}




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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
          res.add(0, temp);
        }
        return res;
    }
}
