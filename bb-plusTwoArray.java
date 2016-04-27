
public class plus {
	public int[] plusTwoArrays(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null) {
			return (nums1 == null) ? nums2 : nums1;
		}
		int index1 = nums1.length - 1;
		int index2 = nums2.length - 1;
		int[] res = new int[Math.max(nums1.length, nums2.length) + 1];
		int index = res.length - 1;
		int carry = 0;
		while(index1 >= 0 && index2 >= 0) {
			int digit = (nums1[index1] + nums2[index2] + carry) % 10;
			carry = (nums1[index1] + nums2[index2] + carry) / 10;
			res[index--] = digit;
			index1--;
			index2--;
		}
		while(index1 >= 0) {
			int digit = (nums1[index] + carry) % 10;
			carry = (nums1[index] + carry) / 10;
			res[index--] = digit;
			index1--;
		}
		while(index2 >= 0) {
			int digit = (nums2[index] + carry) % 10;
			carry = (nums2[index] + carry) / 10;
			res[index--] = digit;
			index2--;
		}
		if(carry == 1) {
			res[index] = 1;
		}
		return res;
	}
	public static void main(String[] args) {
		plus p = new plus();
		int[] nums1 = {3,2,1};
		int[] nums2 = {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,2,3};
		int[] res = p.plusTwoArrays(nums1, nums2);
		for(Integer item : res) {
			System.out.print(item);
		}
	}
}
