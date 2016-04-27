// Given an array of integers, 
// find if the array contains any duplicates. 
// Your function should return true if any value appears at least twice in the array, 
// and it should return false if every element is distinct.
// 思路比较简单明了，维护一个hashmap，出现过就加一，最后检查有没有count >1即可
public class Solution{
	public boolean containsDuplicate(int[] nums){
		if(nums == null || nums.length ==0)
			return false;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i =0; i< nums.length; i++)
		{
			if(map.containsKey(nums[i]))
				map.put(nums[i], map.get(nums[i])+1);
			else
				map.put(nums[i], 1);
		}
		for(int i =0; i< nums.length;i++)
		{
			if(map.get(nums[i]) > 1)
				return true;
		}
		return false;
	}
}