// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
public class Solution{
	public TreeNode sortedArrayToBST(int[] nums){
		TreeNode root = null;
		if(nums == null || nums.length == 0)
			return root;
		int left = 0;
		int right = nums.length -1;
		root = formBST(nums, left, right);
		return root;
	}
	private TreeNode formBST(int[] nums, int left, int right){
		if(left > right)
			return null;
		int mid = left + (right - left)/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = formBST(nums, left, mid-1);
		root.right = formBST(nums, mid+1, right);
		return root;
	}
}