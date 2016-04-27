// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

// If the last word does not exist, return 0.

// Have you met this question in a real interview? Yes
// Example
// Given s = "Hello World", return 5.

// Note
// A word is defined as a character sequence consists of non-space characters only.
public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        if(s == null || s.length() == 0) {
            return 0;
        }
        String res = s.trim();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =0;i<res.length();i++) {
            if(res.charAt(i) == ' ') {
                stack.push(i);
            }
        }
        if(stack.isEmpty()) {
            return res.length();
        }
        else{
        String res1 = res.substring(stack.pop()+1,res.length());
        return res1.length();
        }
        
    }
}

public class Solution{
    public int lengthOfLastWord(String s){
        if(s == null || s.length() == 0)
            return 0;
        int count = 0;
        for(int i = s.length() -1; i >=0; i--)
        {
            if(s.charAt(i) != ' ')
                count++;
            else if(s.charAt(i) == ' ' && count != 0)
                return count;
        }
        return count;
    }
}


public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        if(s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int right = s.length() - 1;
        int left = right;
        while(left >= 0) {
            if(left >= 0 && isValid(s.charAt(left))) {
                left--;
            }
            else {
                break;
            }
        }
        return right - left;
    }
    private boolean isValid(char c) {
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }
}
//这里一定要注意left指针以及长度的关系
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int right = s.length() - 1;
        int left = right;
        while(left >= 0) {
            if(left >= 0 && s.charAt(left) != ' ') {
                left--;
            }
            else {
                break;
            }
        }
        return right - left;
    }
}