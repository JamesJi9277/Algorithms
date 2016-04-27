For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1:

Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3
return [1]

Example 2:

Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

刚拿到这个题最直接的思路是枚举每一个node作为root的情况然后再进行DFS找深度，维护一个hashmap和min，但写了一下发现不是那么的好写，放弃之
后来经过参考discuss后发现有一个规律就是
逐层删去叶子节点，直到剩下根节点为止
因为最后的MHT的node最多只会有两个，也就是在整个longest path中的middle位置的一个或者两个node，
不断地找到leaf节点，删除之，直到leaf节点数量不超过两个为止
时间复杂度为On，n是node数目，空间是On
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if(n == 1) {
            res.add(0);
            return res;
        }
        HashSet<Integer>[] neighbors = new HashSet[n];
        int[] degrees = new int[n];
        HashSet<Integer> isVisited = new HashSet<Integer>();
        ArrayList<Integer> leafs = new ArrayList<Integer>();
        for(int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if(neighbors[a] == null) {
                neighbors[a] = new HashSet<Integer>();
            }
            if(neighbors[b] == null) {
                neighbors[b] = new HashSet<Integer>();
            }
            neighbors[a].add(b);
            neighbors[b].add(a);
            degrees[a]++;
            degrees[b]++;
        }
        for(int i = 0; i < degrees.length; i++) {
            if(degrees[i] == 1) {
                leafs.add(i);
            }
        }
        while(isVisited.size() < n - 2) {
            ArrayList<Integer> nextLevel = new ArrayList<Integer>();
            for(int i = 0; i < leafs.size(); i++) {
                int leaf = leafs.get(i);
                isVisited.add(leaf);
                HashSet<Integer> connectToLeaf = neighbors[leaf];
                for(Integer connect : connectToLeaf) {
                    if(!isVisited.contains(connect)) {
                        degrees[connect]--;
                        if(degrees[connect] == 1) {
                            nextLevel.add(connect);
                        }
                    }
                }
            }
            leafs = nextLevel;
        }
        return leafs;
    }
}