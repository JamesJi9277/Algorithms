Given a list of integers and a window size, return a new list of integers where each integer in the sum
of all integers in the kth window of the input list.
The kth windows of the input list is the integers from index k to index k + window.size - 1()inclusive;
For example,[4,2,73,11,-5] and window size 2 should return [6, 75,84,6]. 
For another example[4,2,73,11,-5]and windowsize3 should return [79, 86, 79]

public class listIntegerAndWindowSize {
	public ArrayList<Integer> findSum(int[] nums, int winSize) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0 || winSize > nums.length) {
			return res;
		}
		for(int i = 0; i < nums.length - winSize + 1; i++) {
			int temp = 0;
			for(int j = 0; j < winSize; j++) {
				temp += nums[i + j];
			}
			res.add(temp);
		}
	}
	public static void main(String[] args) {
		listIntegerAndWindowSize l = new listIntegerAndWindowSize();
		int[] nums = {4,2,73,11,-5};
		ArrayList<Integer> res = l.findSum(nums, 2);
		for(Integer item : res) {
			System.out.print(" " + item + " , ")
		}
	}
}