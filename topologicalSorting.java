// Given an directed graph, a topological order of the graph nodes is defined as follow:
//
// For each directed edge A -> B in graph, A must before B in the order list.
// The first node in the order can be any node in the graph with no nodes direct to it.
// Find any topological order for the given graph.
//
// Have you met this question in a real interview? Yes
// Example
// For graph as follow:
//
// picture
//
// The topological order can be:
//
// [0, 1, 2, 3, 4, 5]
// [0, 2, 3, 1, 5, 4]
// ...
分为几个步骤，
1.利用neighbor来统计出每个点的入度
2、先找到map中不存在的点，作为起始node
3.加入队列后，将与这个点相关的点入度全部减1，然后并且判断如果有点的入度为0，则将其加入queue

并且可以同样利用这个方法判断图中是不是有环的存在，如果存在着cycle的话，res.size() < graph.size()
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
import java.util.*;
public class Solution {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        boolean hasCycle = false;
        if(graph == null || graph.size() == 0) {
            return res;
        }
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
                res.add(node);
                queue.offer(node);
            }
        }
        while(!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for(DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if(map.get(neighbor) == 0) {
                    res.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        if(res.size() == graph.size()) {
            hasCycle = false;
        }
        return (hasCycle == false) ? res : null;
    }
}




public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if(graph == null || graph.size() == 0) {
            return res;
        }
        boolean hasCycle = true;
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for(DirectedGraphNode node : graph) {
            for(DirectedGraphNode neighbor : node.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, 1);
                }
                else {
                    map.put(neighbor, map.get(neighbor) + 1);
                }
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
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
        if(res.size() == graph.size()) {
            hasCycle = false;
        }
        return hasCycle == false ? res : null;
    }
}



public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if(graph == null || graph.size() == 0) {
            return res;
        }
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for(DirectedGraphNode node : graph) {
            for(DirectedGraphNode neighbor : node.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, 1);
                }
                else {
                    map.put(neighbor, map.get(neighbor) + 1);
                }
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for(DirectedGraphNode node : graph) {
            if(!map.containsKey(node)) {
                queue.offer(node);
            }
        }
        while(!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            res.add(node);
            for(DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if(map.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if(graph.size() == res.size()) {
            return res;
        }
        return null;
    }
}