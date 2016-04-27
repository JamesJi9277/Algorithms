// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Your goal is to reach the last index in the minimum number of jumps.

// Have you met this question in a real interview? Yes
// Example
// Given array A = [2,3,1,1,4]

// The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
        	return 0;
        }
        int reach = 0;
        int count = 0;
        int maxReach = 0;
        for(int i = 0; i < A.length; i++) {
        	//跟2sum类似的做法，jump game 里面需要判断i和reach的关系，那么II里面正好就利用了这个关系
        	//当i > maxReach的话，那么就代表还要接着选一个点，所以count++，然后更新maxReach为当前的reach
        	if(i > maxReach) {
        		count++;
        		maxReach = reach;
        	}
        	reach = Math.max(reach, A[i] + i);
        }
        return count;
    }
}


//dynamic programming
public class Solution {
    public int jump(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int length = A.length;
        int[] res = new int[length];
        res[0] = 0;
        for(int i = 1; i < length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                if(j + A[j] >= i) {
                    min = Math.min(min, res[j]);
                    break;
                }
            }
            res[i] = (min == Integer.MAX_VALUE)? 0 : min + 1;
        }
        return res[length - 1];
    }
}





















