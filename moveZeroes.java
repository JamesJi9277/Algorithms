// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

// Note:
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.
//time On, space On
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for(int i = 0; i < length; i++) {
            if(nums[i] != 0) {
                copy.add(nums[i]);
            }
        }
        for(int i = 0; i < length;) {
            if(i < copy.size()) {
                nums[i] = copy.get(i);
                i++;
            }
            else {
                nums[i] = 0;
                i++;
            }
        }
        return;
    }
}

public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int nonZero = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[nonZero++] = nums[i];
                count++;
            }
        }
        for(int i = nonZero; i < nums.length; i++) {
            nums[i] = 0;
        }
        return;
    }
}

public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int nonZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                doSwap(nums, nonZero, i);
                nonZero++;
            }
        }
        return;
    }
    private void doSwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int nonZero = 0;
        int index = 0;
        while(index < nums.length) {
            if(nums[index] != 0) {
                doSwap(nums, index, nonZero);
                index++;
                nonZero++;
            }
            else {
                index++;
            }
        }
        return;
    }
    private void doSwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}