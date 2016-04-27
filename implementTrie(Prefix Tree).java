// Implement a trie with insert, search, and startsWith methods.

// Note:
// You may assume that all inputs are consist of lowercase letters a-z.
//http://blog.csdn.net/v_july_v/article/details/6897097
class TrieNode {
	boolean containsNode;
	TrieNode[] children;//这个存的是每一个节点能够扩展出来的子节点
	public TrieNode() {
		containsNode = false;
		children = new TrieNode[26];
	}
}
public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode cur = root;
		int length = word.length();
		for(int i = 0; i < length; i++) {
			int c = word.charAt(i) - 'a';
			if(cur.children[c] == null) {
				cur.children[c] = new TrieNode();
			}
			cur = cur.children[c];
		}
		cur.containsNode = true;
	}
	//search和startWith步骤都是一样的，只不过我search表示一定要找到结尾
	//所以说最终还要判断最后的TrieNode的cur的标记符是不是为true
	public boolean search(String word) {
		TrieNode cur = root;
		int length = word.length();
		for(int i = 0; i < length; i++) {
			int c = word.charAt(i) - 'a';
			if(cur.children[c] == null) {
				return false;
			}
			cur = cur.children[c];
		}
		return cur.containsNode;
	}
	public boolean startsWith(String prefix) {
		TrieNode cur = root;
		int length = prefix.length();
		for(int i = 0; i < length; i++) {
			int c = prefix.charAt(i) - 'a';
			if(cur.children[c] == null) {
				return false;
			}
			cur = cur.children[c];
		}
		return true;
	}
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");



class TrieNode {
	char content;
	boolean isEnd;
	LinkedList<TrieNode> childList;
	public TrieNode(char c) {
		content = c;
		isEnd = false;
		childList = new LinkedList<TrieNode>();
	}
	
	public TrieNode getNode(char c) {
		if(childList != null) {
		    for(TrieNode node : childList) {
		        if(node.content == c) {
		            return node;
		        }
		    }
		}
		return null;
	}
}

public class Trie {
	private TrieNode root;
	public Trie() {
		root = new TrieNode(' ');
	}
	//Insert a word into the trie
	public void insert(String word) {
		if(search(word) == true) {
			return;
		}
		TrieNode cur = root;
		for(char c : word.toCharArray()) {
			if(cur.getNode(c) != null) {
				cur = cur.getNode(c);
			}
			else {
				TrieNode child = new TrieNode(c);
				cur.childList.add(child);
				cur = cur.getNode(c);
			}
		}
		cur.isEnd = true;
	}

	//return if the word is in the trie
	public boolean search(String word) {
		TrieNode cur = root;
		for(char c : word.toCharArray()) {
			if(cur.getNode(c) == null) {
				return false;
			}
			else {
				cur = cur.getNode(c);
			}
		}
		if(cur.isEnd == true) {
			return true;
		}
		else {
			return false;
		}
	}
	//return start with given prefix
	public boolean startsWith(String prefix) {
		TrieNode cur = root;
		for(char c : prefix.toCharArray()) {
			if(cur.getNode(c) == null) {
				return false;
			}
			cur = cur.getNode(c);
		}
		return true;
	}
}