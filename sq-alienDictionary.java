public class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) {
        	return "";
        }
        HashMap<Character, HashSet<Character>> graph = new HashMap<Character, HashSet<Character>>();
        for(int i = 0; i < words.length; i++) {
        	for(int j = 0; j < words[i].length(); j++) {
        		if(!graph.containsKey(words[i].charAt(j))) {
        			graph.put(words[i].charAt(j), new HashSet<Character>());
        		}
        	}
        }
        for(int i = 0; i < words.length - 1; i++) {
            getOrder(graph, words[i], words[i + 1]);
        }
        return topoSort(graph);
    }
    private void getOrder(HashMap<Character, HashSet<Character>> graph, String prev, String cur) {
    	int minLength = Math.min(prev.length(), cur.length());
    	for(int i = 0; i < minLength; i++) {
    		char p = prev.charAt(i);
    		char c = cur.charAt(i);
    		if(p != c) {
    			if(!graph.get(p).contains(c)) {
    				graph.get(p).add(c);
    			}
    			break;
    		}
    	}
    }
    private String topoSort(HashMap<Character, HashSet<Character>> graph) {
    	Queue<Character> queue = new LinkedList<Character>();
    	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    	int numNode = 0;
    	StringBuffer sb = new StringBuffer();
    	for(Character c : graph.keySet()) {
    		for(char a : graph.get(c)) {
    			if(!map.containsKey(a)) {
    				map.put(a, 1);
    			}
    			else {
    				map.put(a, map.get(a) + 1);
    			}
    		}
    	}
    	for(Character c : graph.keySet()) {
    		if(!map.containsKey(c)) {
    			queue.offer(c);
    		}
    	}
    	while(!queue.isEmpty()) {
    		Character c = queue.poll();
    		numNode++;
    		sb.append(c);
    		for(Character a : graph.get(c)) {
    			map.put(a, map.get(a) - 1);
    			if(map.get(a) == 0) {
    				queue.offer(a);
    			}
    		}
    	}
    	if(numNode != graph.size()) {
    		return "";
    	}
    	return sb.toString();
    }
}