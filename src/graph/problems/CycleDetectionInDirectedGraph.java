package graph.problems;

import java.util.*;

public class CycleDetectionInDirectedGraph {

    // Kahn's Algorithm for cycle detection
    public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        // 1. Create adjacency list
        createAdjacencyList(edges, adjList);
        int[] indegree = new int[n+1];
        // 2. In-degree
        for(int k : adjList.keySet()) {
            for(int neighbour : adjList.get(k)) {
                indegree[neighbour] += 1;
            }
        }
        // 3. Store zero In-degree into queue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0)
                q.add(i);
        }

        // 4. Use dfs
        int count = 0;
        while(!q.isEmpty()) {
            int front = q.remove();
            count++;
            if(adjList.get(front) == null)
                adjList.put(front, new ArrayList<>());
            // Reset indegre
            for(int neighbour : adjList.get(front)) {
                indegree[neighbour] -=1;

                if(indegree[neighbour] == 0)
                    q.add(neighbour);
            }
        }
        return count != n;

    }

    public static void createAdjacencyList(ArrayList<ArrayList<Integer>> edges, Map<Integer, List<Integer>> adjList) {
        for(ArrayList<Integer> neighbours : edges) {
            int u = neighbours.get(0);
            int v = neighbours.get(1);

            if(adjList.get(u) == null)
                adjList.put(u, new ArrayList<>());
            adjList.get(u).add(v);
        }
    }
}
