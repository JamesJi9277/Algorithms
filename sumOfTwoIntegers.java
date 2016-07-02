//normal solution
public class Solution {
    public int getSum(int a, int b) {
        long res = 0;
        res = res + a + b;
        if(res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        else if(res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        else {
            return (int)res;
        }
    }
}

//bit manipulation
public class Solution {
    public int getSum(int a, int b) {
        int sum = a ^ b;
        int carry = a & b;
        int temp = 0;
        while(carry != 0) {
            carry <<= 1;
            temp = sum;
            sum ^= carry;
            carry &= temp;
        }
        return sum;
    }
}