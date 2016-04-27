// Determine whether an integer is a palindrome. Do this without extra space.
// Some hints:
// Could negative integers be palindromes? (ie, -1)

// If you are thinking of converting the integer to string, note the restriction of using extra space.

// You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", 
// you know that the reversed integer might overflow. How would you handle such case?
//每次去第一位和最后一位，如果不相同则返回false，否则继续直到位数为0
public class Solution {
    public boolean isPalindrome(int x) {
        int y = x;
        if(x < 0) {
            return false;
        }
        if(x < 10) {
            return true;
        }
        int sum = 0;
        while(x != 0) {
            sum = sum * 10;
            sum += (x % 10);
            
            x /= 10;
        }
        return (sum == y);
    }
}

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int m = doReverse(x);
        return (m == x);
    }
    private int doReverse(int m) {
        int sum = 0;
        while(m > 0) {
            sum = sum * 10 + m % 10;
            m /= 10;
        }
        return sum;
    }
}