// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You may assume NO duplicates in the array.

// Have you met this question in a real interview? Yes
// Example
// [1,3,5,6], 5 → 2

// [1,3,5,6], 2 → 1

// [1,3,5,6], 7 → 4

// [1,3,5,6], 0 → 0

// Challenge
// O(log(n)) time
public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] == target) {
                return mid;
            }
            else if(A[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if(A[start] >= target) {
            return start;
        }
        else if(A[end] >= target) {
            return end;
        }
        else {
            return end + 1;
        }
    }
}



public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your Scode here
        if(A == null || A.length == 0) {
        	return 0;
        }
        int start = 0;
        int end = A.length-1;
        if(target < A[0]) {
        	return 0;
        }
        while(start + 1 < end) {
        	int mid = start + ((end - start)>>1);
        	if(A[mid] == target) {
        		return mid;
        	}
        	else if(A[mid] > target) {
        		end = mid;
        	}
        	else if(A[mid] < target) {
        		start = mid;
        	}
        }
        if(A[start] == target) {
        	return start;
        }
        if(A[end] == target) {
        	return end;
        }
        if(target > A[end]) {
            return end+1;
        }
        return start+1;
    }
}

