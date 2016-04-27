import java.util.*;
public class twoString {
	public String getSum(String ss1, String ss2) {
		char[] s1 = ss1.toCharArray();
		char[] s2 = ss2.toCharArray();
		StringBuffer sb = new StringBuffer();
		int carry = 0;
		int index1 = s1.length - 1;
		int index2 = s2.length - 1;
		while(index1 >= 0 && index2 >= 0) {
			int digit1 = s1[index1] - '0';
			int digit2 = s2[index2] - '0';
			int digit = (digit1 + digit2 + carry) % 10;
			carry = (digit1 + digit2 + carry) / 10;
			sb.append(digit + "");
			index1--;
			index2--;
		}
		while(index1 >= 0) {
			int digit1 = s1[index1] - '0';
			int digit = (digit1 + carry) % 10;
			carry = (digit1 + carry) / 10;
			sb.append(digit + "");
			index1--;
		}
		while(index2 >= 0) {
			int digit2 = s1[index2] - '0';
			int digit = (digit2 + carry) % 10;
			carry = (digit2 + carry) / 10;
			sb.append(digit + "");
			index2--;
		}
		if(carry == 1) {
			sb.append(1 + "");
		}
		int start = 0;
		int end = sb.length() - 1;
		for(int i = 0; start + i < end - i; i++) {
			char c = sb.charAt(start + i);
			sb.setCharAt(start + i, sb.charAt(end - i));
			sb.setCharAt(end - i, c);
		}
		return sb.toString();
	}
	public String getProduct(String s1, String s2) {
		if(s1 == null || s2 == null) {
			return s1 == null ? s2 : s1;
		}
		int length1 = s1.length();
		int length2 = s2.length();
		int[] nums = new int[length1 + length2];
		for(int i = length1 - 1; i >= 0; i--) {
			for(int j = length2 - 1; j >= 0; j--) {
				int temp = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
				nums[i + j] += (nums[i + j + 1] + temp) / 10;
				nums[i + j + 1] = (nums[i + j + 1] + temp) % 10;
			}
		}
		StringBuffer sb = new StringBuffer();
		for(int i : nums) {
			if(sb.length() > 0 || i > 0) {
				sb.append(i);
			}
		}
		return sb.length() == 0 ? "0" : sb.toString(); 
	}
	public String getSubtract(String s1, String s2) {

	}
	public static void main(String[] args) {
		twoString t = new twoString();
		String s1 = "123456789";
		String s2 = "987654321";
		System.out.println(t.getSum(s1, s2));
		System.out.println(t.getProduct(s1, s2));
	}
}