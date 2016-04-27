// Given a non-negative number represented as an array of digits, plus one to the number.

// The digits are stored such that the most significant digit is at the head of the list.
//先将每个数加1，用来判断是否需要进位，如果需要的话，则将digits[i]设置为0，carry = 1.如果carry = 0，则跳出循环返回digits
//如果全部是9，则是最坏情况，则需要额外的O（n）空间用来新建一个数组
public class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(digits == null || digits.length == 0) {
            res.add(1);
            return toInt(res);
        }
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int digit = (carry + digits[i]) % 10;
            carry = (carry + digits[i]) / 10;
            res.add(digit);
        }
        if(carry == 1) {
            res.add(1);
        }
        return toInt(res);
    }
    private int[] toInt(ArrayList<Integer> nums) {
        int[] res = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++) {
            res[i] = nums.get(nums.size() - 1 - i);
        }
        return res;
    }
}