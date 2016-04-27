import java.util.HashSet;
import java.util.Stack;

public class suffixTree {
	public String findLongestRepeatedSubstring(String str) {
		if(str == null || str.length() == 0) {
			return "";
		}
		int length = str.length();
		Stack<String> stack = new Stack<String>();
		HashSet<String> set = new HashSet<String>();
		stack.push("");
		for(int i = 0; i < length; i++) {
			for(int j = i + 1; j <= length; j++) {
				String subString = str.substring(i, j);
				if(set.contains(subString) && !stack.isEmpty()) {
					String temp = stack.peek();
					if(subString.length() >= temp.length()) {
						stack.push(subString);
					}
				}
			set.add(subString);
			}
		}
		return stack.pop();
	}
	public static void main(String[] args) {
		suffixTree s = new suffixTree();
		System.out.println(s.findLongestRepeatedSubstring("banana"));
	}
}

public class Solution {
	public String findLongestRepeatedSubstring(String str) {
		if(str == null || str.length() == 0) {
			return "";
		}
		int length = str.length();
		int maxLength = Integer.MIN_VALUE;
		String result = "";
		for(int i = 0; i < length; i++) {
			for(int j = i + 1; j < length; j++) {
				if(s.charAt(j) == s.charAt(i)) {
					int temp = getMaxLength(i, j, str);
					if(temp > maxLength) {
						maxLength = temp;
						result = s.substring(i, i + maxLength);
					}
				}
			}
		}
		return result;
	}
	private int getMaxLength(int i, int j, String s) {
		int length = 0;
		while(i < j && j < s.length() && s.charAt(i) == s.charAt(j)) {
			length++;
			i++;
			j++;
		}
		return length;
	}
}