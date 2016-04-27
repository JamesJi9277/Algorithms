public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}

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