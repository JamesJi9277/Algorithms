// Given an array of integers and an integer k, 
// find out whether there there are two distinct indices i and j in the array 
// such that nums[i] = nums[j] and the difference between i and j is at most k.
//brute force, time complexity O(n2)
public class Solution{
	public boolean containsNearbyDuplicate(int[] nums, int k){
		if(nums == null || nums.length == 0 || k<0)
			return false;
		for(int i =0; i<nums.length; i++)
		{
			for(int j =i+1; j< nums.length;j++)
			{
				if(nums[i] == nums[j])
				{
					if(j - i <= k)
						return true;
				}
			}
		}
		return false;
	}
}

//hash, time complexity O(n)
这题比较基础但是也不容易做对，首先应该考虑到的是利用hashmap来记录之前的index
当找到重复的value的时候，我要做的不仅仅是去更新length，还要将新的index去在map中更新
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
            	//更新结果
            	min = Math.min(min, i - map.get(nums[i]));
            }
            //更新map的index
            map.put(nums[i], i);
        }
        return (min <= k);
    }
}







