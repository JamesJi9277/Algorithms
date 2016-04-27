public class Solution {
	public List<List<Integer>> findPath(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null ) {
			return res;
		}
		List<Integer> temp = new ArrayList<Integer>();
		helper(root, res, temp);
		return res;
	}
	private void helper(TreeNode root, List<List<Integer>> res, List<Integer> temp) {
		if(root == null) {
			return;
		}
		if(root != null && root.val % 5 == 0) {
			temp.add(root.val);
			res.add(new ArrayList<Integer>(temp));
		}
		temp.add(root.val);
		helper(root.left,res, temp);
		helper(root.right, res, temp);
		temp.remove(remp.size() - 1);
	}
}