public class arithmeticSequence {
	public void countSequence(int[] nums) {
		if(nums == null || nums.length == 0) {
			return;
		}
		int count = 0;
		for(int i = 0; i < nums.length - 2; i++) {
			for(int j = i + 2; j < nums.length; j++) {
				if(isValid(nums, i, j)) {
					count++;
				}
			}
		}
		System.out.println("The number is : " + count);
	}
	public void countSequence1(int[] nums) {
		if(nums == null || nums.length < 3) {
			return;
		}
		int start = 0;
		int end = 1;
		int runner = start;
		int count = 0;
		int increment = 0;
		while(end < nums.length) {
			increment = nums[end] - nums[start];
			while(end < nums.length && nums[end] - nums[runner] == increment) {
				end++;
				runner++;
			}
			if(runner - start > 1) {
				int length = (runner - start + 1);
				count += (length - 1) * (length - 2) / 2;
			}
			start = runner;
		}
		System.out.println("The number is : " + count);
	}
	public boolean isValid(int[] nums, int i, int j) {
		int index = i + 1;
		int crement = nums[index] - nums[i];
		while(index <= j) {
			if(nums[index] - nums[i] != crement) {
				return false;
			}
			i++;
			index++;
		}
		return true;
	}
	
	public void countSequence2(int[] array) {
		if (array == null || array.length < 3)	return ;
		int rvalue = 0, gap = array[1] - array[0], length = 2;
		for (int i = 1; i < array.length - 1; i++) {
			if (array[i+1] - array[i] == gap)	length++;
			else {
				gap = array[i+1] - array[i];
				if (length >= 3)
					rvalue += (length - 1) * (length - 2) / 2;
				if (rvalue > 1000000000)	return ;
				length = 2;
			}
		}
		if (length >= 3)
			rvalue += (length - 1) * (length - 2) / 2;
		 rvalue = (rvalue > 100000000) ? -1 : rvalue;
		 System.out.println(rvalue);
	}
	public static void main(String[] args) {
		arithmeticSequence a = new arithmeticSequence();
		int[] nums = {-1, 1,3,3,3,2,1,0, -1};
		a.countSequence1(nums);
		a.countSequence(nums);
		a.countSequence2(nums);
	}
}
