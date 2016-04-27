 String to Int

public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) {
        	return 0;
        }
        str = str.trim();
        int i = 0;
        boolean isNeg = false;
        if(str.charAt(0) == '+') {
        	i++;
        }
        if(str.charAt(0) == '-') {
        	isNeg = true;
        	i++;
        }
        //这一题一定要是double
        double res = 0L;
        while(i < str.length() && str.charAt(i) - '0' <= 9 && str.charAt(i) - '0' >= 0) {
        	int digit = str.charAt(i) - '0';
        	res = res * 10 + digit;
        	i++;
        }
        res = (isNeg == true) ? -res : res;
        if(res < Integer.MIN_VALUE) {
        	return Integer.MIN_VALUE;
        }
        else if(res > Integer.MAX_VALUE) {
        	return Integer.MAX_VALUE;
        }
        else return (int)res;
    }
}