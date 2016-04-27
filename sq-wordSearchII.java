class TrieNode {
    char c;
    boolean isWord;
    HashMap<Character, TrieNode> children;
    TrieNode() {
        isWord = false;
        children = new HashMap<Character, TrieNode>();
    }
    TrieNode(char c) {
        this.c = c;
        isWord = false;
        children = new HashMap<Character, TrieNode>();
    }
}
class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)) {
                TrieNode node = new TrieNode(c);
                cur.children.put(c, node);
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    public boolean find(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isWord;
    }
    public boolean startWith(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        Trie trie = new Trie();
        HashSet<String> set = new HashSet<String>();
        int m = board.length;
        int n = board[0].length;
        for(String s : words) {
            trie.insert(s);
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                helper(board, trie, res, i, j, set, "");
            }
        }
        return res;
    }
    private void helper(char[][] board, Trie trie, List<String> res, int i, int j, HashSet<String> set, String s) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {
            return;
        }
        s += board[i][j];
        if(!trie.startWith(s)) {
            return;
        }
        if(trie.find(s)) {
            if(!set.contains(s)) {
                res.add(s);
                set.add(s);
            }
        }
        char c = board[i][j];
        board[i][j] = '#';
        helper(board, trie, res, i + 1, j, set, s);
        helper(board, trie, res, i - 1, j, set, s);
        helper(board, trie, res, i, j + 1, set, s);
        helper(board, trie, res, i, j - 1, set, s);
        board[i][j] = c;
    }
}