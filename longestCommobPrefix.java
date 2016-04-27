时间Onk，n是个数，k是每个string平均长度
public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) {
			return new String();
		}
		int length = strs.length;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < strs[0].length; i++) {
			char c = strs[0].charAt(i);
			for(int j = 1; j < length; j++) {
				if(j == strs[j].length() || strs[j].charAt(i) != c) {
					return sb.toString();
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}
}