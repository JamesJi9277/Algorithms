The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, find the sequence of gray code. A gray code sequence must begin with 0 and with cover all 2n integers.

Have you met this question in a real interview? Yes
Example
Given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note
For a given n, a gray code sequence is not uniquely defined.

[0,2,3,1] is also a valid gray code sequence according to the above definition.

Challenge
O(2n) time.

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n < 0) {
            return res;
        }
        if(n == 0) {
            res.add(0);
            return res;
        }
        res = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        for(int i = res.size() - 1; i >= 0; i--) {
            res.add(addNumber + res.get(i));
        }
        return res;
    }
}