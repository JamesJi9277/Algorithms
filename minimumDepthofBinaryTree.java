// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//recursive
 public class Solution{
 	public int minDepth(TreeNode root){
 		if(root == null)
 			return 0;
 		return findDepth(root);
 	}
 	private int findDepth(TreeNode root)
 	{
 		if(root == null)
 			return Integer.MAX_VALUE;
 		if(root.left == null && root.right == null)
 			return 1;
  		int leftMin = findDepth(root.left);
		int rightMin = findDepth(root.right);
  		return Math.min(leftMin, rightMin)+1;
 	}
 }
//recursive
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(root.left != null && root.right == null) {
            return left + 1;
        }
        else if(root.right != null && root.left == null) {
            return right + 1;
        }
        else return Math.min(left, right) + 1;
    }
}





//iterative


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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                //严格控制只有在左右都为空的时候才算作有效的
                if(temp.left == null && temp.right == null) {
                    min = Math.min(min, level);
                    return min;
                }
                if(temp.left != null) {
                    queue.offer(temp.left);
                }
                if(temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return 0;
    }
}
public class Solution{
	public int minDepth(TreeNode root){
		if(root == null)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(Integer.MAX_VALUE);
		getMin(stack, root,1);
		return stack.pop();
	}
	private void getMin(Stack<Integer> stack, TreeNode root, int depth)
	{
		if(root.left == null && root.right == null)
		{
			if(depth < stack.peek())
			{
				stack.pop();
				stack.push(depth);
				return;
			}
		}
		else if(root.left!= null && root.right == null)
			getMin(stack, root.left, depth+1);
		else if(root.left == null && root.right != null)
			getMin(stack, root.right, depth+1);
		else
		{
			getMin(stack, root.left, depth+1);
			getMin(stack, root.right, depth+1);
		}

	}
}






