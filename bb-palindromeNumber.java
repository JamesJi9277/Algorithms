Determine whether an integer is a palindrome. Do this without extra space.
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
        	return false;
        }
        long res = 0;
        long num = Math.abs((long)x);
        while(num > 0) {
        	long digit = num % 10;
        	res = res * 10 + digit;
        	num /= 10;
        }
        return res == (long) x;
    }
}