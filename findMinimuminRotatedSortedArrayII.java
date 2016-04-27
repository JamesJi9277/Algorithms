// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// The array may contain duplicates.

// Have you met this question in a real interview? Yes
// Example
// Given [4,4,5,6,7,0,1,2] return 0
public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0) {
            return -1;
        }
        int min = num[0];
        for(int i =0; i < num.length; i++) {
            if(num[i] <= min) {
                min = num[i];
            }
        }
        return min;
    }
}
