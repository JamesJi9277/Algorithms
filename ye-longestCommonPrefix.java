
这题的关键是要先从strs[0]的char来开始判断，不然就会有corner case不会考虑到比如asb,"", nn存在这种是""的char来开始判断，不然就会有corner case
public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) {
			return new String();
		}
		if(strs.length == 1) {
			return strs[0];
		}
		for(int i = 0; i < strs[0].length(); i++) {
		    for(int j = 1; j < strs.length; j++) {
		        if(i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)) {
		            return strs[0].substring(0, i);
		        }
		    }
		}
		return strs[0];
	}
}