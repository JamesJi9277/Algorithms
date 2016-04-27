// Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

// Try to solve it in linear time/space.

// Return 0 if the array contains less than 2 elements.

// You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
// Suppose there are N elements and they range from A to B.

// Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]

// Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], 
// then we will have at most num = (B - A) / len + 1 of bucket

// for any number K in the array, we can easily find out which bucket it belongs by calculating loc = (K - A) / len 
// and therefore maintain the maximum and minimum elements in each bucket.

// Since the maximum difference between elements in the same buckets will be at most len - 1, 
// so the final answer will not be taken from two elements in the same buckets.

// For each non-empty buckets p, find the next non-empty buckets q, then q.min - p.max could be the potential answer to the question. 
// Return the maximum of all those values.
public class Solution{
	public int maximumGap(int[] num){
		if(num == null||num.length <2)
			return 0;
		int n = num.length;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i =0; i<n;i++)
		{
			max = Math.max(max,num[i]);
			min = Math.min(min,num[i]);
		}
		int range = max - min;
		int bukitLength = (int)Math.ceil((double)range/(double)(n-1));
		int bukitNum = range/ bukitLength +1;
		ArrayList<Integer> bukitMax = new ArrayList<Integer>();
		ArrayList<Integer> bukitMin = new ArrayList<Integer>();
		for(int i =0;i<bukitNum;i++)
		{
			bukitMax.add(Integer.MIN_VALUE);
			bukitMin.add(Integer.MAX_VALUE);
		}
		for(int i =0; i< n;i++)
		{
			int bukitIndex = (num[i] -min) / bukitLength;
			//just store the largest and minimum number
			bukitMax.set(bukitIndex, Math.max(num[i],bukitMax.get(bukitIndex)));
			bukitMin.set(bukitIndex, Math.min(num[i],bukitMin.get(bukitIndex)));
		}
		int beforeMax = min;
		int maxGap = Integer.MIN_VALUE;
		for(int i =0;i<bukitNum;i++)
		{
			if(bukitMax.get(i) == Integer.MIN_VALUE || bukitMin.get(i) == Integer.MAX_VALUE)
              //empty bukit
				continue;
			maxGap = Math.max(maxGap, bukitMin.get(i)-beforeMax);
			beforeMax = bukitMax.get(i);
		}
		return maxGap;
	}
}