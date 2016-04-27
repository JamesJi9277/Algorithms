import.java.util.*;
public class hash {
	public long generateHash(String s) {
		long res = 0;
		for(int i = 0; i < s.length(); i++) {
			long digit = (long)s.charAt(i);
			res = 33* res + digit;
		}
		return res;
	}
	public static void main(String[] args) {
		hash h = new hash();
		String s = "abc";
		System.out.print(h.generateHash(s));
	}
}