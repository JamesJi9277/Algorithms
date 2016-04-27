import java.util.*;
public class reverseWord {
	public String reverse(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		StringBuffer sb = new StringBuffer(s);
		int start = 0;
		int end = sb.length() - 1;
		for(int i = 0; start + i < end - i; i++) {
			char c = sb.charAt(start + i);
			sb.setCharAt(start + i, sb.charAt(end - i));
			sb.setCharAt(end - i, c);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		reverseWord r = new reverseWord();
		String s1 = "abc";
		String s2 = "I can get big offer!";
		System.out.println(r.reverse(s1));
		System.out.println(r.reverse(s2));
	}
}
