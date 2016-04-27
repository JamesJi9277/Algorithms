public class Solution {
	public int ladderLength(String beginWord, String endWord, Set<String> set) {
		if(beginWord == null || endWord == null || set.size() == 0) {
			return 0;
		}
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		set.remove(beginWord);
		int length = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				String cur = queue.poll();
				for(char c = 'a'; c <= 'z'; c++) {
					for(int j = 0; j < cur.length(); j++) {
						StringBuffer sb = new StringBuffer(cur);
						sb.setCharAt(j, c);
						String temp = new String(sb);
						if(endWord.equals(temp)) {
							return length + 1;
						}
						if(set.contains(temp)) {
							set.remove(temp);
							queue.offer(temp);
						}
					}
				}
			}
			length++;
		}
		return 0;
	}
}