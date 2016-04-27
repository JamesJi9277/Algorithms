// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

// Ensure that numbers within the set are sorted in ascending order.


// Example 1:

// Input: k = 3, n = 7

// Output:

// [[1,2,4]]

// Example 2:

// Input: k = 3, n = 9

// Output:

// [[1,2,6], [1,3,5], [2,3,4]]
public class Solution{
	public List<List<Integer>> combinationSum3(int k, int n){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		findSum(res,1,0,k,n,temp);
		return res;
	}
	private void findSum(List<List<Integer>> res, int cur, int sum, int k ,int n, List<Integer> temp){
		if(sum > n || temp.size() >k)
			return;
		if(temp.size() == k && sum == n)
			res.add(new ArrayList<Integer>(temp));
		else
		{
			for(int i = cur;i<=9;i++)
			{
				temp.add(i);
				findSum(res, i+1,sum+i,k,n,temp);
				temp.remove(temp.size()-1);
			}
		}
	}
}