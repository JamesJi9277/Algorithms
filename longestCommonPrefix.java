//brute force，以第一个为基准，后面的开始一个一个的扫，如果只要扫到不同，那么就跳出循环返回当前结果
//时间复杂度是O(mn)，m是最长字符串长度，n四字符串个数
//空间复杂度是O(n)。因为用了一个stringbuffer
// 以上代码设置了一个标记，来标记是否结束。中间那个循环index是从0开始，
// 按理说不用对第一个字符串进行判断了，因为他是标准，
// 这么做的目的其实是因为leetcode有一个测试集是空串，如果不对0进行判断，
// 那么就没有设置flag为false，跑到第二层就会越界。当然也可以手动判断一下，这个其实是小问题。
时间复杂度Onk,k是平均每个字符串长度，n是字符串个数
空间复杂度On
public class Solution{
	public String longestCommonPrefix(String[] strs){
		if(strs == null || strs.length == 0) {
			return "";
		}
		int length = strs.length;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for(int j = 1; j < length; j++) {
				if(i == strs[j].length() || strs[j].charAt(i) != c) {
					return sb.toString();
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}
}

时间复杂度Onk，空间复杂度O1
public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if(strs == null || strs.length == 0) {
    		return "";
    	}
    	for(int i = 0; i < strs[0].length(); i++) {
    		for(int j = 1; j < strs.length; j++) {
    			if(i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
    				return strs[0].substring(0, i);
    			}
    		}
    	}
    	return strs[0];
    }
}