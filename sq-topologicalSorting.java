import java.util.*;
public class Solution {   
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if(graph == null || graph.size() == 0) {
        	return res;
        }
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
        	DirectedGraphNode node = queue.poll();
        	for(DirectedGraphNode neighbor : node.neighbors) {
        		map.put(neighbor, map.get(neighbor) - 1);
        		if(map.get(neighbor) == 0) {
        			queue.offer(neighbor);
        			res.add(neighbor);
        		}
        	}
        }
        return res;
    }
}