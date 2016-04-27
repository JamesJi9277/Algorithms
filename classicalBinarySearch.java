Find any position of a target number in a sorted array. Return -1 if target does not exist.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 2, 4, 5, 5].

For target = 2, return 1 or 2.

For target = 5, return 4 or 5.

For target = 6, return -1.

Challenge
O(logn) time

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int findPosition(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(A[mid] == target) {
                return mid;
            }
            else if(A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(A[start] == target) {
            return start;
        }
        else if(A[end] == target) {
            return end;
        }
        return -1;
    }
}

On time O1 space
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int findPosition(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0) {
            return -1;
        }
        for(int i = 0; i < A.length; i++) {
            if(A[i] == target) {
                return i;
            }
        }
        return -1;
    }
}