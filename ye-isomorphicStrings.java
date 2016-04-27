Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.


public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) {
        	return false;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        int length = s.length();
        for(int i = 0; i < length; i++) {
        	if(map.containsKey(s.charAt(i))) {
        		if(map.get(s.charAt(i)) != t.charAt(i)) {
        			return false;
        		}
        	}
        	else if(map.containsValue(t.charAt(i))) {
        		return false;
        	}
        	map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}