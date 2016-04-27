// Given a string, determine if a permutation of the string could form a palindrome.
//
// For example,
// "code" -> False, "aab" -> True, "carerac" -> True.
//
// Hint:
//
// Consider the palindromes of odd vs even length. What difference do you notice?
// Count the frequency of each character.
// If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
//根据hint的提示，我可以数每一个数出现的次数，如果每个字幕出现的次数都是偶数次，那么一定可以组成palindrome,
//如果只有一个字母出现了奇数次，那么也是可以构成palindrome的，所以跟anagram差不多的做法，直接统计每个字母的频率然后抵消即可
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                set.remove(c);
            }
            else {
                set.add(c);
            }
        }
        return (set.size() < 2);
    }
}

public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[256];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }
        boolean odd = false;
        for(int i = 0; i < count.length; i++) {
            if(count[i] % 2 == 0) {
                continue;
            }
            else {
                if(odd) {
                    return false;
                }
                else {
                    odd = !odd;
                }
            }
        }
        return true;
    }
}