Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Have you met this question in a real interview? Yes
Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Note
You can assume that no duplicate edges will appear in edges. 
Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
//quick union
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        int[] root = new int[n];
        for(int i = 0; i < n; i++) {
            root[i] = i;
        }
        for(int i = 0; i < edges.length; i++) {
            int root1 = findRoot(root, edges[i][0]);
            int root2 = findRoot(root, edges[i][1]);
            if(root1 == root2) {
                return false;
            }
            root[root2] = root1;
        }
        return edges.length == n - 1;
    }
    private int findRoot(int[] root, int m) {
        if(root[m] == m) {
            return m;
        }
        else {
            return findRoot(root, root[m]);
        }
    }
}
