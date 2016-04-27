// Write an algorithm which computes the number of trailing zeros in n factorial.

// Have you met this question in a real interview? Yes
// Example
// 11! = 39916800, so the out should be 2

// Challenge
// O(log N) time
//首先需要知道的是这个题说是找会出现的0，但是我们知道一系列数中出现2的次数要远远大于出现5的次数
//所以说我们只需要统计出出现5的次数即可，就看这个数一共含有多少个5就好了
//example。 n = 10; n! = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
//可以看出10中只含有两个5，我们不需要去累加或者count来得到小于n的数中一共有多少个5
//只需要转换到除法上面就好了，看他可以被几个5整除，就代表一共有几个阶梯
class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        long numberOf5 = 0;
        long numberOf2 = 0;
        long n1 = n;
        long n2 = n;
        while(n1 > 0) {
        	numberOf5 += (n1) /5;
        	n1 /=5;
        }
        while(n2 > 0) {
        	numberOf2 += (n2) /5;
        	n2 /=5;
        }
        return Math.min(numberOf2, numberOf5);
    }
};

class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        long count = 0;
        while(n != 0) {
            count += (n / 5);
            n /= 5;
        }
        return count;
    }
};