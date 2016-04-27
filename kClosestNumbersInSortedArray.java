Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.

Have you met this question in a real interview? Yes
Example
Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].

Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].

time Onlogk， space Ok 
public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    private class Comp implements Comparator<Integer> {
        Integer target;
        Comp(Integer target) {
            this.target = new Integer(target);
        }
        public int compare(Integer o1, Integer o2) {
            int dis1 = Math.abs(o1 - target);
            int dis2 = Math.abs(o2 - target);
            if(dis1 > dis2) {
                return 1;
            }
            else if(dis1 < dis2) {
                return -1;
            }
            else {
                if(o1 > o2) {
                    return 1;
                }
                else if(o1 < o2) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
    }
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        int[] res = new int[k];
        if(A == null || A.length == 0) {
            return A;
        }
        Comp cmp = new Comp(target);
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(A.length, cmp);
        for(int i = 0; i < A.length; i++) {
            heap.offer(A[i]);
        }
        int i = 0;
        while(k-- > 0) {
            res[i] = heap.poll();
            i++;
        }
        return res;
    }
}



Challenge
O(logn + k) time complexity.
Algorithm:
        1. Find the first index that A[index] >= target
        2. set two pointers left = index - 1 and right = index
        3. compare A[left] and A[right] to decide move which pointer

public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
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
            if (A[mid] < target) {
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
