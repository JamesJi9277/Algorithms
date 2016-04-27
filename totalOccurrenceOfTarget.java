Given a target number and an integer array sorted in ascending order. Find the total number of occurrences of target in the array.

Have you met this question in a real interview? Yes
Example
Given [1, 3, 3, 4, 5] and target = 3, return 2.

Given [2, 2, 3, 4, 6] and target = 4, return 1.

Given [1, 2, 3, 4, 5] and target = 6, return 0.

Challenge
Time complexity in O(logn)
brute force On 
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == target) {
                count++;
            }
        }
        return count;
    }
}

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        int count = 0;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] == target) {
                count++;
                int pre = mid - 1;
                int post = mid + 1;
                while(pre >= 0 && A[pre] == target) {
                    pre--;
                    count++;
                }
                while(post < A.length && A[post] == target) {
                    post++;
                    count++;
                }
                break;
            }
            else if(A[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return count;
    }
}

进一步优化，采取双重binary search
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        int p = doFirstSearch(A, 0, A.length - 1, target);
        int q = doLastSearch(A, 0, A.length - 1, target);
        if(p == -1 || q == -1) {
            return 0;
        }
        return q - p + 1;
    }
    private int doFirstSearch(int[] A, int start, int end, int target) {
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] >= target) {
                end = mid;
            }
            else 
                start = mid;
        }
        if(A[start] == target) {
            return start;
        }
        else if(A[end] == target) {
            return end;
        }
        else {
            return -1;
        }
    }
    private int doLastSearch(int[] A, int start, int end, int target) {
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] <= target) {
                start = mid;
            }
            else 
                end = mid;
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