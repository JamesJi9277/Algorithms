// Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).

// Have you met this question in a real interview? Yes
// Example
// Given x = 123, return 321

// Given x = -123, return -321
public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        String str = String.valueOf(n);
        boolean isNeg = false;
        if(str.charAt(0) == '-') {
            isNeg = true;
        }
        long weight = (long)1;
        long sum = (long)0;
        for(int i = (isNeg) ?1:0 ; i < str.length(); i++) {
            sum += (str.charAt(i) - '0') * weight;
            weight *= 10;
        }
        sum = (isNeg)? -sum : sum;
        if(sum > Integer.MAX_VALUE || sum <= Integer.MIN_VALUE) {
            return 0;
        }
        return (int) sum;
    }
}
