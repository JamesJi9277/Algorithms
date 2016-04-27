// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// Have you met this question in a real interview? Yes
// Example
// A = [2,3,1,1,4], return true.

// A = [3,2,1,0,4], return false.
//greedy
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int reach = 0;
        if(A == null || A.length == 0) {
            return false;
        }
        for(int i = 0; i <= reach && i < A.length; i++) {
            reach = Math.max(reach, A[i] + i);
        }
        return reach >= A.length - 1;
    }
}

//dynamic programming
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        boolean[] res = new boolean[A.length];
        res[0] = true;
        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                if(res[j] && j + A[j] >= i) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[A.length - 1];
    }
}

public class Solution {
    public boolean canJump(int[] nums) {
        if( nums == null || nums.length == 0 ){
            return false;
        }
        int length = nums.length;
        int crtMaxPos = 0;
        for(int i = 0; i < length; i++){
            if( crtMaxPos < i ){
                break;
            }
            crtMaxPos = Math.max(crtMaxPos, i + nums[i]);
        }

        return crtMaxPos >= length - 1;
    }
}


public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if(A == null || A.length == 0) {
            return false;
        }
        boolean[] res = new boolean[A.length];
        res[0] = true;
        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                if((res[j])  && (A[j]+ j >= i)) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[A.length - 1];
    }
}

