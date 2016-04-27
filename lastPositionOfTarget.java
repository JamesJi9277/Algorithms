Find the last position of a target number in a sorted array. Return -1 if target does not exist.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 2, 4, 5, 5].

For target = 2, return 2.

For target = 5, return 5.

For target = 6, return -1.

brute force Time On, space O1
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int lastPosition(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0) {
            return -1;
        }
        for(int i = A.length - 1; i >= 0; i--) {
            if(A[i] == target) {
                return i;
            }
        }
        return -1;
    }
}


binary search time Ologn, space O1
每一次搜索的时候尽量往后靠，这样就可以找到在end时候的target
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int lastPosition(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(A[end] == target) {
            return end;
        }
        else if(A[start] == target) {
            return start;
        }
        else {
            return -1;
        }
    }
}