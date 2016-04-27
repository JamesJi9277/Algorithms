// Given a binary tree, find its maximum depth.

// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Have you met this question in a real interview? Yes
// Example
// Given a binary tree as follow:

//   1
//  / \ 
// 2   3
//    / \
//   4   5
// The maximum depth is 3.
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
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
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
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null) {
        	return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        findHeight(root, 0, stack);
        return stack.pop();
    }
    private void findHeight(TreeNode root, int height, Stack<Integer> stack) {
    	if(root == null) {
    		if(height > stack.peek()) {
    			stack.push(height);
    		}
    		return;
    	}
    	findHeight(root.left, height + 1, stack);
    	findHeight(root.right, height + 1, stack);
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
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null) {
        	return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int height = 0;
        int maxHeight = Integer.MIN_VALUE;
        while(!queue.isEmpty()) {
        	height++;
        	int size = queue.size();
        	for(int i =0; i < size; i++) {
        		TreeNode temp = queue.poll();
        		if(temp.left != null) {
        			queue.offer(temp.left);
        		}
        		if(temp.right != null) {
        			queue.offer(temp.right);
        		}
        		if(temp.left == null && temp.right == null) {
        			maxHeight = Math.max(height, maxHeight);
        		}
        	}
        }
        return maxHeight;
    }
}
