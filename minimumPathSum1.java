public class Solution {
	public int minSum(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return findMin(root, 0);
	}
	private int findMin(TreeNode root, int sum) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return root.val;
		}
		sum += root.val;
		int left = findMin(root.left, sum);
		int right = findMin(root.right, sum);
		return Math.min(left, right) + root.val;
	}
}

public class Solution {
	public int minSum(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = minSum(root.left);
		int right = minSum(root.right);
		if(root.left != null && root.right == null) {
			return left + root.val;
		}
		if(root.right != null && root.left == null) {
			return right + root.val;
		}
		return Math.min(left, right) + root.val;
	}
}