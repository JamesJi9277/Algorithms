class TrieNode {
    TrieNode[] children;
    boolean isWord;
    char c;
    TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
    TrieNode(char c) {
        this.c = c;
        isWord = false;
        children = new TrieNode[26];
    }
}
class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
    public void insert(String str) {
        TreeNode cur = root;
        if(str == null || str.length() == 0) {
            return;
        }
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(root.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    public boolean startWith(String str) {
        if(str == null || str.length() == 0) {
            return false;
        }
        TrieNode cur = root;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return true;
    }
    public boolean find(String str) {
        if(str == null || str.length() == 0) {
            return false;
        }
        TrieNode cur = root;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(cur.children[c - 'a'] == null) {
                return false;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }
}


应用，word searchII，利用trie来优化时间
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> res = new ArrayList<String>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.size() == 0) {
            return res;
        }
        Trie trie = new Trie();
        for(int i = 0; i < words.size(); i++) {
            trie.insert(words.get(i));
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] isUsed = new boolean[m][n];
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                helper(board, trie, isUsed, res, "", i, j, set);
            }
        }
        return res;
    }
    private void helper(char[][] board,Trie trie, boolean[][] isUsed, ArrayList<String> res, String str, int x, int y, HashSet<String> set) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || isUsed[x][y] == true) {
            return;
        }
        str += board[x][y];
        if(!trie.startWith(str)) {
            return;
        }
        if(trie.find(str)) {
            if(!set.contains(str)) {
                res.add(str);
            }
            set.add(str);
        }
        isUsed[x][y] = true;
        helper(board, trie, isUsed, res, str, x + 1, y, set);
        helper(board, trie, isUsed, res, str, x - 1, y, set);
        helper(board, trie, isUsed, res, str, x, y + 1, set);
        helper(board, trie, isUsed, res, str, x, y - 1, set);
        isUsed[x][y] = false;
    }
}