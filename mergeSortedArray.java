// Given two sorted integer arrays A and B, merge B into A as one sorted array.

// Have you met this question in a real interview? Yes
// Example
// A = [1, 2, 3, empty, empty], B = [4, 5]

// After merge, A will be filled as [1, 2, 3, 4, 5]

// Note
// You may assume that A has enough space (size that is greater or equal to m + n) 
//to hold additional elements from B. 
//The number of elements initialized in A and B are m and n respectively.
class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int index1 = m - 1;
        int index2 = n - 1;
        int len = m + n - 1;
        while(index1 >=0 && index2 >= 0) {
            if(A[index1] > B[index2]) {
                A[len] = A[index1];
                len--;
                index1--;
            }
            else if(A[index1] <= B[index2]) {
                A[len] = B[index2];
                len--;
                index2--;
            }
        }
        while(index2 >= 0) {
            A[len] = B[index2];
            len--;
            index2--;
        }
        return;
    }
}

