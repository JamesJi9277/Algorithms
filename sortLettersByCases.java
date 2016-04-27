// Given a string which contains only letters. Sort it by lower case first and upper case second.

// Have you met this question in a real interview? Yes
// Example
// For "abAcD", a reasonable answer is "acbAD"

// Note
// It's not necessary to keep the original order of lower-case letters and upper case letters.

// Challenge
// Do it in one-pass and in-place.
//time Onlogn, space O1
public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        Arrays.sort(chars);
        doReverse(chars);
        return;
    }
    private void doReverse(char[] chars) {
        int start = 0;
        int end = chars.length - 1;
        for(int i = 0; start + i < end - i; i++) {
            char temp = chars[start + i];
            chars[start + i] = chars[end - i];
            chars[end - i] = temp;
        }
    }
}

//time On. space O1
public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if(chars == null || chars.length == 0) {
            return;
        }
        int start = 0;
        int end = chars.length - 1;
        while(start <= end) {
            while(start <= end && isLower(chars[start])) {
                start++;
            }
            while(start <= end && isUpper(chars[end])) {
                end--;
            }
            if(start <= end) {
                doSwap(chars, start, end);
                start++;
                end--;
            }
        }
        return;
    }
    private boolean isLower(char c) {
        if(c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }
    private boolean isUpper(char c) {
        if(c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
    private void doSwap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}







