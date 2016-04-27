//time O(n), space O(n)
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        int[] copy = new int[length];
        for(int i = 0; i < length; i++) {
            copy[(i + k) % length] = nums[i]  ;
        }
        for(int i = 0; i < length; i++) {
            nums[i] = copy[i];
        }
        return;
    }
}

//time O(n), space O(1)
public class Solution{
	public void rotate(int[] nums, int k){
		if(nums == null ||nums.length == 0)
			return;
		int length = nums.length;
    k = k % length;
    if(k <= 0) {
      return;
    }
    int index = k;
    int head = 0;
    int cur = nums[0];
    //index is the index of the element we will update at each iteration
    //head is head of a loop(is exist) for index since each time we move index k steps further
    //cur is the value got from previous iteration nums[preIndex] nd for updating nums[index]
    for(int count = 0; count < nums.length; count++) {
      if(index == head){
        nums[index] = cur;//set the value of loop
        head++;//move 1 step further to jump out of loop
        cur = nums[++index];//this is the head of new loop
        index = (index + k) % length;
      }//loop detected
      else {//each time go k steps further
        int temp = nums[index];
        nums[index] = cur;
        cur = temp;
        index = (index + k) % length;
      }
    }
	}
}

//time 0(n), space O(1)
//做这个题的时候注意不要从头开始来数k，而是从尾巴来利用length - k来的都移动的距离长度
//还有一个trick的地方那个就是为了避免循环移动，一开始可以对k做k = k % length的操作
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return;
        }
        k = k %(nums.length);
        doReverse(nums, 0, nums.length - k - 1);
        doReverse(nums, nums.length - k , nums.length - 1);
        doReverse(nums, 0, nums.length - 1);
        return;
    }
    private void doReverse(int[] nums, int start, int end) {
        for(int i = 0; start + i < end - i; i++) {
            int temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
        return;
    }
}
