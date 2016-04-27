time Omn* 4^k
space Omn + k
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) {
        	return false;
        }
        if(board == null || board.length == 0 || board[0].length == 0) {
        	return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] isUsed = new boolean[m][n];
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(helper(board, word, 0, i, j, isUsed)) {
        			return true;
        		}
        	}
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int index, int x, int y, boolean[][] isUsed) {
    	//注意要先判断index
    	if(index == word.length()) {
    		return true;
    	}
    	if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || isUsed[x][y] == true || word.charAt(index) != board[x][y]) {
    		return false;
    	}
    	isUsed[x][y] = true;
    	boolean res = helper(board, word, index + 1, x + 1, y, isUsed) ||
    	helper(board, word, index + 1, x - 1, y, isUsed) ||
    	helper(board, word, index + 1, x, y + 1, isUsed) ||
    	helper(board, word, index + 1, x, y - 1, isUsed); 
    	isUsed[x][y] = false;
    	return res;
    }
}

word searchII
class TrieNode {
	boolean isWord;
	HashMap<Character, TrieNode> children;
	char c;
	TrieNode(char c) {
		this.c = c;
		isWord = false;
		children = new HashMap<Character, TrieNode>();
	}
	TrieNode() {
		isWord = false;
		children = new HashMap<Character, TrieNode>();
	}
}
class Trie {
	TrieNode root;
	Trie() {
		root = new TrieNode();
	}
	public void insert(String s) {
		if(s == null || s.length() == 0) {
			return ;
		}
		TrieNode cur = root;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!cur.children.containsKey(c)) {
				TrieNode temp = new TrieNode();
				cur.children.put(c, temp);
			}
			cur = cur.children.get(c);
		}
		cur.isWord = true;
	}
	public boolean search(String s) {
		if(s == null || s.length() == 0) {
			return false;
		}
		TrieNode cur = root;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!cur.children.containsKey(c)) {
				return false;
			}
			cur = cur.children.get(c);
		}
		return cur.isWord;
	}
	public boolean startWith(String s) {
		if(s == null || s.length() == 0) {
			return false;
		}
		TrieNode cur = root;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
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
        if(board == null || board.length == 0 || board[0].length == 0) {
        	return res;
        }
        Trie trie = new Trie();
        for(String str : words) {
        	trie.insert(str);
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
    private void helper(char[][] board, Trie trie, boolean[][] isUsed, List<String> res, String str, int x, int y, HashSet<String> set) {
    	if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || isUsed[x][y] == true) {
            return;
        }
    	str += board[x][y];
    	if(!trie.startWith(str)) {
    		return;
    	}
    	if(trie.search(str)) {
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




