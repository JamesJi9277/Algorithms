public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) {
        	return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(c1.length != c2.length) {
        	return false;
        }
        for(int i = 0; i < c1.length; i++) {
        	if(c1[i] != c2[i]) {
        		return false;
        	}
        }
        return true;
    }
}

counting 
public class Solution {
	public boolean isAnagram(String s, String t) {
		if(s == null || t == null) {
			return false;
		}
		int[] count = new int[26];
		for(int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		for(int i = 0; i < t.length(); i++) {
			count[t.charAt(i) - 'a']--;
		}
		for(int i = 0; i < 26; i++) {
			if(count[i] != 0) {
				return false;
			}
		}
		return true;
	}
}