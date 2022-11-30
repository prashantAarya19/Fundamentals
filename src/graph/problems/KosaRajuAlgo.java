package graph.problems;

import java.util.*;

public class KosaRajuAlgo {
    public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        createAdjacencyList(edges, adjList);
        // printAdjList(adjList);
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < v; i++) {
            if(!visited[i]) {
                dfs(i, visited, stack, adjList);
            }
        }

        // Transpose
        Map<Integer, List<Integer>> transpose = new HashMap<>();
        for(int i = 0; i < v; i++) {
            visited[i] = false;
            for(int neighbour : adjList.get(i)) {
                transpose.computeIfAbsent(neighbour, val -> new ArrayList<>());
                transpose.get(neighbour).add(i);
            }
        }

        // Reverse DFS
        int countOfTightlyConnected = 0;
        while(!stack.isEmpty()) {
            int node = stack.pop();
            if(!visited[node]) {
                ++countOfTightlyConnected;
                revDfs(node, visited, transpose);
            }
        }
        return countOfTightlyConnected;
    }

    private static void revDfs(int node, boolean[] visited, Map<Integer, List<Integer>> transpose) {
        visited[node] = true;

        transpose.computeIfAbsent(node, val -> new ArrayList<>());
        for(int neighbour : transpose.get(node)) {
            if(!visited[neighbour]) {
                revDfs(neighbour, visited, transpose);
            }
        }
    }

    private static void dfs(int node, boolean[] visited, Stack<Integer> stack, Map<Integer, List<Integer>> adjList) {
        visited[node] = true;
        adjList.computeIfAbsent(node, val -> new ArrayList<>());
        for(int neighbour : adjList.get(node)) {
            if(!visited[neighbour]) {
                dfs(neighbour, visited, stack, adjList);
            }
        }
        stack.add(node);
    }

    private static void createAdjacencyList(ArrayList<ArrayList<Integer>> edges, Map<Integer, List<Integer>> adjList) {
        for(ArrayList<Integer> neighbour : edges) {
            int u = neighbour.get(0);
            int v = neighbour.get(1);
            adjList.computeIfAbsent(u, val -> new ArrayList<>());
            adjList.get(u).add(v);
        }
    }
}
