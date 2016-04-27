/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */


/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    TrieNode[] children;
    char c;
    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
    public TrieNode(char c) {
        this.c = c;
        isWord = false;
        children = new TrieNode[26];
    }
}

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0) {
            return;
        }
        TrieNode crt = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(crt.children[c - 'a'] == null) {
                TrieNode temp = new TrieNode();
                crt.children[c - 'a'] = temp;;
            }
            crt = crt.children[c - 'a'];
        }
        crt.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length() == 0) {
            return false;
        }
        TrieNode crt = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(crt.children[c - 'a'] == null) {
                return false;
            }
            crt = crt.children[c - 'a'];
        }
        return crt.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieNode crt = root;
        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(crt.children[c - 'a'] == null) {
                return false;
            }
            crt = crt.children[c - 'a'];
        }
        return true;
    }
}



class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    HashMap<Character, TrieNode> children;
    char c;
    public TrieNode() {
        isWord = false;
        children = new HashMap<Character, TrieNode>();
    }
    public TrieNode(char c) {
        this.c = c;
        isWord = false;
        children = new HashMap<Character, TrieNode>();
    }
}

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        if(word == null || word.length() == 0) {
            return;
        }
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!cur.children.containsKey(c)) {
                TrieNode temp = new TrieNode(c);
                cur.children.put(c, temp);
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null || word.length() == 0) {
            return false;
        }
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

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String word) {
        if(word == null || word.length() == 0) {
            return false;
        }
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
