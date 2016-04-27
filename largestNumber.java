// Given a list of non negative integers, arrange them such that they form the largest number.

// For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

// Note: The result may be very large, so you need to return a string instead of an integer.
public class Solution {
	public String largestNumber(int[] nums) {
		if(nums == null || nums.length == 0) {
			return "";
		}
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < nums.length; i++) {
			list.add(num[i] + "");
		}
		Collections.sort(list, new largestNum());
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}

		if(sb.toString().charAt(0) == '0') {
			return "0";
		}
		return sb.toString();
	}

	private class largestNum implements Comparator<String> {
    // idea is if the strings are of different lengths, append them together in the two possible ways 
    // and see which way of appending is better
		public int compare(String str1, String str2) {
			if(str1.equals(str2)) {
				return 0;
			}
			if(str1.length() != str2.length()) {
				return compare(str1 + str2, str2 + str1);
			}
			//跟max Heap构造法一样
			for(int i = 0; i < str1.length(); i++) {
				if(str1.charAt(i) > str2.charAt(i)) {
					return -1;
				}
				else if(str1.charAt(i) < str2.charAt(i)) {
					return 1;
				}
			}
			return 0;
		}
	}
}
