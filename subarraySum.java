// Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.
//
// Have you met this question in a real interview? Yes
// Example
// Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
//
// Note
// There is at least one subarray that it's sum equals to zero.
//brute force, 先划分一个区间然后再区间内求和再作比较，时间复杂度是On3
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                int sum = getSum(nums, i, j);
                if(sum == 0) {
                    res.add(i);
                    res.add(j);
                    return res;
                }
            }
        }
        return null;
    }
    private int getSum(int[] num, int i, int j) {
        int sum = 0;
        for(int k = i; k <= j; k++) {
            sum += num[k];
        }
        return sum;
    }
}

//参考maximum subarray这个题，可以将private函数简化到主函数内部，然后再根据每一次i的不同开始处再来求和
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i ; j < nums.length; j++) {
                sum += nums[j];
                if(sum == 0) {
                    res.add(i);
                    res.add(j);
                    return res;
                }
            }
        }
        return res;
    }
}
//想到用hashmap来优化处理，不断地来记录每一次的和，当出现和一样的时候，说明这个区间段的sum是0，
//返回这个区间即可,时间复杂度On，空间复杂度On
        //假设i = -1的时候sum是0，这个预处理很重要，
        //举例子[1, -1]就知道了，sum一开始是1，如果不预设值sum为0的话，就不会找到解，而且这样子
        //找到的解也会有局限性，所以说一定要设立在i= -1的时候sum是0，这样子i下一个开始的就正好是i = 0;
        //添加结果的时候也是add(map.get(sum) + 1)

//second write, bug free
import java.util.ArrayList;
import java.util.HashMap;

public class subarraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums, int target) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(target, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - target)) {
                res.add(map.get(sum - target) + 1);
                res.add(i);
                return res;
            }
            map.put(sum, i);
        }
        return null;
    }
    public static void main(String[] args) {
        subarraySum s = new subarraySum();
        int[] nums = {-3, 1, 2, -3, 4};
        ArrayList<Integer> res = s.subarraySum(nums, 3);
        for(Integer item : res) {
            System.out.print(item + " ");
        }
    }
}

