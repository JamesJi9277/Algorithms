Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.


public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        for(int i = 0; i < n; i++) {
        	root[i] = i;
        }
        for(int[] edge : edges) {
        	int root1 = findRoot(root, edge[0]);
        	int root2 = findRoot(root, edge[1]);
        	//union
        	if(root1 != root2) {
        		root[root2] = root1;
        	}
        }
        //count
        int count = 0;
        for(int i = 0; i < n; i++) {
        	if(root[i] == i) {
        		count++;
        	}
        }
        return count;
    }
    private int findRoot(int[] root, int i) {
    	while(root[i] != i) {
    		//加了这一行代码更快
    		root[i] = root[root[i]];
    		i = root[i];
    	}
    	return i;
    }
}


quick find
public class UF {
	private int[] id;//access to component id
	private int count;//number of components
	public UF(int n) {
		count = n;
		id = new int[n];
		for(int i = 0l i < n; i++) {
			id[i] = i;
		}

		public int count() {
			return count;
		}

		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}

		public int find(int p) {
			return id[p];
		}

		public void union(int p, int q) {
			//获得p和q的组号
			int pId = find(p);
			int qId = find(q);
			//如果两组号相等，直接返回，不需要进行union的操作
			if(pId == qId) {
				return;
			}

			for(int i = 0; i < id.length; i++) {
				if(id[i] == pId) {
					id[i] = qId;
				}
			}
			count--;
		}
	}
}

quick union
private int find(int p) {
	while(p != id[p]) {
		id[p] = id[id[p]];
		p = id[p];
	}
	return p;
}

private void union(int p, int q) {
	int pRoot = id[p];
	int qRoot = id[q];
	if(pRoot == qRoot) {
		return;
	}
	id[pRoot] = qRoot;
	count--;
}