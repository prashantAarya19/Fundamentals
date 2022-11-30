package graph.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BridgesInGraph {
    public static List<List<Integer>> findBridges(int[][] edges, int v, int e) {

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        createAdjacencyList(edges, adjList);

        int timer = 0;
        int[] discovery = new int[v];
        int[] lowestTime = new int[v];
        int parent = -1;
        boolean[] visited = new boolean[v];
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < v; i++) {
            if(!visited[i]) {
                dfs(i, timer, discovery, lowestTime, parent, visited, result, adjList);
            }
        }
        return result;

    }

    private static void dfs(int node, int timer, int[] discovery, int[] lowestTime, int parent, boolean[] visited, List<List<Integer>> result, Map<Integer, List<Integer>> adjList) {
        discovery[node] = lowestTime[node] = timer++;
        visited[node] = true;
        adjList.computeIfAbsent(node, val -> new ArrayList<>());
        for(int neighbour : adjList.get(node)) {
            if(neighbour == parent) {
                continue;
            } else if(!visited[neighbour]) {
                dfs(neighbour, timer, discovery, lowestTime, node, visited, result, adjList);
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[neighbour]);
                // Check if edge is a bridge
                if(lowestTime[neighbour] > discovery[node]) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(node);
                    bridge.add(neighbour);
                    result.add(bridge);
                }
            } else {
                // Back edge
                lowestTime[node] = Math.min(lowestTime[node], discovery[neighbour]);
            }
        }

    }

    private static void createAdjacencyList(int[][] edges, Map<Integer, List<Integer>> adjList) {

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList.computeIfAbsent(u, val -> new ArrayList<>());
            adjList.computeIfAbsent(v, val -> new ArrayList<>());

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0,2}, {1,2}, {0 ,3}, {3, 4}};
        System.out.println(findBridges(edges, 5, 5));
    }
}
