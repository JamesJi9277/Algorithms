You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.

//只要存在着4，那么必然自己要先拿一个，所以肯定赢不了
public class Solution {
    public boolean canWinNim(int n) {
        return (n % 4 == 0)? false : true;
    }
}
//dp
public class Solution {
    public boolean canWinNim(int n) {
    if(n < 4)
        return true;
    boolean[] res = new boolean[n + 1];
    res[0] = true;
    res[1] = true;
    res[2] = true;
    res[3] = true;
    for(int i = 4 ; i <= n ; i++)
        res[i] = res[i - 1] || res[i - 2] || res[i - 3];
    return res[n];
    }
}