import java.util.*;
public class check {
	public boolean isPermutation(String s1, String s2) {
		if(s1 == null && s2 == null || s1.length() == 0 && s2.length() == 0) {
			return true;
		}
		if(s1 == null || s2 == null) {
			return false;
		}
		if(s1.equals(s2)) {
			return true;
		}
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		if(str1.length != str2.length) {
			return false;
		}
		Arrays.sort(str1);
		Arrays.sort(str2);
		for(int i = 0; i < str1.length; i++) {
			if(str1[i] != str2[i]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		check c = new check();
		String s1 = "";
		String s2 = "";
		System.out.print(c.isPermutation(s1, s2));
	}
}