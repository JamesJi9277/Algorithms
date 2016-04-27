public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = {0, 0};
        if(nums == null || nums.length < 2) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]) + 1;
                res[1] = i + 1;
                return res;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            //记住基本的模式，千万别慌
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum >= target) {
                    right--;
                }
                else {
                    count += (right - left);
                    left++;
                }
            }
        }
        return count;
    }
}