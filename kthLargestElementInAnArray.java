// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ array's length.
//time complexity O(nlogn), space O(1)
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
//填坑法的quick select
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        return findKth(nums, nums.length - k + 1, 0, nums.length - 1);
    }
    private int findKth(int[] nums, int k, int start, int end) {
        int left = start;
        int right = end;
        int pivot = nums[left];
        while(left < right) {
            while(left < right && nums[right] > pivot) {
                right--;
            }
            if(left < right) {
                nums[left] = nums[right];
                left++;
            }
            while(left < right && nums[left] <= pivot) {
                left++;
            }
            if(left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        if(left + 1 == k) {
            return pivot;
        }
        else if(left + 1 < k) {
            return findKth(nums, k, left + 1, end);
        }
        else {
            return findKth(nums, k, start, left - 1);
        }
    }
}

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for(Integer item : nums) {
            if(minHeap.size() < k) {
                minHeap.offer(item);
            }
            else {
                if(minHeap.peek() < item) {
                    minHeap.poll();
                    minHeap.offer(item);
                }
            }
        }
        return minHeap.poll();
    }
}


public class Solution {
    private class Comp implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Comp cmp = new Comp();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length - k + 1, cmp);
        for(Integer item : nums) {
            if(maxHeap.size() < nums.length - k + 1) {
                maxHeap.offer(item);
            }
            else {
                if(maxHeap.peek() > item) {
                    maxHeap.poll();
                    maxHeap.offer(item);
                }
            }
        }
        return maxHeap.poll();
    }
}