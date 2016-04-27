import java.util.Arrays;

//consider overflow
public class subarrayProduct {
//	public boolean equalTarget(int[] array, int target) {
//		if(array == null || array.length == 0) {
//			return false;
//		}
//		long t = (long)target;
//		int length = array.length;
//		for(int i = 0; i < length; i++) {
//			for(int j = 0; j < length;j++) {
//				long product = getProduct(array, i, j);
//				if(product == t) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//	private long getProduct(int[] nums, int i, int j) {
//		long res = 1L;
//		for(int k = i; k <= j; k++) {
//			res *= nums[k];
//		}
//		return res;
//	}
//	public boolean equalTarget(int[] nums, int target) {
//		if(nums == null || nums.length == 0) {
//			return false;
//		}
//		Long[] prefixProduct = new Long[nums.length];
//		int length = nums.length;
//		for(int i = 0; i < length; i++) {
//			prefixProduct[i] = (i == 0) ? (long)nums[0] : (long)(nums[i] * prefixProduct[i - 1]);
//		}
//		long t = (long)target;
//		for(int i = 0; i < length; i++) {
//			for(int j = i + 1; j < length; j++) {
//				if(prefixProduct[j]/prefixProduct[i] == t) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	public boolean equalTarget(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return false;
		}
		int left = 0;
		int right = 0;
		int length = nums.length;
		long product = 1L;
		long t = Math.abs(target);
		boolean hasOddMinus = false;
		while(left < length && right < length) {
			if(left < length && right < length && nums[right] < 0) {
				if(hasOddMinus == false) {
					hasOddMinus = true;
				}
				else {
					hasOddMinus = false;
				}
			}
			if(left < length && right < length) {
				product *= Math.abs(nums[right]);
			}
			if(product == t) {
				if((hasOddMinus == true && target < 0) || (hasOddMinus == false && target > 0)) {
					return true;
				}
				else {
					return false;
				}
			}
			else if(left < length && right < length && product < t) {
				right++;
			}
			else if(left < length && right < length && product > t){
				if(nums[left] < 0) {
					if(hasOddMinus == false) {
						hasOddMinus = true;
					}
					else {
						hasOddMinus = false;
					}
				}
				product /= Math.abs(nums[left++]);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		subarrayProduct s = new subarrayProduct();
		int[] array = {1,-2,3,4,-5,6};
		System.out.println(s.equalTarget(array, 120));
		System.out.println(s.equalTarget(array, 20));
		System.out.println(s.equalTarget(array, 30));
	}
}
