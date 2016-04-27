// Given a binary tree, return the inorder traversal of its nodes' values.

// Have you met this question in a real interview? Yes
// Example
// Given binary tree {1,#,2,3},

//    1
//     \
//      2
//     /
//    3
 

// return [1,3,2].

//recursive
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null ) {
            return res;
        }
        ArrayList<Integer> resLeft = inorderTraversal(root.left);
        res.addAll(resLeft);
        res.add(root.val);
        ArrayList<Integer> resRight = inorderTraversal(root.right);
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //stack.push(root);
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode temp = stack.pop();
            res.add(temp.val);
            root = temp.right;//这里是一个进行右子树探索的过程，假设右子树不为空，
            //那么就继续进入了while(root != null)的判断，不然的话就还是直接进行上一层while循环的stack.pop()
        }
        return res;
    }
}
//这里也可以直接写成以下的形式
root = Stack.pop();
res.add(root.val);
root = root.right;


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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        doTraverse(res, root);
        return res;
    }
    private void doTraverse(ArrayList<Integer> res, TreeNode root) {
        if(root == null) {
            return;
        }
        doTraverse(res, root.left);
        res.add(root.val);
        doTraverse(res, root.right);
    }
}


