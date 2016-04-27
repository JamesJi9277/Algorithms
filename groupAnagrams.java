// Given an array of strings, group anagrams together.

// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:

// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note:
// For the return value, each inner list's elements must follow the lexicographic order.
// All inputs will be in lower-case.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) {
            return res;
        }
        Arrays.sort(strs);
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String str1 = new String(arr);
            if(map.containsKey(str1)) {
                ArrayList<String> temp = map.get(str1);
                temp.add(str);
                map.put(str1, temp);
            }
            else {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(str);
                map.put(str1, temp);
            }
        }
        for(String str : map.keySet()) {
            res.add(map.get(str));
        }
        return res;
    }

    public static void main(String[] args) {
    	testing test = new testing();
    	String[] a = {"asd","dsa","sdsa","sadsa","asdasd","sad","asdasd"};
    	System.out.println(test.groupAnagrams(a));
    }
}