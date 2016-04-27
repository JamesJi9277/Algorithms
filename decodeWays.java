// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.
public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] res = new int[length + 1];
        res[0] = 1;
        if(isValid(s.substring(0, 1))) {
            res[1] = 1;
        }
        else {
            res[1] = 0;
        }
        for(int i = 2; i <= length; i++) {
            if(isValid(s.substring(i - 1, i))) {
                res[i] += res[i - 1];
            }
            if(isValid(s.substring(i - 2, i))) {
                res[i] += res[i - 2];
            }
        }
        return res[length];
    }
    private boolean isValid(String s) {
        if(s.charAt(0) == '0') {
            return false;
        }
        int temp = Integer.parseInt(s);
        if(!(temp > 0 && temp <= 26)) {
            return false;
        }
        return true;
    }
}