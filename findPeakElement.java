// There is an integer array which has the following features:

// The numbers in adjacent positions are different.
// A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
// We define a position P is a peek if:

// A[P] > A[P-1] && A[P] > A[P+1]
// Find a peak element in this array. Return the index of the peak.

// Have you met this question in a real interview? Yes
// Example
// Given [1, 2, 1, 3, 4, 5, 7, 6]

// Return index 1 (which is number 2) or 6 (which is number 7)

// Note
// The array may contains multiple peeks, find any of them.

// Challenge
// Time complexity O(logN)
public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            //这里只需要进行单向那个的判断就好了，不用判断mid - 1, mid和mid + 1的关系，只需要找到mid的趋势就行，如果判断三者关系
            //就会很麻烦。因为还会涉及到mid是在一个波谷，考虑的条件过多
            else if(nums[mid - 1] < nums[mid]) {
                start = mid;
            }
            else if(nums[mid - 1] > nums[mid] ){
                end = mid;
            }
        }
        if(nums[start] > nums[end]) {
            return start;
        }
        else {
            return end;
        }
    }
}

//brute force, time O(n)
class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
            return -1;
        }
        for(int i = 0; i < A.length - 2; i++) {
            if((A[i] < A[i + 1]) && (A[i + 1] > A[i + 2])) {
                return i+1;
            }
        }
        return -1;
    }
}



