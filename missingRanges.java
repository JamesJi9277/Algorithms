Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].


public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0) {
            helper(res, lower, upper);
            return res;
        }
        if(lower < nums[0]) {
            helper(res, lower, nums[0] - 1);
        }
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1] - 1) {
                continue;
            }
            helper(res, nums[i] + 1, nums[i + 1] - 1);
        }
        if(upper > nums[nums.length - 1]) {
            helper(res, nums[nums.length - 1] + 1, upper);
        }
        return res;
    }
    private void helper(List<String> res, int start, int end) {
        StringBuffer sb = new StringBuffer();
        if(start == end) {
            sb.append(start + "");
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