Given an array of strings, return all groups of strings that are anagrams.

Have you met this question in a real interview? Yes
Example
Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

Note
All inputs will be in lower-case


public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<String>();
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
        for(ArrayList<String> tmp : map.values()) {
            if (tmp.size() > 1) {
                res.addAll(tmp);
            }
        }
        return res;
    }
}