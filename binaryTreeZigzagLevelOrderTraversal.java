// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// Have you met this question in a real interview? Yes
// Example
// Given binary tree {3,9,20,#,#,15,7},

//     3
//    / \
//   9  20
//     /  \
//    15   7



// return its zigzag level order traversal as:

// [
//   [3],
//   [20,9],
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


public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include
     *          the zigzag level order traversal of its nodes' values
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean fromLeftToRight = true;
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
            if(!fromLeftToRight) {
                doReverse(arr);
            }
            res.add(arr);
            if(fromLeftToRight) {
                fromLeftToRight = false;
            }
            else{
                fromLeftToRight = true;
            }
        }
        return res;
    }
    private void doReverse(ArrayList<Integer> arr) {
        if(arr == null || arr.size() == 0) {
            return;
        }
        int start = 0;
        int end = arr.size() - 1;
        for(int i = 0; start + i < end - i; i++) {
            int temp = arr.get(start + i);
            arr.set(start+i, arr.get(end - i));
            arr.set(end - i, temp);
        }
        return;
    }
}



//second write
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include
     *          the zigzag level order traversal of its nodes' values
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
          return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean fromLeftToRight = true;
        while(!queue.isEmpty()) {

          if(fromLeftToRight == true) {
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
            fromLeftToRight = false;
          }
          else if(fromLeftToRight == false) {
              int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = size - 1; i >= 0; i--) {
              TreeNode cur = queue.poll();
              temp.add(0,cur.val);
              if(cur.left != null) {
                queue.offer(cur.left);
              }
              if(cur.right != null) {
                queue.offer(cur.right);
              }
            }
            res.add(temp);
            fromLeftToRight = true;
          }
        }
        return res;
    }
}
