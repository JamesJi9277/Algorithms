// Given a range [m, n] where 0 <= m <= n <= 2147483647, 
// return the bitwise AND of all numbers in this range, inclusive.
// For example, given the range [5, 7], you should return 4.
//     8  4  2  1
// ---------------
// 5 | 0  1  0  1
// 6 | 0  1  1  0
// 7 | 0  1  1  1
// 当n >m的时候，n不停地通过while循环与n-1来与操作，最后再与m进行一个与操作就好了，思路较为清晰明了

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        while(n > m) {
            n = n & (n - 1);
        }
        return n;
    }
}