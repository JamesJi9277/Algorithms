// Given a collection of candidate numbers (C) and a target number (T), 
// find all unique combinations in C where the candidate numbers sums to T.

// Each number in C may only be used once in the combination.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
// A solution set is: 
// [1, 7] 
// [1, 2, 5] 
// [2, 6] 
// [1, 1, 6] 
// 本题是回溯、递归，dfs，剪枝的组合，
// 这些都有涉及，难点和易错点都在剪枝，
// 还有容易出错的地方是在当前层内的循环体末尾，应当将解法复原
public class Solution{
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if(num == null || num.length == 0)
			return res;
		Arrays.sort(num);
		helper(0,num,target,temp,res);
		return res;
	}
	private void helper(int index, int[] num, int target, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res){
		if(target == 0)
		{
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		if(target < 0|| index >= num.length)
			return;
		for(int i =index;i<num.length;i++)
		{
			if(i > index && num[i] == num[i-1])
				continue;
			temp.add(num[i]);
			helper(i+1, num, target-num[i], temp, res);
			temp.remove(temp.size()-1);
		}
	}
}






public class Solution{
	public List<List<Integer>> combinationSum2(int[] num, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(num);
		helper(0,num, target, temp, res);
		return res;
	}
	private void helper(int start, int[] num, int target, List<Integer> temp, List<List<Integer>> res){
		if(target == 0)
		{
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i = start; i < num.length;i++)
		{
			if(num[i] < target)
			{
				temp.add(num[i]);
				helper(i+1,num,target-num[i],temp,res);
				temp.remove(temp.size()-1);
			}
		}
	}
}





