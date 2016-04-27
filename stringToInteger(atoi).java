// Implement function atoi to convert a string to an integer.

// If no valid conversion could be performed, a zero value is returned.

// If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

// Have you met this question in a real interview? Yes
// Example
// "10" => 10

// "-1" => -1

// "123123123123123" => 2147483647

// "1.0" => 1

public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        int i = 0;
        str = str.trim();
        boolean isNeg = false;
        if(str.charAt(i) == '-') {
            i++;
            isNeg = true;
        }
        else if(str.charAt(i) == '+') {
            i++;
        }
        double res = 0;
        while(i < str.length() && str.charAt(i) - '0' <= 9 && str.charAt(i) - '0' >= 0) {
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }
        res = (isNeg) ? -res : res;
        if(res >= Integer.MAX_VALUE) {
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