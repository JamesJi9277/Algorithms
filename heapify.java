// Given an integer array, heapify it into a min-heap array.

// For a heap array A, A[0] is the root of heap, 
// and for each A[i], A[i * 2 + 1] is the left child of A[i] 
// and A[i * 2 + 2] is the right child of A[i].
// Example
// Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.

// Challenge
// O(n) time complexity

// Clarification
// What is heap?

// Heap is a data structure, which usually have three methods: push, pop and top. where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, "top" return the minimum/maximum element.

// What is heapify?
// Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].

// What if there is a lot of solutions?
// Return any of them.
http://blog.csdn.net/morewindows/article/details/6709644
public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return;
        }
        for(int i = nums.length / 2 - 1; i >= 0; i--) {
            minHeapFixDown(nums, i);
        }
        return;
    }
    private void minHeapFixDown(int[] nums, int i) {
        int temp = nums[i];
        int j = 2 * i + 1;
        while(j < nums.length) {
            if(j + 1 < nums.length && nums[j + 1] < nums[j]) {
                j = j + 1;
            }
            if(nums[j] >= temp) {
                break;
            }
            nums[i] = nums[j];
            i = j;
            j = 2 * i + 1;
        }
        nums[i] = temp;
    }
}

public class Solution {
    public void heapify(int[] A) {
        if(A == null || A.length == 0) {
            return;
        }
        for(int i = A.length / 2 - 1; i >= 0; i--) {
            siftDown(A, i);
        }
        return;
    }
    private void siftDown(int[] nums, int i) {
        int j = 2 * i + 1;
        int temp = nums[i];
        while(j < nums.length) {
            if(j + 1 < nums.length && nums[j + 1] < nums[j]) {
                j++;
            }
            if(nums[j] >= temp) {
                break;
            }
            nums[i] = nums[j];
            i = j;
            j = 2 * j + 1;
        }
        nums[i] = temp;
    }
}