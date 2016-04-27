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
        boolean isNeg = ((dividend < 0) ^ (divisor < 0) == true) ? true : false;
        long num1 = Math.abs((long)dividend);
        long num2 = Math.abs((long)divisor);
        long res = 0;
        while(num1 >= num2) {
          int count = 0;
          while(num1 >= (num2 << count)) {
            count++;
          }
          count--;
          res += (1 << count);
          num1 = (num1 % (num2 << count));
        }
        return isNeg?(-1) * (int)res : (int)res;
    }
}
