package graph.problems;

import java.util.*;

public class BFS {
    public static void createAdjacencyList(Map<Integer, List<Integer>> adjList, int[][] edges) {
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(adjList.get(u) == null) {
                adjList.put(u, new ArrayList<>());
            }

            if(adjList.get(v) == null) {
                adjList.put(v, new ArrayList<>());
            }
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public static void printAdjList(Map<Integer, Set<Integer>> adjList) {
        System.out.println("<== Printing adjacency list ==>");
        for(int i : adjList.keySet()) {
            System.out.print(i +"--> ");
            for(int j : adjList.get(i)) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public static void bfs(ArrayList<Integer> bfsList, Map<Integer, List<Integer>> adjList, Map<Integer, Boolean> visitedTrack, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visitedTrack.put(node, true);

        while(!q.isEmpty()) {
            int front = q.remove();
            bfsList.add(front);
            if(adjList.get(front) == null)
                adjList.put(front, new ArrayList<>());
            for(int elm : adjList.get(front)) {
                if(visitedTrack.get(front) == null) {
                    q.add(elm);
                    visitedTrack.put(elm, true);
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[][] edges = {{0, 1},{0, 3},{1, 2},{2, 3}}; int vertx = 4;
        int[][] edges = {{0, 1}}; int vertx = 2;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, Boolean> visitedTrack = new HashMap<>();
        ArrayList<Integer> bfsList = new ArrayList<>();
        createAdjacencyList(adjList, edges);
        for(int i = 0; i < vertx; i++) {
            if(visitedTrack.get(i) == null) {
                bfs(bfsList, adjList, visitedTrack, i);
            }
        }

        // Printing list
        for(int i : bfsList) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
