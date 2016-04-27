// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// For example,
// Given input array A = [1,1,2],

// Your function should return length = 2, and A is now [1,2]..
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(i != 0 && A[i] == A[i - 1]) {
                count++;
            }
            else {
                A[i - count] = A[i];
            }
        }
        return A.length - count;
    }
}

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        int length = A.length;
        int count = 1;
        for(int i = 1; i < length; i++) {
            if(A[i - 1] != A[i]) {
                A[count++] = A[i];
                continue;
            }
            else {
                int temp = i;
                while(temp < length && A[temp] == A[temp - 1]) {
                    temp++;
                }
                if(temp == length) {
                    break;
                }
                A[count++] = A[temp];
                i = temp;
            }
        }
        return count;
    }
}