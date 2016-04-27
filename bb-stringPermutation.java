public class Solution {
    
    public List<List<Integer>> permute(char[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<Integer>();
        boolean[] isUsed = new boolean[nums.length];
        helper(nums, res, temp, isUsed);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, boolean[] isUsed) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if((i != 0 && nums[i] == nums[i - 1] && isUsed[i - 1] == false) || isUsed[i] == true) {
                continue;
            }
            temp.add(nums[i]);
            isUsed[i] = true;
            helper(nums, res, temp, isUsed);
            isUsed[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}