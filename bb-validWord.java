给一个长度为7的string比如gallery...
输出所有valid word然后是这个string的permutation或者删掉一个字符的permutation.
valid words都在一个dictionary里面
1.因为给定的长度就为7.可以考虑直接生成所有的premutation再去比较
2.用dict每一个排序后去与原来的作比较
public class Solution {
	public ArrayList<String> find(String ss, ArrayList<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		if(s == null || s.length() == 0) {
			return res;
		}
		String s = helper(ss);
		for(String str : dict) {
			char[] arr = str.toCharArray();
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			if(sb.toString().equals(s)) {
				res.add(str);
			}
		}
		for(int i = 0; i < ss.length(); i++) {
			StringBuffer sb = new StringBuffer(ss);
			sb.deleteCharAt(i);
			String s1 = helper(sb.toString());
			for(String str : dict) {
			char[] arr = str.toCharArray();
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < arr.length; i++) {
				sb.append(arr[i]);
			}
			if(sb.toString().equals(s)) {
				res.add(str);
			}
		}
		}
	}
	private String helper(String ss) {
		StringBuffer sb = new StringBuffer();
		char[] arr = ss.toCharArray();
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}
}