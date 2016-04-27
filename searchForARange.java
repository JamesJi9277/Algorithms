// Given a sorted array of n integers, find the starting and ending position of a given target value.

// If the target is not found in the array, return [-1, -1].

// Have you met this question in a real interview? Yes
// Example
// Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].

// Challenge
// O(log n) time.
public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(-1);
        res.add(-1);
        if(A == null || A.size() == 0) {
            return res;
        }
        int start = 0;
        int end = A.size()-1;
        while(start + 1 < end) {
            int mid = start + ((end - start)>>1);
            if(A.get(mid) == target) {
                end = mid;
            }
            else if(A.get(mid) > target) {
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(A.get(start) == target) {
            res.set(0,start);
        }
        else if(A.get(end) == target) {
            res.set(0,end);
        }
        else{
            return res;
        }
        start = 0;
        end = A.size()-1;
        while(start + 1 < end) {
            int mid = start + ((end - start)>>1);
            if(A.get(mid) == target) {
                start = mid;
            }
            else if(A.get(mid) > target) {
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(A.get(end) == target) {
            res.set(1,end);
        }
        else if(A.get(start) == target) {
            res.set(1,start);
        }
        //不能写成下面这种形式，因为你找的是range，所以再找左边界的时候应该先比较start，但是在找右边界的时候就应该先比较end
        // if(A.get(start) == target) {
        //     res.set(1,start);
        // }
        // else if(A.get(end) == target) {
        //     res.set(1,end);
        // }
        else{
            return res;
        }
        return res;
    }
}


lc的答案
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(nums == null || nums.length == 0) {
            return res;
        }
        res[0] = searchFirst(nums, 0, nums.length - 1, target);
        res[1] = searchLast(nums, 0, nums.length - 1, target);
        return res;
    }
    private int searchFirst(int[] nums, int start, int end, int target) {
        while(start + 1 < end) {
            int mid = start + (end - start)/ 2;
            if(nums[mid] >= target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if(nums[start] == target) {
            return start;
        }
        else if(nums[end] == target) {
            return end;
        }
        else {
            return -1;
        }
    }
    private int searchLast(int[] nums, int start, int end, int target) {
        while(start + 1 < end) {
            int mid = start + (end - start)/ 2;
            if(nums[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(nums[end] == target) {
            return end;
        }
        else if(nums[start] == target) {
            return start;
        }
        else {
            return -1;
        }
    }
}




