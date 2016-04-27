Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].

time On, space On
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                array.add(nums[i]);
            }
            else {
                if(map.get(nums[i]) >= 2) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
                else {
                    map.put(nums[i], map.get(nums[i]) + 1);
                    array.add(nums[i]);
                }
            }
        }
        for(int i = 0; i < array.size(); i++) {
            nums[i] = array.get(i);
        }
        return array.size();
    }
}


time On, space O1
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
   public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
        return nums.length;
    }
    int length = nums.length;
    int start = 0, times = 1;
    for (int i = 1; i < length; i++) {
        if (nums[i] != nums[start]) {
            start++;
            nums[start] = nums[i];
            times = 1;
        } else {
            times++;
            if (times == 2) {
                start++;
                nums[start] = nums[start - 1];
            }
        }
    }
    return start + 1;
}
}
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length < 3) {
        	return 0;
        }
        int length = nums.length;
        int count = 2;
        for(int i = 2; i < length; i++) {
        	nums[count] = nums[i];
        	if(!(nums[count] == nums[count - 1] && nums[count] == nums[count - 2])) {
        		count++;
        	}
        }
        return count;
    }
}