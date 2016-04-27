Determine the number of bits required to flip if you want to convert integer n to integer m.

Have you met this question in a real interview? Yes
Example
Given n = 31 (11111), m = 14 (01110), return 2.

Note
Both n and m are 32-bit integers.
class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int bit = (a ^ b);
        int count = 0;
        int number = 32;
        while(number > 0) {
            count += bit & 1;
            bit = bit >> 1;
            number--;
        }
        return count;
    }
};

