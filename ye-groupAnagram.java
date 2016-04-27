public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) {
            return res;
        }
        Arrays.sort(strs);
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