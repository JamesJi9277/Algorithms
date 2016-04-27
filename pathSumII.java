// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]
public class Solution{
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		findPath(root, sum, res, temp);
		return res;
	}
	private void findPath(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
		if(root == null) {
			return;
		}
		temp.add(root.val);
		sum -= root.val;
		if(sum == 0&&root.left == null && root.right == null) {
			res.add(new ArrayList<Integer>(temp));	
		}
		findPath(root.left, sum, res, temp);
		findPath(root.right, sum , res, temp);
		temp.remove(temp.size()-1);
	}
}
