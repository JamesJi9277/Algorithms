// Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
//
// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// Have you met this question in a real interview? Yes
// Example
// Given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.
//
// Note
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || wordList.size() == 0) {
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        wordList.remove(beginWord);
        int length = 1;
        while(!queue.isEmpty()) {
            int count = queue.size();
            for(int i = 0; i < count; i++) {
                String cur = queue.poll();
                for(char c = 'a'; c <= 'z'; c++) {
                    for(int j = 0; j < cur.length(); j++) {
                        if(c == cur.charAt(j)) {
                            continue;
                        }
                        String temp = replace(cur, j, c);
                        if(temp.equals(endWord)) {
                            return length + 1;
                        }
                        if(wordList.contains(temp)) {
                            queue.offer(temp);
                            wordList.remove(temp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
    private String replace(String s, int i, char c) {
        StringBuffer sb = new StringBuffer(s);
        sb.setCharAt(i, c);
        return sb.toString();
    }
}
