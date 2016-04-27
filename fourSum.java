public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
    	ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(num == null || num.length < 3)
    		return res;
    	Arrays.sort(num);
    	for(int i =num.length -1; i >2;i--)
    	{
    		if(i == num.length -1|| num[i] != num[i+1])
    		{
    			ArrayList<List<Integer>> curRes = threeSum(num,i-1, target - num[i]);
    			for(int j = 0; j<curRes.size();j++)
    				curRes.get(j).add(num[i]);
    			res.addAll(curRes);
    		}
    	}
    	return res;
    }
    private ArrayList<List<Integer>> threeSum(int[] num, int end, int target)
    {
    	ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    	//因为要顺序增加，所以说要从后往前扫，并且i>1,因为要保证至少3个数
    	for(int i = end; i>1;i--)
    	{
    		if(i ==end || num[i]!=num[i+1])
    		{
    			ArrayList<List<Integer>> curRes = twoSum(num, i-1,target-num[i]);
    			//将所有的存在结果都加上去
    			for(int j =0;j<curRes.size();j++)
    				curRes.get(j).add(num[i]);
    			res.addAll(curRes);
    		}
    	}
    	return res;
    }
    //前提是已经sort了
    private ArrayList<List<Integer>> twoSum (int[] num, int end, int target)
    {
    	ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
    	int l = 0;
    	int r = end;
    	while(l <r)
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
    		else if(num[l] + num[r] > target)
    			r--;
    		else l++;
    	}
    	return res;
    }
}