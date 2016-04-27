Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

这一题的重点是at least one exist，所以并不是每一个[1,n]都会出现，比如[2,2,2,2]也是一个test case
其实是跟linkedlist cycle是一样的，因为出现了重复就像于是有一个cycle了

public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while(slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}




//空间On的做法，time On, bug free
public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return nums[i];
            }
            else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
}