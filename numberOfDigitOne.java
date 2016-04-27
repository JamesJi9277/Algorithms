// // Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

// // For example:
// // Given n = 13,
// // Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

// // Hint:

// // Beware of overflow.
// reference: https://leetcode.com/discuss/44281/4-lines-o-log-n-c-java-python
// intuitive: 每10个数, 有一个个位是1, 每100个数, 有10个十位是1, 每1000个数, 有100个百位是1.
//做一个循环, 每次计算单个位上1得总个数(个位,十位, 百位).
// 例子:
// 以算百位上1为例子:   假设百位上是0, 1, 和 >=2 三种情况:
//     case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
//     case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次.
//     case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次.
// 以上三种情况可以用 一个公式概括:
// (a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
// 100以内的数字，除了10-19之间有11个‘1’之外，其余都只有1个。
// 如果我们不考虑[10, 19]区间上那多出来的10个‘1’的话，
// 那么我们在对任意一个两位数，十位数上的数字(加1)就代表1出现的个数，
// 这时候我们再把多出的10个加上即可。比如56就有(5+1)+10=16个。
// 如何知道是否要加上多出的10个呢，我们就要看十位上的数字是否大于等于2，是的话就要加上多余的10个'1'。
// 那么我们就可以用(x+8)/10来判断一个数是否大于等于2。
// 对于三位数也是一样，除了[110, 119]之间多出的10个数之外，其余的每10个数的区间都只有11个‘1’，
// 那么还是可以用相同的方法来判断并累加1的个数

public class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        for(long m = 1; m <= n; m = m * 10) {
            long a = n / m;
            long b = n % m;
            res += (a + 8) / 10 * m;
            if(a % 10 == 1) {
                res += (b + 1);
            }
        }
        return res;
    }
}


public class Solution {
    public int countDigitOne(int n) {
        if(n < 1) {
            return 0;
        }
        int count = 0;
        for(int i = 1; i <= n; i++) {
            count += getNum(i);
        }
        return count;
    }
    private int getNum(int i) {
        int count = 0;
        while(i != 0) {
            int digit = i % 10;
            if(digit == 1) {
                count++;
            }
            i /= 10;
        }
        return count;
    }
}