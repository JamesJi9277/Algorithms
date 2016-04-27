// Implement an algorithm to determine if a string has all unique characters.

// Have you met this question in a real interview? Yes
// Example
// Given "abc", return true.

// Given "aab", return false.
public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        if(str == null || str.length() < 0 || str.length() > 128) {
            return false;
        }
        boolean[] check = new boolean[256];
        for(int i = 0; i < str.length(); i++) {
            if(check[str.charAt(i)]) {
                return false;
            }
            else {
                check[str.charAt(i)] = true;
            }
        }
        return true;
    }
}

public class Solution {
    public boolean isUnique(String str) {
        if(str == null || str.length() < 0 || str.length() > 128) {
            return false;
        }
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < str.length(); i++) {
            if(set.contains(str.charAt(i))) {
                return false;
            }
            else {
                set.add(str.charAt(i));
            }
        }
        return true;
    }
}
// Challenge
// What if you can not use additional data structures?
//write two for loop
public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        if(str == null || str.length() < 0 || str.length() > 128) {
            return false;
        }
        for(int i = 0; i < str.length(); i++) {
            for(int j = i + 1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
}
