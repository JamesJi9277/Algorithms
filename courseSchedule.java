public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        int numNode = 0;
        for(int i = 0; i < numCourses; i++) {
			graph.put(i, new ArrayList<Integer>());
		}
        for(int[] edge : prerequisites) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            numNode++;
            for(Integer i : graph.get(temp)) {
                indegree[i]--;
                if(indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return numNode == numCourses;
    }
}
