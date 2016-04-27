// Given a binary tree, return the postorder traversal of its nodes' values.

// Have you met this question in a real interview? Yes
// Example
// Given binary tree {1,#,2,3},

//    1
//     \
//      2
//     /
//    3
 

// return [3,2,1].
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        ArrayList<Integer> resLeft = postorderTraversal(root.left);
        res.addAll(resLeft);
        ArrayList<Integer> resRight = postorderTraversal(root.right);
        res.addAll(resRight);
        res.add(root.val);
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) {
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(0,temp.val);
            if(temp.left!=null) {
                stack.push(temp.left);
            }
            if(temp.right != null) {
                stack.push(temp.right);
            }
        }
        return res;
    }
}
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null; // previous traversed node
        TreeNode cur = root;
        if(root == null) {
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty()) {
            cur = stack.peek();
            if(prev == null || prev.left == cur || prev.right == cur) {
                if(cur.left != null) {
                    stack.push(cur.left);
                }
                else if (cur.right != null) {
                    stack.push(cur.right);
                }
            }
            else if(cur.left == prev) {
                if(cur.right != null) {
                    stack.push(cur.right);
                }
            }
            else {
                res.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return res;
    }
}


public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        Collections.reverse(res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        res.add(root.val);
        helper(root.right, res);
        helper(root.left, res);
    }
}
// Binary Tree的后序post-order非递归遍历的分析(传统方法)：
// http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
// 	上面link中的代码为传统的二叉树后序非递归遍历的方法，下面对其做一些主要解释帮助理解记忆代码！！
// (1). 该非递归后序遍历的方法实际上是模拟的递归后序遍历的过程，这个很关键！
// (2). 递归遍历的过程中，涉及到的是每一次递归到某一层的某一个node以及某一层某一个node的添加入解集。
// 同理，我们非递归遍历中涉及到的是每一次迭代到某一层的某一个node以及某一层某一个node的添加入解集。
// (3). 根据 (2), 我们引入两个重要变量previously visited node (prev) 和current node (crt). 
// 他们其实都是指代的某一层的某一个node只是我们同时跟踪之前和当前的两个nodes. 
// 这其实就是类似递归方法中每一次递归到的那一个root node.
// (4). Current node始终都是堆栈的peek element, 
// 其中为了让迭代启动起来，提前将最最最最top的root node压入堆栈, 
// 然后它将作为迭代开始后的第一个current node (此时的prev是null). 
// 注意：类似先序非递归遍历，迭代的终止条件是stack为空。
(5). 我们知道递归过程中如下图所示，都是先不断的沿着left child root nodes going down. 当到达某一个node n时，如果其left child node没有了的话，我们还会去看其right child node是否存在如果有的话我们仍然要继续going down下去重复上面的过程。(6). 根据 (5), 我们每一次迭代都check the previously visited node. If the current node is the left or right child of the previous node (或者特殊情况是最最top的node为current node时，此时的prev node是null时), then keep going down the tree, and add left/right node to stack when applicable. (7). 每一次迭代过程的末尾，要完成prev = crt的更新工作。
(8). When there are no children for current node, i.e. the current node is a leaf, pop it from the stack. 
(9). 我们知道递归的过程中，当完成了一次value加入解集后，递归函数会结束自然返回。那么它有可能是返回到上一层的dfs(root.left,results)后，也有可能是返回到上一层的dfs(root.right,results)后. 而在非递归过程中，这个自然返回的过程体现在，我们的prev node和crt node调换了角色即此时的prev node是下层的node, 而crt node是上层的node.




