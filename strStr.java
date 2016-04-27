// strstr (a.k.a find sub string), is a useful function in string operation. Your task is to implement this function.

// For a given source string and a target string, you should output the first index(from 0) of target string in source string.

// If target does not exist in source, just return -1.

// Have you met this question in a real interview? Yes
// Example
// If source = "source" and target = "target", return -1.

// If source = "abcdabcdefg" and target = "bcd", return 1.

// Challenge
// O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)

// Clarification
// Do I need to implement KMP Algorithm in a real interview?

// Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your basic implementation ability. But make sure your confirm with the interviewer first.
class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if(source == null && target != null) {
            return -1;
         }
        if(source != null && target == null) {
            return -1;
        }
        if(source == null && target == null) {
            return -1;
        }
        int i,j;
        for( i = 0;i<source.length() - target.length() + 1; i++) {
            for( j = 0; j < target.length(); j++) {
                if(source.charAt(i+j) != target.charAt(j)) {
                    break;
                }
            }
            if(j == target.length()) {
                    return i;
                }
        }
        return -1;
    }
}


class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if(source == null || target == null) {
            return -1;
        }
        if(source.contains(target)) {
            return source.indexOf(target);
        }
        return -1;
    }
}