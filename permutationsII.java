// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// For example,
// [1,1,2] have the following unique permutations:
// [1,1,2], [1,2,1], and [2,1,1].
public class Solution{
	public List<List<Integer>> permuteUnique(int[] num){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		boolean[] isUsed = new boolean[num.length];
		if(num == null || num.length == 0)
			return res;
		Arrays.sort(num);
		helper(num, isUsed, temp,res);
		return res;
	}
	private void helper(int[] num, boolean[] isUsed, List<Integer> temp, List<List<Integer>> res){
		if(temp.size() == num.length)
		{
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i =0; i<num.length;i++)
		{
			if(i >0 && !isUsed[i-1] && num[i] == num[i-1])
				continue;
			if(!isUsed[i])
			{
				isUsed[i] = true;
				temp.add(num[i]);
				helper(num,isUsed,temp,res);
				temp.remove(temp.size()-1);
				isUsed[i] = false;
			}
		}
	}
}
//second write,TLE
public class Solution{
	public List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<List<Integer>> res1 = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(nums);
		if(nums == null || nums.length == 0)
			return res;
		findUniquePermutation(nums, res, temp);
		for(int i =0;i<res.size();i++)
		{
			if(res1.contains(res.get(i)))
				continue;
			else
				res1.add(res.get(i));

		}
		return res1;
	}
	private void findUniquePermutation(int[] nums, List<List<Integer>> res, List<Integer> temp){
		if(temp.size() == nums.length)
		{
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i =0;i<nums.length;i++)
		{
			temp.add(nums[i]);
			findUniquePermutation(nums,res,temp);
			temp.remove(temp.size()-1);
		}
		return;
	}
}

//third write,bug free,注意在给定的模板上，加入一些根据题意的限定条件来修改模板
public class Solution{
	public List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		int[] isVisited = new int[nums.length];
		findPermutation(nums, res, temp, isVisited);
		return res;
	}
	private void findPermutation(int[] nums, List<List<Integer>> res, List<Integer> temp, int[] isVisited)
	{
		if(temp.size() == nums.length)
		{
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i =0;i<nums.length;i++)
		{
			if(isVisited[i] == 1 ||(i!=0&&nums[i] == nums[i-1]&&isVisited[i-1] == 0))
				continue;
			isVisited[i] =1;
			temp.add(nums[i]);
			findPermutation(nums,res,temp,isVisited);
			temp.remove(temp.size()-1);
			isVisited[i] = 0;
		}
	}
}


//fourth write
public class Solution{
	public List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		int[] isVisited = new int[nums.length];
		findPermutation(res,temp,nums, isVisited);
		return res;
	}
	private void findPermutation(List<List<Integer>> res, List<Integer> temp, int[] nums, int[] isVisited){
		if(temp.size() == nums.length)
		{
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i =0;i<nums.length;i++){
			if(isVisited[i] == 1 ||(i!=0&&nums[i] == nums[i-1]&&isVisited[i-1] == 0))
				continue;
			isVisited[i] =1;
			temp.add(nums[i]);
			findPermutation(res,temp,nums,isVisited);
			temp.remove(temp.size()-1);
			isVisited[i] =0;
		}
	}
}
