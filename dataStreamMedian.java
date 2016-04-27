// Numbers keep coming, return the median of numbers at every time a new number added.

// Have you met this question in a real interview? Yes
// Example
// For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].

// For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].

// For numbers coming list: [2, 20, 100], return [2, 2, 20].

// Challenge
// Total run time in O(nlogn).

// Clarification
// What's the definition of Median? 
// - Median is the number that in the middle of a sorted array. 
// If there are n numbers in a sorted array A, the median is A[(n - 1) / 2]. 
// For example, if A=[1,2,3], median is 2. If A=[1,19], median is 1.
public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        //just test
        if(nums == null || nums.length == 0) {
            return null;
        	return null;
        }
        int[] res = new int[nums.length];
        //left half and the median are stored in the maxHeap. median == maxHeap.peek()
        //right half of the median are stored in the minHeap.
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
        	@Override
        	public int compare(Integer x, Integer y) {
        		return y - x;
        	}
        });
        res[0] = nums[0];
        maxHeap.add(nums[0]);

        for(int i = 1; i < nums.length; i++) {
        	int x = maxHeap.peek();
        	if(nums[i] <= x) {
        		maxHeap.add(nums[i]);
        	}
        	else {
        		minHeap.add(nums[i]);
        	}
        	//maxHeap.size() == minHeap.size() || maxHeap.size() == minHeap.size() + 1;
        	if(maxHeap.size() > minHeap.size() + 1) {
        		minHeap.add(maxHeap.poll());
        	}
        	else if(maxHeap.size() < minHeap.size()) {
        		maxHeap.add(minHeap.poll());
        	}
        	res[i] = maxHeap.peek();
        }
        return res;
    }
}



class MedianFinder {
    Cmp cmp1 = new Cmp();
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(cmp1);
    private class Cmp implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return (minHeap.size() > maxHeap.size()) ? minHeap.peek() : ((minHeap.peek() + maxHeap.peek()) / 2.0);
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();