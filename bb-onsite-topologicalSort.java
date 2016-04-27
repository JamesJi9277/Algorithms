public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    	ArrayList<DirectedGraphNode> list = new ArrayList<DirectedGraphNode>();
    	if(graph == null || graph.size() == 0) {
    		return res;
    	}
    	boolean hasCycle = true;
    	HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
    	for(DirectedGraphNode node : graph) {
    		for(DirectedGraphNode neighbor : node.neighbors) {
    			if(map.containsKey(neighbor)) {
    				map.put(neighbor, map.get(neighbor) + 1);
    			}
    			else {
    				map.put(neighbor, 1);
    			}
    		}
    	}
    	Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
    	for(DirectedGraphNode node : graph) {
    		if(!map.containsKey(node)) {
    			queue.offer(node);
    			list.add(node);
    		}
    	}
    	while(!queue.isEmpty()) {
    		DirectedGraphNode node = queue.poll();
    		for(DirectedGraphNode neighbor : node.neighbors) {
    			map.put(neighbor, map.get(neighbor) - 1);
    			if(map.get(neighbor) == 0) {
    				queue.offer(node);
    				list.add(node);
    			}
    		}
    	}
    	if(res.size() == graph.size()) {
    		hasCycle = false;
    	}
    	return hasCycle == false ? res : null;
    }
}

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if(graph == null || graph.size() == 0) {
            return res;
        }
        boolean hasCycle = true;
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for(DirectedGraphNode node : graph) {
            for(DirectedGraphNode neighbor : node.neighbors) {
                if(map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                }
                else {
                    map.put(neighbor, 1);
                }
            }
        }
        for(DirectedGraphNode node : graph) {
            if(!map.containsKey(node)) {
                queue.offer(node);
                res.add(node);
            }
        }
        while(!queue.isEmpty()) {
            DirectedGraphNode temp = queue.poll();
            for(DirectedGraphNode neighbor : temp.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if(map.get(neighbor) == 0) {
                    queue.offer(neighbor);
                    res.add(neighbor);
                }
            }
        }
        if(res.size() == graph.size()) {
            hasCycle = false;
        }
        return !hasCycle ? res : null;
    }
}