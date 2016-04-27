前序递归
public class Solution {
	public ArrayList<<Integer> order(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		helper(res, root);
		return res;
	}
	private void helper(ArrayList<Integer> res, TreeNode root) {
		res.add(root.val);
		helper(res, root.left);
		helper(res, root.right);
	}
}
前序非递归
public class Solution {
	public ArrayList<<Integer> order(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			res.add(temp.val);
			if(temp.right != null) {
				stack.push(temp.right);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
		return res;
	}
}
中序递归
public class Solution {
	public ArrayList<<Integer> order(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		helper(res, root);
		return res;
	}
	private void helper(ArrayList<Integer> res, TreeNode root) {
		helper(res, root.left);
		res.add(root.val);
		helper(res, root.right);
	}
}
中序非递归
public class Solution {
	public ArrayList<<Integer> order(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.isEmpty() || root != null) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode temp = stack.pop();
			res.add(temp.val);
			root = temp.right;
		}
		return res;
	}
}
后序递归
public class Solution {
	public ArrayList<<Integer> order(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		helper(res, root);
		return res;
	}
	private void helper(ArrayList<Integer> res, TreeNode root) {
		helper(res, root.left);
		helper(res, root.right);
		res.add(root.val);
	}
}
后序非递归
public class Solution {
	public ArrayList<<Integer> order(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		TreeNode prev = null;
		TreeNode cur = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			cur = stack.peek();
			if(prev == null || prev.left == cur || prev.right == cur) {
				if(cur.left != null) {
					stack.push(cur.left);
				}
				else if(cur.right != null) {
					stack.push(cur.right);
				}
			}
			else if(cur.left == prev) {
				if(cur.right != null) {
					stack.push(cur.right);
				}
			}
			else {
				stack.pop();
				res.add(cur.val);
			}
			prev = cur;
		}
		return res;
	}
}