pattern中有star，每个star能且只能匹配一个字母。给定一个字典，找出所有match的words. 
比如给定字典{”ABC“，”ACD“， “AE”， “ATC”} pattern是 A*C，
那么返回“ABC” 和“ATC”
时间Ok2，空间O1
import java.util.*;
public class findPattern {
	public void findWord(String[] strs, String pattern) {
		if(strs == null || strs.length == 0 || pattern == null || pattern.length() == 0) {
			return;
		}
		ArrayList<String> res = new ArrayList<String>();
		int i = 0;
		int j = 0;
		for(i = 0; i < strs.length; i++) {
			if(pattern.length() != strs[i].length()) {
				continue;
			}
			StringBuffer sb = new StringBuffer();
			for(j = 0; j < pattern.length(); j++) {
				if(pattern.charAt(j) == '*') {
					sb.append(strs[i].charAt(j));
				}
				else {
					if(pattern.charAt(j) == strs[i].charAt(j)) {
						sb.append(strs[i].charAt(j));
					}
					else {
						break;
					}
				}
			}
			if(j == pattern.length()) {
				res.add(sb.toString());
			}
		}
		for(String s : res) {
			System.out.print(s + " ");
		}
	}
	public static void main(String[] args) {
		findPattern f = new findPattern();
		String[] strs = {"ABC", "ACC", "ASC", "ASSC"};
		String pattern = "A*C";
		f.findWord(strs, pattern);
	}
}



class TrieNode {
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

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

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

public class findPattern {
	public void findWord(String[] strs, String pattern) {
		if(strs == null || strs.length == 0 || pattern == null || pattern.length() == 0) {
			return;
		}
		Trie trie = new Trie();
		for(String s : strs) {
			if(s.length() == pattern.length()) {
				trie.insert(s);
			}
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < pattern.length(); i++) {
			if(pattern.charAt(i) == '*') {
				set.add(i);
			}
		}
		int level = 0;
		TrieNode cur = trie.root;
		while(cur != null) {
			StringBuffer sb = new StringBuffer();
			if(set.contains(level)) {
				for(Character c : cur.children.keySet()) {
					sb.append(c);
					level++;
					cur = cur.children.get(c);
				}
			}
			else {
				sb.append(c);
				level++;
				cur = cur.children.get(c);
			}
		}
	}
}