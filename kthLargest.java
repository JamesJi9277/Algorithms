时间Onlogk，空间Ok，k是heap的size
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
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
时间Onlogn，空间On的两种heap做法
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        Cmp cmp1 = new Cmp();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(cmp1);
        for(Integer item : nums) {
            maxHeap.offer(item);
        }
        while(--k > 0) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }
    private class Cmp implements Comparator<Integer>{
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(Integer item : nums) {
            minHeap.offer(item);
        }
        int count = nums.length - k + 1;
        while(--count > 0) {
            minHeap.poll();
        }
        return minHeap.poll();
    }
}
时间On，空间O1，quick select算法
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        return findKth(nums, nums.length - k + 1, 0, nums.length - 1);//倒数第k个是正数第length - k + 1个
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