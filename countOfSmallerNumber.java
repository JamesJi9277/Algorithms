Give you an integer array (index from 0 to n-1, where n is the size of this array, value from 0 to 10000) and an query list. For each query, give you an integer, return the number of element in the array that are smaller than the given integer.

Have you met this question in a real interview? Yes
Example
For array [1,2,7,8,5], and queries [1,8,5], return [0,4,2]

Note
We suggest you finish problem Segment Tree Build and Segment Tree Query II first.

Challenge
Could you use three ways to do it.

Just loop
Sort and binary search
Build Segment Tree and Search.

Just loop
public class Solution {
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(A == null || queries == null ) {
            return res;
        }
        for(Integer item : queries) {
            int count = helper(A, item);
            res.add(count);
        }
        return res;
    }
    private int helper(int[] nums, int target) {
        int count = 0;
        for(Integer item : nums) {
            if(item < target) {
                count++;
            }
        }
        return count;
    }
}

binary search,转换成找到最后一个比target小的数字然后返回index+1
import java.util.ArrayList;
import java.util.Arrays;

public class countOfSmallerNumber {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
	public static void main(String[] args) {
		countOfSmallerNumber c = new countOfSmallerNumber();
		int[] A = {86,59,39};
		int[] queries = {1,100,57,50,60};
		ArrayList<Integer> res = c.countOfSmallerNumber(A, queries);
		for(Integer item : res) {
			System.out.print(item + " ");
		}
	}
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        Arrays.sort(A);
        for(Integer item : queries) {
            int count = helper(A, item);
            res.add(count);
        }
        return res;
    }
    private int helper(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(A[end] < target) {
            return end + 1;
        }
        else if(A[start] < target){
            return start + 1;
        }
        else {
            return 0;
        }
    }
}


