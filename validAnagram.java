// Given two strings s and t, write a function to determine if t is an anagram of s.

// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.

// Note:
// You may assume the string contains only lowercase alphabets.
//time On, space O(n)
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] res = new int[26];
        for(int i = 0; i < s.length(); i++) {
        	res[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++) {
        	res[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
        	if(res[i] != 0) {
        		return false;
        	}
        }
        return true;
    }
}
//time O(nlogn), space O(n)
public class Solution {
	public boolean isAnagram(String s, String t) {
		if(s == null && t == null) {
			return true;
		}
		if(s == null || t == null) {
			return false;
		}
		char[] s1 = s.toCharArray();
		char[] t1 = t.toCharArray();
		Arrays.sort(s1);
		Arrays.sort(t1);
		return Arrays.equals(s1, t1);
	}
}

//time On, space O(n)
public class Solution {
	public boolean isAnagram(String s, String t) {
		if(s == null && t == null) {
			return true;
		}
		if(s == null || t == null) {
			return false;
		}
		if(s.length() != t.length()) {
		    return false;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			}
			else {
				map.put(s.charAt(i), 1);
			}
		}
		for(int i = 0; i < t.length(); i++) {
			if(map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
			}
		}
		for(int i = 0; i < s.length(); i++) {
			if(map.get(s.charAt(i)) != 0) {
				return false;
			}
		}
		return true;
	}
}