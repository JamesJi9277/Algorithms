// There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.

// Have you met this question in a real interview? Yes
// Example
// Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.

// Given A=[1,2,3] and B=[4,5], the median is 3.

// Challenge
// The overall run time complexity should be O(log (m+n)).
class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;
        if(len % 2 == 0) {
        	//偶数的情况
        	return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len/2 + 1)) / 2.0;
        }
        else{
        	return findKth(A, 0, B, 0, len/2 + 1);
        }
    }
    private static int findKth(int[] A, int aStart, int[] B, int bStart, int k){
    	if(aStart >= A.length) {
    		return B[bStart + k - 1];
    	}
    	if(bStart >= B.length) {
    		return A[aStart + k - 1];
    	}
    	if(k == 1) {
    		return Math.min(A[aStart], B[bStart]);
    	}
        //这个相当于是下标的判断关系
    	int aMid = ((aStart + k/2 - 1) < A.length)? A[aStart + k/2 - 1] : Integer.MAX_VALUE;
    	int bMid = ((bStart + k/2 - 1) < B.length)? B[bStart + k/2 - 1] : Integer.MAX_VALUE;
    	if(aMid < bMid) {
    		return findKth(A, aStart + k / 2, B, bStart, k - k/2);
    	}
    	else{
    		return findKth(A, aStart, B, bStart + k/2, k - k/2);
    	}
    }
}

//second write
import java.util.Random;

public class medianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) {
            return 0;
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;
        if(length % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, length/2) + findKth(nums1, 0, nums2, 0, length/2 + 1)) / 2.0;
        }
        else {
            return findKth(nums1, 0, nums2, 0, length/2 + 1);
        }
    }
    private int findKth(int[] A, int aStart, int[] B, int bStart, int k) {
        if(aStart >= A.length) {
            return B[bStart + k - 1];
        }
        if(bStart >= B.length) {
            return A[aStart + k - 1];
        }
        if(k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }
        int aMid = (aStart + k/2 - 1) < A.length ? A[aStart + k/2 - 1] : Integer.MAX_VALUE;
        int bMid = ((bStart + k/2 - 1) < B.length)? B[bStart + k/2 - 1] : Integer.MAX_VALUE;
        if(aMid < bMid) {
            return findKth(A, aStart+k/2, B,bStart, k - k/2);
        }
        else {
            return findKth(A, aStart, B, bStart + k/2, k - k/2);
        }
    }
    public static void main(String[] args) {
        medianOfTwoSortedArray func = new medianOfTwoSortedArray();
        Random rand1 = new Random();
        Random rand2 = new Random();
        int[] A = new int[1000];
        int[] B = new int[2000];
        for(int i = 0; i < A.length; i++) {
            A[i] = rand1.nextInt(2000);
        }
        for(int i = 0; i < B.length; i++) {
            B[i] = rand2.nextInt(2000);
        }
        double res = func.findMedianSortedArrays(A, B);
        System.out.println("The median of two array is " + res);
    }
}
