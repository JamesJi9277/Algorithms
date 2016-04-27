// Given a list of integers, which denote a permutation.
//
// Find the previous permutation in ascending order.
//
// Have you met this question in a real interview? Yes
// Example
// For [1,3,2,3], the previous permutation is [1,2,3,3]
//
// For [1,2,3,4], the previous permutation is [4,3,2,1]
//
// Note
// The list may contains duplicate integers.
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		if(nums == null || nums.size() == 0) {
		    return nums;
		}
		if(nums.size() == 1) {
		    return nums;
		}


		int i = 0;
		for(i = nums.size() - 2; i >= 0; i--) {
		    if(nums.get(i) > nums.get(i + 1)) {
		        break;
		    }
		    else if (i == 0) {
		        doReverse(nums, 0, nums.size() - 1);
            //这个返回一定要加上，写程序还是要仔细
		        return nums;
		    }
		}

		int j = 0;
		for(j = nums.size() - 1; j > i; j--) {
		    if(nums.get(j) < nums.get(i)) {
		        break;
		    }
		}

		doSwap(nums, i, j);
		doReverse(nums, i + 1, nums.size() - 1);
		return nums;
    }
    private void doSwap(ArrayList<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
    private void doReverse(ArrayList<Integer> nums, int start, int end) {
        for(int i = 0; start + i < end - i; i++) {
            int temp = nums.get(start + i);
            nums.set(start + i, nums.get(end - i));
            nums.set(end - i, temp);
        }
    }
}
