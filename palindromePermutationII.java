// Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
//
// For example:
//
// Given s = "aabb", return ["abba", "baab"].
//
// Given s = "abc", return [].
//
// Hint:
//
// If a palindromic permutation exists, we just need to generate the first half of the string.
// To generate all distinct permutations of a (half of) string, use a similar approach from: Permutations II or Next Permutation.
public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return res;
        }
        int[] map = new int[256];
        for(int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        int j = 0;
        int count = 0;
        for(int i = 0; i < 256; i++) {
            if(count == 0 && map[i] % 2 == 1) {
                j = i;
                count++;
            }
            else if(map[i] % 2 == 1) {
                return new ArrayList<String>();
            }
        }
        String cur = "";
        if(j != 0) {
            cur = "" + (char)j;
            map[j]--;
        }
        doDFS(res, cur, map, s.length());
        return res;
    }
    private void doDFS(List<String> res, String cur, int[] map, int len) {
        if(cur.length() == len) {
            res.add(new String(cur));
        }
        for(int i = 0; i < map.length; i++) {
            if(map[i] < 1) {
                continue;
            }
            map[i] -= 2;
            cur = (char)i + cur + (char)i;
            doDFS(res, cur, map, len);
            cur = cur.substring(1, cur.length() - 1);
            map[i] += 2;
        }
    }
}

//brute force time On!, space On
public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        boolean[] isUsed = new boolean[s.length()];
        HashSet<String> set = new HashSet<String>();
        helper(s, res, sb,isUsed, set);
        return res;
    }
    private void helper(String s, List<String> res, StringBuffer sb,boolean[] isUsed, HashSet<String> set) {
        if(sb.length() == s.length() && isPalindrome(sb.toString()) && !set.contains(sb.toString())) {
            res.add(new String(sb));
            set.add(new String(sb));
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(isUsed[i] == false) {
                sb.append(c);
                isUsed[i] = true;
                helper(s, res, sb, isUsed,set);
                isUsed[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        for(int i = 0; start + i < end - i; i++) {
            if(s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }
}