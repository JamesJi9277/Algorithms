public class Solution {
    public int reverse(int x) {
        if(x == 0) {
            return 0;
        }
        boolean isNeg = (x < 0) ? true : false;
        long res = 0;
        long num = Math.abs((long)x);
        while(num > 0) {
            long rem = num % 10;
            res = res * 10 + rem;
            num /= 10;
        }
        if(res > Integer.MAX_VALUE) {
            return 0;//这里的overflow返回条件需要和面试官商量
        }
        return (isNeg) ? -(int)res : (int)res;
    }
}