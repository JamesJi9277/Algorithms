Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets may form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

在这个例子中能画出三条回路，用不同颜色标示：
L1: 1-2-6-5-1
L2: 2-3-7-2
L3: 3-4-8-3
第一步时我们将L1压入栈S，同时我们用一个数组Path来记录我们出栈的顺序：
S: [1 2 6 5 1]
Path:
然后出栈到节点2时我们发现了2有其他路径，于是我们把2的另一条路径加入：
S: 1 [2 3 7 2]
Path: 1 5 6
此时L2已经走完，然后再开始弹出元素，直到我们发现3有其他路径，同样压入栈：
S: 1 2 [3 4 8 3]
Path: 1 5 6 2 7
之后依次弹出剩下的元素：
S: 
Path: 1 5 6 2 7 3 8 4 3 2 1
此时的Path就正好是我们需要的欧拉路径。
而且这个算法在实现时也有很巧妙的方法。因为DFS本身就是一个入栈出栈的过程，所以我们直接利用DFS的性质来实现栈，其伪代码如下：
算法模板

DFS(u):
    while (u存在未被删除的边e(u,v))
        删除边e(u,v)
        DFS(v)
    path.addFirst(u)


本题在欧拉路径的基础之上要求字典序最小，因此存储边的时候要排序，然后访问的时候每次都优先走字典序最小的那个边。这样就可以做到欧拉路径最小。
要注意的是，答案的顺序，如果使用ArrayList，最后需要逆序才是正确路径；如果使用LinkedList要将顶点从队头放入。
下面这个实现没有采用排序的做法，而是将边存入了一个min-heap，这样每次取最小需要log时间。相当于做了一个堆排序。复杂度与预处理做好排序应该是相同的。
复杂度

时间: O(E\log\frac{E}{V})O(Elog
​V
​
​E
​​ ), EE为边数，VV为顶点数
每条边访问两次，一次放入一次取出，放入和取出的时间都是O(\log n)O(logn)，其中nn为当前顶点的边数，而nn平均下来约为O(\frac{E}{V})O(
​V
​
​E
​​ )，即平均每个顶点的边数。如果预先进行比较排序，复杂度应类似。
空间: O(E)O(E)
//这题为什么可以这样子做，因为我给的ticket已经就是最终的答案，只不过是需要我去全部排序而已
//所以我做的仅仅就是排序，并不涉及到任何prune的过程，仅仅是在已经给定最终解的时候去对最终解排序
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<String>();
        HashMap<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();
        for(String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<String>());
            graph.get(ticket[0]).offer(ticket[1]);
        }
        dfs("JFK", graph, res);
        return res;
    }
    private void dfs(String cur, HashMap<String, PriorityQueue<String>> graph, LinkedList<String> res) {
        PriorityQueue<String> arrivals = graph.get(cur);
        while(arrivals != null && arrivals.size() != 0) {
            dfs(arrivals.poll(), graph, res);
        }
        res.addFirst(cur);
    }
}


//因为这一题说的是要保证按照字典序输出，所以用treemap
//如果不需要按照字典序的话，用hashmap也可以
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if(tickets == null || tickets.length == 0 || tickets[0].length == 0) {
            return res;
        }
        HashMap<String, TreeMap<String, Integer>> map = new HashMap<String, TreeMap<String, Integer>>();
        for(String[] edge : tickets) {
            if(!map.containsKey(edge[0])) {
                map.put(edge[0], new TreeMap<String, Integer>());
            }
            TreeMap<String, Integer> temp = map.get(edge[0]);
            if(temp.containsKey(edge[1])) {
                temp.put(edge[1], temp.get(edge[1]) + 1);
            }
            else {
                temp.put(edge[1], 1);
            }
        }
        dfs("JFK", map, res, tickets.length + 1);
        return res;
    }
    private boolean dfs(String cur, HashMap<String, TreeMap<String, Integer>> map, List<String> res, int size) {
        res.add(cur);
        if(res.size() == size) {
            return true;
        }
        if(map.containsKey(cur)) {
            TreeMap<String, Integer> children = map.get(cur);
            for(String next : children.keySet()) {
                if(children.get(next) > 0) {
                    children.put(next, children.get(next) - 1);
                    boolean flag = dfs(next, map, res, size);
                    if(flag) {
                        return true;
                    }
                    children.put(next, children.get(next) + 1);
                }
            }
        }
        res.remove(res.size() - 1);
        return false;
    }
}

