// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

// For example,
// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Therefore, return the max sliding window as [3,3,5,5,6,7].

// Note: 
// You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
//time complexity O(n2)
public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length < 2) {
			return nums;
		}
		ArrayList<Integer> buffer = new ArrayList<Integer>();
		if(nums.length <= k) {
			int max = findMax(nums);
			int[] res = new int[1];
			res[0] = max;
			return res;
		}
		for(int i = 0; i <= nums.length - k; i++) {
			int[] temp = new int[k];
			for(int j = 0 ; j < k; j++) {
			    temp[j] = nums[j + i];
			}
			int max = findMax(temp);
			buffer.add(max);
		}
		int[] res = toInt(buffer);
		return res;
	}
	private int findMax(int[] nums) {
		int max = nums[0];
		for(int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		return max;
	}
	private int[] toInt(ArrayList<Integer> list) {
		int[] res = new int[list.size()];
		for(int i = 0; i < res.length; i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
//time complexity O(nlogn)
public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length < 2) {
			return nums;
		}
		PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		Queue<Integer> queue = new ArrayDeque<Integer>();
		int[] res = new int[nums.length - k + 1];
		for(int i = 0; i < k; i++) {
			queue.offer(nums[i]);
			pqueue.offer(nums[i]);
		}
		res[0] = pqueue.peek();
		for(int i = 1; i < res.length; i++) {
			int r = queue.poll();
			pqueue.remove(r);
			queue.offer(nums[i + k - 1]);
			pqueue.offer(nums[i + k - 1]);
			res[i] = pqueue.peek();
		}
		return res;
	}
}
// Follow up:
// Could you solve it in linear time?
public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length < 2) {
			return nums;
		}
		int length = nums.length;
		int[] res = new int[length - k + 1];
		int ri = 0;
		Deque<Integer> queue = new ArrayDeque<>();
		for(int i = 0; i < length; i++) {
			//remove number out of range k
			while(!queue.isEmpty() && queue.peek() < i - k + 1) {
				queue.poll();
			}
			//remove smaller numbers in k range as they are useless
			while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
				queue.pollLast();
			}
			//queue contains index... res contains content
			queue.offer(i);
			if(i >= k - 1) {
				res[ri++] = nums[queue.peek()];
			}
		}
		return res;
	}
}
// Hint:

// How about using a data structure such as deque (double-ended queue)?
// The queue size need not be the same as the window’s size.
// Remove redundant elements and the queue should store only elements that need to be considered.
// The idea of the solution is to maintain two stacks: s1 and s2. 
// We hope s1's peek is always to keep the largest value in the current k numbers. 
// So we use s1 to store the numbers whose index is in increasing order and values is in decreasing order. 
// For example give k=4 numbers 1, 3 ,9, 6. s1 only need to store 9 and 6 with 9 is on the peek of the stack.

// When we slide the window, 
// we need to keep dumping the numbers at the left end of the window and adding new numbers on the right end of the window.
//  When we have a new number in the window, we push just the new number in stack s2. 
//  Also, we keep record the largest value in s2. If the peek of s1 is smaller than the largest value in s2, 
//  it means the largest value in the current k numbers is in s2. 
//  Thus, we need to empty s1 and move the elements stored in s2 to s1. 
//  Note that we do not need to move all the elements in s2 to s1. 
//  Only the numbers whose index is in increasing order and values is in decreasing order are pushed into s1.

// For example, 1,3,9,6,7,1, 2 , 5 given k=4 
// step 1: window 1,3,9,6 s1: 9, 6 s2:empty maxInStack2=Integer.MINVALUE; 
// step 2: window 3,9,6,7 s1: 9,6 s2:7 maxInStack2=7 
// step3: window 9,6,7,1 s1: 9, 6 s2:7,1 maxInStack2=7 
// step4: window 6,7,1, 2 note 9 is removed from window, so s1: 6 s2: 7, 1 ,2 maxInStack2=7 
// Then we find that maxInStack2> s1.peek(). update s1. 
// After updating s1, we have s1: 7, 2 s2: empty maxInStack2=Integer.MINVALUE; 
// step5: window 7,1,2,5 s1:7,2 s2:5, maxInStack2=5; In worst case, every number in the array is visited twice. 
// Thus the complexity is O(n)
public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return nums;
		}
		int[] res = new int[nums.length - k + 1];
		int maxInStack2 = Integer.MIN_VALUE;
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		for(int i = k - 1; i >= 0; i--) {
			if(s1.isEmpty()) {
				s1.push(nums[i]);
			}
			else if (nums[i] >= s1.peek()) {
				s1.push(nums[i]);
			}
		}
		res[0] = s1.peek();
		for(int i = 1; i < res.length; i++) {
			int newItem = nums[i + k - 1];
			int removeItem = nums[i - 1];
			if(removeItem == s1.peek()) {
				s1.pop();
			}
			if(newItem > maxInStack2) {
				maxInStack2 = newItem;
			}
			s2.push(newItem);
			if(s1.isEmpty() || maxInStack2 > s1.peek()) {
				while(!s1.isEmpty()) {
					s1.pop();
				}
				while(!s2.isEmpty()) {
					int temp = s2.pop();
					if(s1.isEmpty() || temp >= s1.peek()) {
						s1.push(temp);
					}
				}
				res[i] = maxInStack2;
				maxInStack2 = Integer.MIN_VALUE;
			}
			else {
				res[i] = s1.peek();
			}
		}
		return res;
	}
}