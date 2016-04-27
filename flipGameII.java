You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm runtime complexity.

public class Solution {
    public boolean canWin(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length - 1; i++) {
            if(ch[i] == '+' && ch[i] == ch[i + 1]) {
                ch[i] = '-';
                ch[i + 1] = '-';
                String temp = new String(ch);
                if(!canWin(temp)) {
                    return true;
                }
                ch[i] = '+';
                ch[i + 1] = '+';
            }
        }
        return false;
    }
}