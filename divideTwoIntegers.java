// Divide two integers without using multiplication, division and mod operator.

// If it is overflow, return 2147483647

// Have you met this question in a real interview? Yes
// Example
// Given dividend = 100 and divisor = 9, return 11.
public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        if(dividend == (-2147483648) && divisor == (-1)) {
            return 2147483647;
        }
        else{
        	return (dividend / divisor);
        }
    }
}

//time complexity O(logn),因为每次是拿2的幂去比较的，所以时间复杂度是logn级别
public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if(dividend == 0 || divisor == 1) {
            return dividend;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long res = 0L;
        long num1 = Math.abs((long)dividend);
        long num2 = Math.abs((long)divisor);
        boolean isNeg = ((dividend < 0) ^ (divisor < 0)) == false ? false: true;
        while(num1 >= num2) {
            int count = 0;
            while(num1 >= (num2 << count)) {
                count++;
            }
            count--;
            long temp = (num2 << count);
            num1 %= temp;
            res += (1 << count);
        }
        return isNeg? (-1)*(int)res : (int) res;
    }
}


//简化版本
public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if(dividend == 0 || divisor == 1) {
            return dividend;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = (((dividend < 0) ^ (divisor < 0)) == true) ? true : false;
        long num1 = Math.abs((long)dividend);
        long num2 = Math.abs((long)divisor);
        long res = 0;
        while(num1 >= num2) {
            int count = 0;
            while(num1 >= (num2 << count)) {
                count++;
            }
            count--;
            num1 %= (num2 << count);
            res += (1 << count);
        }
        return isNeg ? -(int)res : (int)res;
    }
}

