public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
        	return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        helper(root, sum, res, temp);
        return res;
    }
    private void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp) {
    	if(root == null) {
    		return;
    	}
    	sum -= root.val;
    	temp.add(root.val);//并不知道当前加入的解是不是有效的，而是当做有效的解加入
    	//判断加入的解是不是满足有效解的条件，如果有效就加入最终的解集
    	if(sum == 0 && root.left == null && root.right == null) {
    		res.add(new ArrayList<Integer>(temp));
    	}
    	//开始向左走和向右走，这是一个自然回溯的过程，并且定义了回溯的方向
    	helper(root.left, sum, res, temp);
    	helper(root.right, sum, res, temp);
    	//这里remove是因为当我发现走到了leaf时候，要返回去，
    	//不管我之前加入的leaf值是不是有效的，我们也要将之前添加进去的remove掉，才能够继续在别的路径找剩下的解
    	temp.remove(temp.size() - 1);
    }
}