// Given a string and an offset, rotate string by offset. (rotate from left to right)

// Have you met this question in a real interview? Yes
// Example
// Given "abcdefg".

// offset=0 => "abcdefg"
// offset=1 => "gabcdef"
// offset=2 => "fgabcde"
// offset=3 => "efgabcd"
// Challenge
// Rotate in-place with O(1) extra memory.
//O(n) space complexity, O(n) 
public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
        
        char[] res = new char[A.length];
        if( A == null || A.length == 0) {
        	return res;
        }
         offset = offset%(A.length);
        for(int i =0;i<offset;i++) {
        	res[i] = A[A.length - offset+i];
        }
        for(int i =offset;i<A.length;i++) {
        	res[i] = A[i-offset];
        }
        return res;
    }
};
//O(n) space complexity, and using API
public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
        if(A == null || A.length == 0) {
            return A;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i<A.length;i++) {
        	sb.append(A[i] +"");
        }
        String str = sb.toString();
        offset = offset%(A.length);
        String str1 = str.substring(A.length - offset, A.length);
        String str2 = str.substring(0, A.length - offset);
        String resStr = str1 + str2;
        char[] res = resStr.toCharArray();
        return res;
    }
};


//O(1) space,三步翻转法
public class Solution {
    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
        if(A == null || A.length == 0) {
        	return A;
        }
        offset = offset%(A.length);
        doReverse(A, 0, A.length-offset-1);
        doReverse(A, A.length - offset, A.length -1);
        doReverse(A, 0, A.length-1);
        return A;
    }
    private void doReverse(char[] nums, int start, int end) {
    	if(start >= end || nums == null || nums.length == 0) {
    		return;
    	}
    	for(int i =0;start+i < end -i;i++) {
    	//for(int i =0;i < ((end - start)>>1);i++) { 这里不可以这么写，因为/2是有下届的
    		char temp = nums[i+start];
    		nums[i+start] = nums[end - i];
    		nums[end - i] = temp;
    	}
    }
    private void doReverse(char[] A, int start, int end) {
    	while( start <= end) {
    		char tmp = A[start];
    		A[start] = A[end];
    		A[end] = tmp;
    		start++;
    		end--;
    	}
    }
};


