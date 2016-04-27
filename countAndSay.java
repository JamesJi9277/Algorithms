// The count-and-say sequence is the sequence of integers beginning as follows:

// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.

// 11 is read off as "two 1s" or 21.

// 21 is read off as "one 2, then one 1" or 1211.

// Given an integer n, generate the nth sequence.

// Have you met this question in a real interview? Yes
// Example
// Given n = 5, return "111221".
//这个题因为是求第n个，我需要做的事将之前的结果不断地带入循环来得到下一个结果，因为求的是第n个，所以n要先减一，也就是--n
//for循环中内嵌while来进行重复的查找，并且推出条件是 (i + 1) < length，这里需要好好体会一下
public class Solution {
    public String countAndSay(int n) {
        if(n < 1) {
            return "";
        }
        String res = "1";
        while(--n > 0) {
            char[] nums = res.toCharArray();
            StringBuffer sb = new StringBuffer();
            int count = 1;
            for(int i = 0; i < nums.length; i++) {
                if(i != nums.length - 1 && nums[i] == nums[i + 1]) {
                    count++;
                    continue;
                }
                sb.append(count);
                sb.append(nums[i]);
                count = 1;
            }
            res = sb.toString();
        }
        return res;
    }
}