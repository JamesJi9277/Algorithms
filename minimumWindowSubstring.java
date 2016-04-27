// 这道题是字符串处理的题目，
// 和Substring with Concatenation of All Words思路非常类似，
// 同样是建立一个字典，然后维护一个窗口。区别是在这道题目中，
// 因为可以跳过没在字典里面的字符（
// 也就是这个串不需要包含且仅仅包含字典里面的字符，有一些不在字典的仍然可以满足要求），
// 所以遇到没在字典里面的字符可以继续移动窗口右端，而移动窗口左端的条件是当找到满足条件的串之后，
// 一直移动窗口左端直到有字典里的字符不再在窗口里。
// 在实现中就是维护一个HashMap，一开始key包含字典中所有字符，value就是该字符的数量，
// 然后遇到字典中字符时就将对应字符的数量减一。算法的时间复杂度是O(n),
// 其中n是字符串的长度，因为每个字符再维护窗口的过程中不会被访问多于两次。
// 空间复杂度则是O(字典的大小)，也就是代码中T的长度

public class Solution {
	public String minWindow(String s, String t) {
		if(s == null || t == null || s.length() == 0 || t.length() == 0) {
			return "";
		}
		String res = "";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < t.length(); i++) {
			if(!map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i),1);
			}
			else{
				map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
			}
		}
		int count = 0;
		int pre = 0;
		int minLen = s.length() + 1;
		for(int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
				if(map.get(s.charAt(i)) >= 0) {
					count++;
				}
				while(count == t.length()) {
					if(map.containsKey(s.charAt(pre))) {
						map.put(s.charAt(pre), map.get(s.charAt(pre)) + 1);
						if(map.get(s.charAt(pre)) > 0) {
							if(minLen > i - pre + 1) {
								res = s.substring(pre, i + 1);
								minLen = i - pre + 1;
							}
							count--;
						}
					}
					pre++;
				}
			}
		}
		return res;
	}
}