// You have two every large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes. Create an algorithm to decide if T2 is a subtree of T1.

// Have you met this question in a real interview? Yes
// Example
// T2 is a subtree of T1 in the following case:

//        1                3
//       / \              / 
// T1 = 2   3      T2 =  4
//         /
//        4
// T2 isn't a subtree of T1 in the following case:

//        1               3
//       / \               \
// T1 = 2   3       T2 =    4
//         /
//        4
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
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if(T1 == null || T2 == null) {
            return (T2 == null) ? true : false;
        }
        return isSametree(T1, T2) || isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }
    private boolean isSametree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        if(t1.val != t2.val) {
            return false;
        }
        if(t1.left == null && t1.right == null && t2.left == null && t2.right == null && t1.val == t2.val) {
            return true;
        }
        return isSametree(t1.left, t2.left) && isSametree(t1.right, t2.right);
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
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if(T2 == null) {
            return true;
        } else if (T1 == null) {
            return false;
        }
        if(isSameTree(T1, T2)) {
            return true;
        }
        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }
    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        if(t1.val != t2.val) {
            return false;
        }
        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }
}
