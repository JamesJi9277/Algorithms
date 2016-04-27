Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

public class Solution {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		int start = nums[0];
		int end = nums[0];
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i + 1] == nums[i] + 1) {
				end = nums[i + 1];
			}
			else {
				addToArr(res, start, end);
				start = nums[i + 1];
				end = nums[i + 1];
			}
		}
		addToArr(res, start, end);
		return res;
	}
	private void addToArr(List<String> arr, int start, int end) {
		if(start == end) {
			arr.add(String.valueOf(start));
		}
		else {
			arr.add(start + "->" + end);
		}
	}
}

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        int left = 0;
        int right = 1;
        for(right = 1; right < nums.length; right++) {
            if(nums[right - 1] + 1 == nums[right]) {
                continue;
            }
            helper(res, nums[left], nums[right - 1]);
            left = right;
            
        }
        helper(res, nums[left], nums[right - 1]);
        return res;
    }
    private void helper(List<String> res, int start, int end) {
        StringBuffer sb = new StringBuffer();
        if(end == start) {
            sb.append(end + "");
            res.add(sb.toString());
            return;
        }
        else {
            sb.append(start + "");
            sb.append("->");
            sb.append(end + "");
            res.add(sb.toString());
            return;
        }
    }
}