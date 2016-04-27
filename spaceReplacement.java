// Write a method to replace all spaces in a string with %20. The string is given in a characters array, you can assume it has enough space for replacement and you are given the true length of the string.

// Have you met this question in a real interview? Yes
// Example
// Given "Mr John Smith", length = 13.

// The string after replacement should be "Mr%20John%20Smith".

// Note
// If you are using Java or Python，please use characters array instead of string.
public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        if(string == null || length == 0) {
            return -1;
        }
        int count = 0;
        for(int i = 0; i < length; i++) {
            if(string[i] == ' ') {
                count++;
            }
        }
        int newLength = length + 2 * count;
        int res = newLength;
        for(int i = length - 1; i >= 0; i--) {
            if(string[i] == ' ') {
                string[newLength - 1] = '0';
                string[newLength - 2] = '2';
                string[newLength - 3] = '%';
                newLength -= 3;
            }
            else {
                string[newLength - 1] = string[i];
                newLength -= 1;
            }
        }
        return res;
    }
}

