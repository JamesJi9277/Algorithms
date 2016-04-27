import java.util.*;
public class windowSum {
	public ArrayList<Integer> getSum(int[] nums, int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0) {
			return res;
		}
		LinkedList<Integer> deque = new LinkedList<Integer>();
		int sum = 0;
		for(int i = 0; i < k; i++) {
			deque.add(nums[i]);
			sum += nums[i];
		}
		res.add(sum);
		for(int i = k; i < nums.length; i++) {
			int temp = deque.removeFirst();
			sum -= temp;
			deque.addLast(nums[i]);
			sum += nums[i];
			res.add(sum);
		}
		return res;
	}
	public static void main(String[] args) {
		windowSum w = new windowSum();
		int[] nums = {1,2,3,4,5,6,7};
		int k = 5;
		ArrayList<Integer> res = w.getSum(nums, k);
		for(Integer item : res) {
			System.out.print(item + " ");
		}
	}
}
