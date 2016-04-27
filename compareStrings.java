// Compare two strings A and B, determine whether A contains all of the characters in B.

// The characters in string A and B are all Upper Case letters.

// Have you met this question in a real interview? Yes
// Example
// For A = "ABCD", B = "ACD", return true.

// For A = "ABCD", B = "AABC", return false.

// Note
// The characters of B in A are not necessary continuous or ordered.
//这个题的test case可以使两个都为空也可以两个length == 0， 并且A中和B中都可以出现重复元素
public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if((A == null && B == null)||(A.length() == 0 && B.length()==0) ){
            return true;
        }
        if((A == null && B != null) ||(A.length() == 0 && B.length()!=0)){
            return false;
        }
        if((A != null && B == null)||(A.length() != 0 && B.length()==0)) {
            return true;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i =0; i < A.length() ; i++) {
            if(map.containsKey(A.charAt(i))) {
                int j = map.get(A.charAt(i));
                map.put(A.charAt(i), j+1);
            }
            else {
                map.put(A.charAt(i), 1);
            }
        }
        for(int i =0;i < B.length();i++) {
            if(!map.containsKey(B.charAt(i))) {
                return false;
            }
            else
            {
                int j = map.get(B.charAt(i));
                map.put(B.charAt(i), j-1);
            }
        }
        for(int i =0;i < B.length();i++) {
            if(map.get(B.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }
}
