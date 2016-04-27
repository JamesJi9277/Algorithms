// 假设给你了两个list，一个list是node，一个list是edge
// 假设图中允许单个node的存在
// 首先判断node数目和edge，如果假设n个点，但是有超过n-1条边，那么就一定有环的存在
无向图：
public class Solution {
	public boolean hasCycle(ArrayList<Node> nodes, HashMap<Node, Node> edges) {
		int[] degree = new int[nodes.size()];
		int length = degree.length;
		HashSet<Node> node = new HashSet<Node>();
		if(nodes.size() <= edges.size()) {
			return true;
		}
		for(Node node : edges.keySet()) {
			degree[node]++;
			degree[map.get(node)]++;
		}
		helper(degree, nodes, edges,set);
		return set.size() != nodes.size();
	}
	private void helper(int[] degree, ArrayList<Node> nodes, HashMap<Node, Node> edges, HashSet<Node> node) {
		for(int i = 0; i < degree.length; i++) {
			if(degree[i] == 1) {
				degree[i]--;
				set.add(degree[i]);
				degree[map.get(degree[i])]--;
				map.remove(degree[i]);
				helper(degree, nodes, edges, node);
			}
		}
	}
}

public class Solution {
	public boolean hasCycle(int n, int[][] edges) {
		int[] root = new int[n];
		for(int i = 0; i < n; i++) {
			root[i] = i;
		}
		for(int i = 0; i < edges.length; i++) {
			int root1 = findRoot(root, edges[i][0]);
			int root2 = findRoot(root, edges[i][1]);
			if(root1 == root2) {
				return true;
			}
			root[root2] = root1;
		}
		return false;
	}
	private int findRoot(int[] root, int m) {
		if(root[m] == m) {
			return m;
		}
		return findRoot(root, root[m]);
	}
}
判断有向图是否有环有三种方法：
拓扑排序、
找入度为0的顶点，输出顶点，删除出边。循环到无顶点输出
若：输出所有顶点，则课拓扑排序，无环；反之，则不能拓扑排序，有环

使用：可以使用拓扑排序为有向无环图每一个结点进行编号，拓扑排序输出的顺序可以为编号顺序
深度遍历+回溯、
深度遍历 + 判断后退边


http://shmilyaw-hotmail-com.iteye.com/blog/2116275


import java.util.ArrayList;
import java.util.Arrays;
public class TestCycle {
     private int n;
     private int[] visited;//节点状态,值为0的是未访问的
     private int[][] e;//邻接矩阵
     private ArrayList< Integer> trace=new ArrayList< Integer>();//从出发节点到当前节点的轨迹
     private boolean hasCycle=false;
     public TestCycle(int n,int[][] e){
         this.n=n;
         visited=new int[n];
         Arrays.fill(visited,0);
         this.e=e;
     }
    
     void findCycle(int v)   //递归DFS
    {
        if(visited[v]==1)
        {
            int j;
            if((j=trace.indexOf(v))!=-1)
            {
                hasCycle=true;
                System.out.print("Cycle:");
                while(j< trace.size())
                {
                    System.out.print(trace.get(j)+" ");
                    j++;
                }
                System.out.print("\n");
                return;
            }
            return;
        }
        visited[v]=1;
        trace.add(v);
        
        for(int i=0;i< n;i++)
        {
            if(e[v][i]==1)
                findCycle(i);
        }
        trace.remove(trace.size()-1);
    }
  
  public boolean getHasCycle(){
      return hasCycle;
  }
   public static void main(String[] args) {
        int n=7;
        int[][] e={
                    {0,1,1,0,0,0,0},
                    {0,0,0,1,0,0,0},
                    {0,0,0,0,0,1,0},
                    {0,0,0,0,1,0,0},
                    {0,0,1,0,0,0,0},
                    {0,0,0,0,1,0,1},
                    {1,0,1,0,0,0,0}};//邻接矩阵,值大家任意改.
        TestCycle tc=new TestCycle(n,e);
        tc.findCycle(1);
        if(!tc.hasCycle) 
            System.out.println("No Cycle.");
    }
}

时间复杂度O(v + e)
public class Solution {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        if(graph == null || graph.size() == 0) {
            return res;
        }
        if(graph.size() == 1) {
            return graph;
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
        //这里还可以说 
        if(res.size() < graph.size()) {
            return false; => exist Cycle
        }
    }
}









