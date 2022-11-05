package graph.problems;

import java.util.*;

public class CycleDetectionDFS {
    public static void main(String[] args) {
        int[][] edges = {{3, 2}, {1, 2}, {2, 3}};
       // System.out.println(cycleDetection(edges, 3, 3));
        LinkedList<Integer> ll = new LinkedList<>();
    }
    public static String cycleDetection(int[][] edges, int n, int m) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Boolean> visitedTrack = new HashMap<>();
        createAdjacencyList(edges, adjList, m);
        //printAdjacencyList(adjList);
        for(int i = 0; i < n; i++) {
            if(visitedTrack.get(i) == null) {
                boolean isCycle = dfsCycle(i, -1, adjList, visitedTrack);
                if(isCycle)
                    return "Yes";
            }
        }

        return "No";
    }

    public static boolean dfsCycle(int node, int parent, Map<Integer, List<Integer>> adjList, Map<Integer, Boolean> visitedTrack) {
        visitedTrack.put(node, true);

        if(adjList.get(node) == null)
            adjList.put(node, new ArrayList<>());

        for(int neighbour : adjList.get(node)) {
            if(visitedTrack.get(neighbour) == null) {
                visitedTrack.put(neighbour, true);
                boolean isCycle = dfsCycle(neighbour, node, adjList, visitedTrack);
                if(isCycle)
                    return true;
            } else if(parent != neighbour) {
                return true;
            }
        }
        return false;
    }

    public static void createAdjacencyList(int[][] edges, Map<Integer, List<Integer>> adjList, int m) {
        for(int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if(adjList.get(u) == null)
                adjList.put(u, new ArrayList<>());
            if(adjList.get(v) == null)
                adjList.put(v, new ArrayList<>());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }


}
