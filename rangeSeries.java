summary ranges
given [0,1,2,4,5,7], return ["0->2","4->5","7"].
public class Solution {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		int left = nums[0];
		int right = nums[0];
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i + 1] == nums[i] + 1) {
				right = nums[i + 1];
			}
			else {
				addToArr(res, left, right);
				left = nums[i + 1];
				right = nums[i + 1];
			}
		}
		addToArr(res, left, right);
		return res;
	}
	private void addToArr(List<String> res, int left, int right) {
		if(left == right) {
			res.add(String.valueOf(left));
		}
		else {
			res.add(left + "->" + right);
		}
	}
}

missing ranges
[0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"]

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0) {
            //这个特殊情况要注意以下，为空的时候是整个区间逗missing的
            add(res, lower, upper);
            return res;
        }
        if(nums[0] > lower) {
        	add(res, lower, nums[0] - 1);
        }
        for(int i = 0; i < nums.length - 1; i++) {
        	if(nums[i + 1] != nums[i] + 1) {
        		add(res, nums[i] + 1, nums[i + 1] - 1);
        	}
        }
        if(nums[nums.length - 1] < upper) {
        	add(res,nums[nums.length - 1] + 1, upper);
        }
        return res;
    }
    private void add(List<String> res, int left, int right) {
		if(left == right) {
			res.add(String.valueOf(left));
		}
		else {
			res.add(left + "->" + right);
		}
	}
}