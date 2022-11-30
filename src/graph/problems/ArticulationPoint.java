package graph.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticulationPoint {
    public static boolean[] findArticulationPoint(int[][] edges, int v, int n) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        createAdjacencyList(edges, adjList, v);

        int[] discovery = new int[n];
        int[] minTime = new int[n];
        boolean[] visited = new boolean[n];
        boolean[] articulationPoint = new boolean[n];
        initialize(discovery, minTime, n);
        int timer = 0;
        int parent = -1;

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, parent, discovery, minTime, adjList, visited, timer, articulationPoint);
            }
        }
        return articulationPoint;
    }

    private static void bfs(int node, int parent, int[] discovery, int[] minTime, Map<Integer, List<Integer>> adjList, boolean[] visited, int timer, boolean[] articulationPoint) {
        visited[node] = true;
        discovery[node] = minTime[node] = timer++;
        int child = 0;
        adjList.computeIfAbsent(node, val -> new ArrayList<>());
        for(int neighbour : adjList.get(node)) {
            if(!visited[neighbour]) {
                bfs(neighbour, node, discovery, minTime, adjList, visited, timer, articulationPoint);
                minTime[node] = Math.min(minTime[neighbour], minTime[node]);
                // Articulation point check
                if(minTime[neighbour] >= discovery[node] && parent != -1) {
                    articulationPoint[node] = true;
                }
                child++;
            } else {
                minTime[node] = Math.min(discovery[neighbour], minTime[node]);
            }
        }

        // For checking the first node as AP
        if(parent == -1 && child > 1) {
            articulationPoint[node] = true;
        }
    }

    private static void initialize(int[] discovery, int[] minTime, int n) {
        for(int i = 0; i < n; i++) {
            discovery[i] = -1;
            minTime[i] = -1;
        }
    }

    private static void createAdjacencyList(int[][] edges, Map<Integer, List<Integer>> adjList, int vertices) {
        for(int i = 0; i < vertices; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.computeIfAbsent(u, val -> new ArrayList<>());
            adjList.computeIfAbsent(v, val -> new ArrayList<>());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public static void main(String[] args) {
        int vertices = 8;
        int node = 7;

//        int[][] edges = new int[][]{{0, 3}, {0, 4}, {3, 4}, {0, 1}, {1, 2}};
        int[][] edges = new int[][]{{1, 2}, {1, 4}, {1, 5}, {2, 3}, {3, 4}, {4, 6}, {5, 4}, {6, 7}};
        boolean[] articulationPoint = findArticulationPoint(edges, vertices, node+1);
        printArticulationPoints(articulationPoint);
    }

    private static void printArticulationPoints(boolean[] articulationPoints) {
        for(int i = 0; i < articulationPoints.length; i++) {
            if(articulationPoints[i])
                System.out.print(i+" ");
        }
        System.out.println();
    }
}
