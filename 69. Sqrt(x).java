/*注意相乘的时候可能溢出，需要转型*/
public class Solution {
    public int mySqrt(int x) {
        if(x < 1) {
          return 0;
        }
        long start = 1;
        long end = x;
        while(start + 1 < end) {
          long mid = start + (end - start) / 2;
          if(mid * mid == (long)x) {
            return (int)mid;
          }
          else if(mid * mid < (long)x) {
            start = mid;
          }
          else {
            end = mid;
          }
        }
        if(end * end == x) {
          return (int)end;
        }
        else {
          return (int)start;
        }
    }
}
