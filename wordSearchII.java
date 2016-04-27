// Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 


// Have you met this question in a real interview? Yes
// Example
// Given matrix:
// doaf
// agai
// dcan
// and dictionary:
// {"dog", "dad", "dgdg", "can", "again"}

// return {"dog", "dad", "can", "again"}


// dog:
// doaf
// agai
// dcan
// dad:
// doaf
// agai
// dcan
// can:
// doaf
// agai
// dcan
// again:
// doaf
// agai
// dcan
// Challenge
// Using trie to implement your algorithm
class TrieNode {
    boolean isWord;
    TrieNode[] children;
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
        TrieNode crt = root;
        if(str == null || str.length() == 0) {
            return;
        }
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(crt.children[c - 'a'] == null) {
                crt.children[c - 'a'] = new TrieNode();
            }
            crt = crt.children[c - 'a'];
        }
        crt.isWord = true;
    }
    public boolean startWith(String str) {
        if(str == null || str.length() == 0) {
            return false;
        }
        TrieNode crt = root;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(crt.children[c - 'a'] == null) {
                return false;
            }
            crt = crt.children[c - 'a'];
        }
        return true;
    }
    public boolean find(String str) {
        if(str == null || str.length() == 0) {
            return false;
        }
        TrieNode crt = root;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(crt.children[c - 'a'] == null) {
                return false;
            }
            crt = crt.children[c - 'a'];
        }
        return crt.isWord;
    }
}
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
        //记住我的isUsed的判断始终是夹着回溯的首尾，不然容易出错
        isUsed[x][y] = true;
        helper(board, trie, isUsed, res, str, x + 1, y, set);
        helper(board, trie, isUsed, res, str, x - 1, y, set);
        helper(board, trie, isUsed, res, str, x, y + 1, set);
        helper(board, trie, isUsed, res, str, x, y - 1, set);
        isUsed[x][y] = false;
    }
}

//private函数还可以像下面这种方式来写，只不过为了ac，
//调换了一下判断的顺序，同时也要注意一开始对temp.length!= 0&& 的判断
private void helper(char[][] board, String[] words, HashSet<String> set, Trie trie, boolean[][] isUsed, List<String> res, int i, int j, String str) {
        if(str.length() != 0 && !trie.startWith(str)) {
            return;
        }
        if(trie.find(str)) {
            if(!set.contains(str)) {
                res.add(str);
            }
            set.add(str);
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || isUsed[i][j] == true) {
            return;
        }
        //str = str + board[i][j];
        
        isUsed[i][j] = true;
        helper(board, words, set, trie, isUsed, res, i + 1, j, str+ board[i][j]);
        helper(board, words, set, trie, isUsed, res, i - 1, j, str+ board[i][j]);
        helper(board, words, set, trie, isUsed, res, i, j + 1, str+ board[i][j]);
        helper(board, words, set, trie, isUsed, res, i, j - 1, str+ board[i][j]);
        isUsed[i][j] = false;
    }



import java.util.*;
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
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
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
    public boolean find(String word) {
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
    public boolean startWith(String word) {
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
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] isUsed = new boolean[m][n];
        HashSet<String> set = new HashSet<String>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                helper(board, trie, isUsed, set, i, j, "", res);
            }
        }
        return res;
    }
    private void helper(char[][] board, Trie trie, boolean[][] isUsed, HashSet<String> set, int i, int j, String str,List<String> res) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || isUsed[i][j] == true) {
            return;
        }
        str += board[i][j];
        if(!trie.startWith(str)) {
            return;
        }
        if(trie.find(str)) {
            if(!set.contains(str)) {
                res.add(str);
                set.add(str);
            }
        }
        isUsed[i][j] = true;
        helper(board, trie, isUsed, set, i + 1, j, str, res);
        helper(board, trie, isUsed, set, i - 1, j, str, res);
        helper(board, trie, isUsed, set, i, j + 1, str, res);
        helper(board, trie, isUsed, set, i, j - 1, str, res);
        isUsed[i][j] = false;
    }
}


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
        for(int i = 0; i < words.size(); i++) {
            if(exist(board, words.get(i))) {
                res.add(words.get(i));
            }
        }
        return res;
    }
    public boolean exist(char[][] board, String word){
		if(board == null || board.length == 0 || board[0].length == 0)
			return false;
		if(word == null || word.length() == 0)
			return true;
		boolean[][] isUsed = new boolean[board.length][board[0].length];
		for(int i =0;i<board.length;i++){
			for(int j =0;j<board[0].length;j++){
				isUsed[i][j] = false;
			}
		}
		for(int i =0;i<board.length;i++){
			for(int j =0;j<board[0].length;j++){
				if(wordSearch(board,word,isUsed,0,i,j))
					return true;
			}
		}
		return false;
	}
	private boolean wordSearch(char[][] board, String word, boolean[][] isUsed, int index, int i, int j){
		if(index == word.length())
			return true;
		if(i<0|| j< 0|| i >= board.length|| j >= board[0].length||isUsed[i][j] == true|| board[i][j]!=word.charAt(index))  
			return false; 
		isUsed[i][j] = true;
		boolean res = wordSearch(board,word,isUsed,index+1,i-1,j)||wordSearch(board,word,isUsed,index+1,i+1,j)||wordSearch(board,word,isUsed,index+1,i,j-1)||wordSearch(board,word,isUsed,index+1,i,j+1);
		isUsed[i][j] = false;
		return res;
	}
}
