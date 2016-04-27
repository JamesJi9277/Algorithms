// Give you an integer array (index from 0 to n-1, where n is the size of this array)，find the longest increasing continuous subsequence in this array. (The definition of the longest increasing continuous subsequence here can be from right to left or from left to right)

// Have you met this question in a real interview? Yes
// Example
// For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

// For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.

// Note
// O(n) time and O(1) extra space.
public class Solution {
	public int longestIncreasingContinuousSubsequence(int[] A) {
		if(A == null || A.length == 0) {
			return 0;
		}
		boolean fromLeft = true;
		int start = 0;
		int res = 1;
		for(int i = 1; i < A.length; i++) {
			if(A[i] > A[i - 1]) {
				if(fromLeft) {
					res = Math.max(res, i - start + 1);
				}
				else {
					start = i - 1;
					fromLeft = true;
				}
			}
			else if (A[i] < A[i - 1]) {
				if(!fromLeft) {
					res = Math.max(res, i - start + 1);
				}
				else {
					start = i - 1;
					fromLeft = false;
				}
			}
		}
		return res;
	}
}




//second write, bug free
public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int res = 1;
        boolean fromLeftToRight = true;
        for(int i = 1; i < A.length; i++) {
            if(A[i] > A[i - 1]) {
                if(fromLeftToRight == true) {
                    res = Math.max(res, i - start + 1);
                }
                else if(fromLeftToRight == false) {
				    //注意这里的start应该是从i- 1开始的，因为涉及到的是下标的转换，下同
                    start = i - 1;
                    fromLeftToRight = true;
                }
            }
            else if(A[i] < A[i - 1]) {
                if(fromLeftToRight == true) {
                    start = i - 1;
                    fromLeftToRight = false;
                }
                else if(fromLeftToRight == false) {
                    res = Math.max(res, i - start + 1);
                }
            }
        }
        return res;
    }
}


//dp, bug free
public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if(A == null || A.length == 0) {
            return 0;
        }
        int length = A.length;
        int[] front = new int[length];
        int[] back = new int[length];
        int max = 0;
        front[0] = 1;
        for(int i = 1; i < length; i++) {
            front[i] = 1;
            if(A[i] > A[i - 1]) {
                front[i] = front[i - 1] + 1;
            }
        }
        back[length - 1] = 1;
        for(int i = length - 2; i >= 0; i--) {
            back[i] = 1;
            if(A[i + 1] < A[i]) {
                back[i] = back[i + 1] + 1;
            }
        }
        for(int i = 0; i < length; i++) {
            max = Math.max(max, Math.max(front[i], back[i]));
        }
        return max;
    }
}

