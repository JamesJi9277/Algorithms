public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            }
            else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for(int i = 0; i < t.length();i++) {
            char c = t.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
            else {
                return false;
            }
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}

group anagrams
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) {
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String str1 = helper(str);
            if(map.containsKey(str1)) {
                List<String> temp = map.get(str1);
                temp.add(str);
                map.put(str1, temp);
            }
            else {
                List<String> temp = new ArrayList<String>();
                temp.add(str);
                map.put(str1, temp);
            }
        }
        for(String str : map.keySet()) {
            res.add(map.get(str));
        }
        return res;
    }
    private String helper(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
}