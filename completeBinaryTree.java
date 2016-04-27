Check a binary tree is completed or not. A complete binary tree is not binary tree that every level is completed filled except the deepest level. In the deepest level, all nodes must be as left as possible. See more definition

Have you met this question in a real interview? Yes
Example
    1
   / \
  2   3
 /
4
is a complete binary.

    1
   / \
  2   3
   \
    4
is not a complete binary.


recursive




Challenge
Do it in O(n) time
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
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // Write your code here
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        ArrayList<String> res = bfsSerialize(root);
        int i = 0;
        for(i = 0 ; i < res.size(); i++) {
            if(res.get(i) != "#") {
                continue;
            }
            else {
                break;
            }
        }
        for(int j = i; j < res.size(); j++) {
            if(res.get(j) != "#") {
                return false;
            }
        }
        return true;
    }
    public ArrayList<String> bfsSerialize(TreeNode root) {
        ArrayList<String> res = new ArrayList<String>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(temp != null) {
                    res.add(temp.val + "");
                }
                else {
                    res.add("#");
                }
                if(temp != null) {
                    queue.offer(temp.left);
                    queue.offer(temp.right);
                }
            }
        }
        return res;
    }
    private int getHeight(TreeNode root) {
        int height = 0;
        while(root != null) {
            height++;
            root = root.left;
        }
        return height;
    }
}
