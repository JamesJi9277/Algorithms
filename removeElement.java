Given an array and a value, remove all occurrences of that value in place and return the new length.

The order of elements can be changed, and the elements after the new length don't matter.

Have you met this question in a real interview? Yes
Example
Given an array [0,4,4,0,0,2,4,4], value=4

return 4 and front four elements of the array is [0,0,0,2]

public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] == elem) {
                count++;
            }
            else {
                A[i - count] = A[i];
            }
        }
        return A.length - count;
    }
}

