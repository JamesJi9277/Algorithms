// Using O(1) time to check whether an integer n is a power of 2.

// Have you met this question in a real interview? Yes
// Example
// For n=4, return true;

// For n=5, return false;


// Challenge
// O(1) time
class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if(n < 1) {
            return false;
        }
        return (n &(n - 1)) == 0;
    }
};


public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1) {
            return false;
        }
        while(n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}

public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1) {
            return false;
        }
        return (Math.log10(n) / Math.log10(2)) % 1 == 0;
    }
}