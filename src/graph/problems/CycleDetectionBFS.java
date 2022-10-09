package graph.problems;

import java.util.*;

public class CycleDetectionBFS {
    public static String cycleDetection(int[][] edges, int n, int m) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        createAdjacencyList(adjList, edges);
        //printAdjList(adjList);
        Map<Integer, Boolean> visitedTrack = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(visitedTrack.get(i) == null) {
                boolean isCycle = isCyclic(i, adjList, visitedTrack);
                if(isCycle)
                    return "Yes";
            }
        }
        return "No";
    }

    public static boolean isCyclic(int node, Map<Integer, List<Integer>> adjList, Map<Integer, Boolean> visitedTrack) {
        Map<Integer, Integer> parentTrack = new HashMap<>();
        parentTrack.put(node, -1);
        visitedTrack.put(node, true);
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            int current = q.remove();
            if(adjList.get(current) == null)
                adjList.put(current, new ArrayList<>());
            for(int e : adjList.get(current)) {
                if(visitedTrack.get(e) == null) {
                    q.add(e);
                    visitedTrack.put(e, true);
                    parentTrack.put(e, current);
                } else if(visitedTrack.get(e) == true && parentTrack.get(current) != null && parentTrack.get(current) != e) {
                    return true;
                }

            }

        }
        return false;
    }

    public static void createAdjacencyList(Map<Integer, List<Integer>> adjList, int[][] edges) {
        for(int i = 0; i < edges.length; i++) {
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

    public static void printAdjList(Map<Integer, List<Integer>> adjList) {
        for(int k : adjList.keySet()) {
            System.out.print(k+"--> ");
            for(int i : adjList.get(k))
                System.out.print(i+" ");
            System.out.println();
        }
    }
}
