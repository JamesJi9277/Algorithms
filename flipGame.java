You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].
因为string是immutable的，必须改成stingbuffer或者char[]来做
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() < 2) {
            return res;
        }
        StringBuffer sb = new StringBuffer(s);
        helper(res, sb);
        return res;
    }
    private void helper(List<String> res, StringBuffer s) {
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {
                s.setCharAt(i, '-');
                s.setCharAt(i + 1, '-');
                res.add(s.toString());
                s.setCharAt(i, '+');
                s.setCharAt(i + 1, '+');
            }
        }
    }
}



public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() < 2) {
            return res;
        }
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length - 1; i++) {
            if(ch[i] == ch[i + 1] && ch[i] == '+') {
                ch[i] = '-';
                ch[i + 1] = '-';
                res.add(String.valueOf(ch));
                ch[i] = '+';
                ch[i + 1] = '+';
            }
        }
        return res;
    }
}