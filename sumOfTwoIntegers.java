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
        int x = a ^ b;
        int y = a & b;
        while(y != 0) {
            int xx = x;
            int yy = y << 1;
            x = xx ^ yy;
            y = xx & yy;
        }
        return x;
    }
}