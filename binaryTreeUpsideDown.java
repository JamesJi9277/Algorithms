// Given a binary tree where all the right nodes are either leaf nodes with a sibling
// (a left node that shares the same parent node) or empty,
// flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes.
// Return the new root.
//top down approach
// We need to be very careful when reassigning current node’s left and right children.

//bottom up approach
// Although the code for the top-down approach seems concise,
// it is actually subtle and there are a lot of hidden traps
// if you are not careful. The other approach is thinking recursively in a bottom-up fashion.
// 	If we reassign the bottom-level nodes before the upper ones,
// we won’t have to make copies and worry about overwriting something.
// We know the new root will be the left-most leaf node, so we begin the reassignment here.
//因为这个题可以用递归来做，那么我同样也可以用非递归，用stack来模拟递归的步骤,方向是自顶向下
public class Solution {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if(root == null || root.left == null) {
			return root;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> stackR = new Stack<TreeNode>();
		TreeNode newRoot = null;
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node.left == null) {
				newRoot = node;
			}
			else if(!stackR.isEmpty() && stackR.peek() == node) {
				stackR.pop();
				node.left.right = node;
				node.left.left = node.right;
				node.left = null;
				node.right = null;
			}
			else {
				stack.push(node);
				stackR.push(node);
				stack.push(node.left);
			}
		}
		return newRoot;
	}
}
//bottom up， 因为使用了递归，所以说空间是Ologn
public class Solution {
	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if(root == null || root.left == null) {
			return root;
		}
		TreeNode newRoot = upsideDownBinaryTree(root.left);
		root.left.right = root;
		root.left.left = root.right;
		root.left = null;
		root.right = null;
		return newRoot;
	}
}

//top down and inplace， space O(1),这个做法很棒，
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) {
            return root;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        TreeNode parentRight = null;
        //我的退出条件是cur == null。也就是最后的newRoot是parent，然后cur = left也就是null了。所以最后返回的新root应该是parent
        //为了要把整个树走完并且反转彻底，一定要将cur == null作为退出条件，而我的parent相当于保留的是上一个cur的位置
        while(cur != null) {
        	//因为要对左指针进行重新指向，所以说要记录下下一个的左孩子
            TreeNode left = cur.left;
            cur.left = parentRight;
            parentRight = cur.right;
            cur.right = parent;
            parent = cur;
            cur = left;
        }
        return parent;
    }
}
