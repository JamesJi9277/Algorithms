// Given a string containing only digits, restore it by returning all possible valid IP address combinations.

// For example:
// Given "25525511135",

// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        findIP(res, s, "", 0);
        return res;
    }
    private void findIP(List<String> res, String s, String temp, int count) {
        if(count == 3 && isValid(s)) {
            res.add(temp + s);
            return;
        }
        for(int i = 0; i < 3 && i < s.length() - 1;i++) {
            String subString = s.substring(0, i + 1);
            if(isValid(subString)) {
                findIP(res, s.substring(i + 1), temp + subString + '.', count + 1);
            }
        }
    }
    private boolean isValid(String s) {
        if(s.charAt(0) == '0') {
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        return (num <= 255 && num > 0);
    }
}