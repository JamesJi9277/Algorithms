implement trie with insert, search and startWith method
search Ok
insert Ok
空间复杂度O26^k

class TrieNode {
	char c;
	TrieNode[] children;
	boolean isWord;
    public TrieNode(char c) {
        this.c = c;
        children = new TrieNode[26];
        isWord = false;
    }
    public TrieNode() {
    	children = new TrieNode[26];
    	isWord = false;
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
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	if(cur.children[c - 'a'] == null) {
        		TrieNode temp = new TrieNode();
        		cur.children[c - 'a'] = temp;
        	}
        	cur = cur.children[c - 'a'];
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
        	if(cur.children[c - 'a'] == null) {
        		return false;
        	}
        	cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() = 0) {
        	return false;
        }
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++) {
        	char c = prefix.charAt(i);
        	if(cur.children[c - 'a'] == null) {
        		return false;
        	}
        	cur = cur.children[c - 'a'];
        }
        return true;
    }
}

HashMap版本
/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    char c;
    boolean isWord;
    HashMap<Character, TrieNode> children; 
    public TrieNode() {
        boolean isWord = false;
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
        if(word == null || word.length() == 0) {
        	return ;
        }
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
        	char c = word.charAt(i);
        	if(cur.children.get(c) == null) {
        		TrieNode temp = new TrieNode();
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
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) {
        	return false;
        }
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++) {
        	char c = prefix.charAt(i);
        	if(!cur.children.containsKey(c)) {
        		return false;
        	}
        	cur = cur.children.get(c);
        }
        return true;
    }
}