//不同于2Sum，这个题brute force时间复杂度为O（n^3），对于有可能是无序并且可能重复的数组
//用hash来做不是最佳，因为有可能有duplicate存在，所以考虑先将数组排序，然后采用夹逼的方法来做
//时间复杂度为O（n^2 +nlogn）= O(n^2)
public class Solution{
	public ArrayList<List<Integer>> threeSum(int[] num){
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num == null || num.length < 3)
			return res;
		Arrays.sort(num);//记住是Arrays.sort（）而不是Array
		for(int i = num.length -1; i>=2; i--)
		{
			if( i < num.length -1 && num[i] == num[i +1])
				continue;
			ArrayList<List<Integer>> curRes = twoSum(num, i-1, -num[i]);
			//curRes是一个一个数组，具体看private的返回格式，然后需要将num[i]添加到符合条件的所有数组中
			for(int j =0;j<curRes.size();j++)
				curRes.get(j).add(num[i]);
			res.addAll(curRes);
		}
		return res;
	}
	private ArrayList<List<Integer>> twoSum(int[] num, int end, int target){
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num == null || num.length <2)
			return res;
		int l =0;
		int r =end;
		while(l < r)
		{
			if(num[l] + num[r] == target)
			{
				ArrayList<Integer> item = new ArrayList<Integer>();
				item.add(num[l]);
				item.add(num[r]);
				res.add(item);
				l++;
				r--;
				while(l < r && num[l] == num[l-1])
					l++;
				while(l<r&&num[r] == num[r+1])
					r--;
			}
			else if (num[l] + num[r] > target)
				r--;
			else
				l++;
		}
		return res;
	}
}