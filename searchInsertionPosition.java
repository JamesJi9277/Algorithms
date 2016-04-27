//time complexity is O(logn)
//以上实现方式有一个好处，就是当循环结束时，
//如果没有找到目标元素，那么l一定停在恰好比目标大的index上，r一定停在恰好比目标小的index上
//如果是奇数的情况，那么mid取值为后一个
//Given a sorted array and a target value,
//return the index if the target is found.
//If not, return the index where it would be if it were inserted in order.

//You may assume no duplicates in the array.
public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0)
        return 0;
        int l = 0;
        int r = A.length - 1;
        int t = target;
        while(l <= r)
        {
            int mid = l + (r-l)/2;
            if(A[mid] == t)
            return mid;
            if(A[mid] > t)
            r = mid -1;
            else l = mid +1;
        }return l;
    }
}
