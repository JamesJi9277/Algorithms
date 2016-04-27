import java.util.*;
public class longestPath {
	public int longestPath(String files) {
		if(files == null || files.length() == 0) {
			return 0;
		}
		String[] strs = files.split("\n");
		Stack<String> stack = new Stack<String>();
		stack.push(strs[0]);
		int max = strs[0].length() + 1;
		int count = max;
		int space = 0;
		for(int i = 1; i < strs.length; i++) {
			for(int j = 0; j < strs[i].length(); j++) {
				if(strs[i].charAt(j) == ' ') {
					space++;
				}
				else {
					break;
				}
			}
			if(space == stack.size()) {
				if(strs[i].contains(".")) {
					max = Math.max(max, (strs[i].contains("jpeg") || strs[i].contains("gif")) ? count + strs[i].length() - space : 0);
				}
				else {
					stack.push(strs[i]);
					count += (strs[i].length() + 1 - space);
				}
			}
			else if(space < stack.size()) {
				while(space < stack.size()) {
					String temp = stack.pop();
					count -= (temp.length() + 1 - space);
				}
				stack.push(strs[i]);
				count += (strs[i].length() + 1 - space);
			}
			space = 0;
		}
		return max;
	}
	public static void main(String[] args) {
		String files = "dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif\n";
		longestPath l = new longestPath();
		System.out.println(l.longestPath(files));
	}
}


public class Solution {
	public int longestPath(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		s = s.trim();
		String[] strs = s.split("\n");
		int max = 1 + strs[0].length();
		
	}
}