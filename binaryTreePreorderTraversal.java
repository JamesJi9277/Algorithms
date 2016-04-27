// Given a binary tree, return the preorder traversal of its nodes' values.

// Have you met this question in a real interview? Yes
// Example
// Given binary tree {1,#,2,3}:

// 1
//  \
//   2
//  /
// 3
// return [1,2,3].
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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        res.add(root.val);
        ArrayList resLeft = preorderTraversal(root.left);
        res.addAll(resLeft);
        ArrayList resRight = preorderTraversal(root.right);
        res.addAll(resRight);
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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            TreeNode tempNode = stack.pop();
            temp.add(tempNode.val);
            if(tempNode.right != null) {
                stack.push(tempNode.right);
            }
            if(tempNode.left != null) {
                stack.push(tempNode.left);
            }
            res.addAll(temp);
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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        doTraverse(root, res);
        return res;
    }
    private void doTraverse(TreeNode root, ArrayList<Integer> res) {
        if(root == null) {
            return ;
        }
        res.add(root.val);
        doTraverse(root.left, res);
        doTraverse(root.right, res);
        return;
    }
}
