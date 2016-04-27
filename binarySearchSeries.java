//first bad version
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if(n < 1) {
            return 0;
        }
        int start = 1;
        int end = n;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(SVNRepo.isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if(SVNRepo.isBadVersion(start)) {
            return start;
        }
        else if(SVNRepo.isBadVersion(end)) {
            return end;
        }
        else {
            return 0;
        }
    }
}
//Search in Rotated Sorted Array II
public class Solution {
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return false;
        }
        for(Integer item : A) {
            if(item == target) {
                return true;
            }
        }
        return false;
    }
}

//Search in Rotated Sorted Array 
public class Solution {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] == A[start]) {
                return mid;
            }
            else if(A[mid] > A[start]) {
                if(A[start] <= target && target <= A[mid]) {
                    end = mid;
                }
                else {
                    start = mid;
                }
            }
            else {
                if(A[mid] <= target && target <= A[end]) {
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
        }
        if(A[start] == target) {
            return start;
        }
        else if(A[end] == target) {
            return end;
        }
        else {
            return -1;
        }
    }
}
//search for a range
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(A == null || A.length == 0) {
            return res;
        }
        res[0] = findFirstIndex(A, target);
        res[1] = findLastIndex(A, target);
        return res;
    }
    private int findFirstIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] >= target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if(A[start] == target) {
            return start;
        }
        else if(A[end] == target) {
            return end;
        }
        else {
            return -1;
        }
    }
    private int findLastIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(A[end] == target) {
            return end;
        }
        else if(A[start] == target) {
            return start;
        }
        else {
            return -1;
        }
    }
}
//total occurence of target
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(A == null || A.length == 0) {
            return 0;
        }
        res[0] = findFirstIndex(A, target);
        res[1] = findLastIndex(A, target);
        if(res[0] == -1 || res[1] == -1) {
            return 0;
        }
        else {
            return res[1] - res[0] + 1;
        }
    }
     private int findFirstIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] >= target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if(A[start] == target) {
            return start;
        }
        else if(A[end] == target) {
            return end;
        }
        else {
            return -1;
        }
    }
    private int findLastIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(A[end] == target) {
            return end;
        }
        else if(A[start] == target) {
            return start;
        }
        else {
            return -1;
        }
    }
}
//search insert position
public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] == target) {
                return mid;
            }
            else if(A[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if(A[start] >= target) {
            return start;
        }
        else if(A[end] >= target) {
            return end;
        }
        else {
            return end + 1;
        }
    }
}

//find peak
class Solution {
    public int findPeak(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            }
            else if(A[mid - 1] < A[mid]) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(A[start] > A[end]) {
            return start;
        }
        else {
            return end;
        }
    }
}
//sqrt(x)
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x < 1) {
            return 0;
        }
        long target = x;
        long start = 1;
        long end = x;
        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            //在这一步计算中有可能产生溢出，所以要转换成long
            if(mid * mid == target) {
                return (int)mid;
            }
            else if(mid * mid > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if(end * end == target) {
            return (int)end;
        }
        else return (int)start;
    }
}
//pow
public class Solution {
    public double myPow(double x, int n) {
        if(x == 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        boolean isInverted = (n < 0) ? true : false;
        long num = Math.abs((long)n);
        double res = helper(x, num);
        return isInverted ? 1 / res : res;
    }
    private double helper(double x, long n) {
        if(x == 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        double half = helper(x, n / 2);
        double rest = helper(x, n - n / 2 - n / 2);
        return half * half * rest;
    }
}

//find minimum in rotated sorted array
得考虑两种情况，一种是已经rotated一种是没有rotate，综合比较起来直接先将end与mid来比较会更简洁
public class Solution {
    public int findMin(int[] num) {
        if(num == null || num.length == 0) {
            return 0;
        }
        int start = 0;
        int end = num.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(num[mid] <= num[end]) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return Math.min(num[start], num[end]);
    }
}
//count of smaller number
转换成找到最后一个比target number小的index，然后返回index+1
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
//k closest number in sorted array
Algorithm:
        1. Find the first index that A[index] >= target
        2. set two pointers left = index - 1 and right = index
        3. compare A[left] and A[right] to decide move which pointer
public class Solution {
    public int[] kClosestNumbers(int[] A, int target, int k) {
        int[] result = new int[k];
        if (A == null || A.length == 0) {
            return result;
        }
        if (k > A.length) {
            return A;
        }
        int index = firstIndex(A, target);
        int left = index - 1, right = index;
        for (int i = 0; i < k; i++) {
            if (left >= 0 && right < A.length && Math.abs(target - A[left]) < Math.abs(target - A[right])) {
                result[i] = A[left--];
            } else if (left >= 0 && right < A.length && Math.abs(target - A[left]) > Math.abs(target - A[right])) {
                result[i] = A[right++];
            } else if(left >= 0 && right < A.length && Math.abs(target - A[left]) == Math.abs(target - A[right])){
                if ( A[left] < A[right]) {
                    result[i] = A[left];
                    if(i + 1 < k) {
                        result[++i] = A[right];
                    }
                } else {
                    result[i] = A[right];
                    if(i + 1 < k) {
                        result[++i] = A[left];
                    }
                }
                left--;
                right++;
            }
            else if(left == -1 && right < A.length) {
                result[i] = A[right++];
            }
            else if(right == A.length && left >= 0) {
                result[i] = A[left--];
            }
        }
        return result;
    }
    private int firstIndex(int[] A, int target) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {i
                start = mid;
            } else if (A[mid] >= target) {
                end = mid;
            } 
        }
        if (A[start] >= target) {
            return start;
        }
        if (A[end] >= target) {
            return end;
        }
        return A.length;
    }
}
