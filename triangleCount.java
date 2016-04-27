Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?

Have you met this question in a real interview? Yes
Example
Given array S = [3,4,6,7], return 3. They are:

[3,4,6]
[3,6,7]
[4,6,7]
Given array S = [4,4,4,4], return 4. They are:

[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]




brute force, time On3, space O1
public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if(S == null || S.length < 3) {
            return 0;
        }
        int count = 0;
        int length = S.length;
        for(int i = 0; i < length - 2; i++) {
            for(int  j = i + 1; j < length - 1; j++) {
                for(int k = j + 1; k < length; k++) {
                    if(isValid(S[i], S[j], S[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean isValid(int a, int b, int c) {
        if((a + b > c && Math.abs(a - b) < c) ||
        (a + c > b && Math.abs(a - c) < b) ||
        (c + b > a && Math.abs(c - b) < a)) {
            return true;
        }
        return false;
    }
}

