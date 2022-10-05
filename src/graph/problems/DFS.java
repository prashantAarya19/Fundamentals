package graph.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DFS {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, Boolean> visitedTrack = new HashMap<>();
        createAdjacencyList(edges, adjList);
        printAdjList(adjList);
        for(int i = 0; i < v; i++) {
            if(visitedTrack.get(i) == null) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, adjList, component, visitedTrack);
                result.add(component);
            }
        }
        return result;
    }

    public static void dfs(int node, Map<Integer, ArrayList<Integer>> adjList, ArrayList<Integer> component, Map<Integer, Boolean> visitedTrack) {
        component.add(node);
        visitedTrack.put(node, true);
        if(adjList.get(node) == null)
            adjList.put(node, new ArrayList<>());
        for(int i : adjList.get(node)) {
            if(visitedTrack.get(i) == null) {
                visitedTrack.put(i, true);
                dfs(i, adjList, component, visitedTrack);
            }
        }
    }

    public static void createAdjacencyList(ArrayList<ArrayList<Integer>> edges, Map<Integer, ArrayList<Integer>> adjList) {
        for(int i = 0; i < edges.size(); i++) {
            int s = edges.get(i).get(0);
            int e = edges.get(i).get(1);

            if(adjList.get(s) == null)
                adjList.put(s, new ArrayList<>());
            if(adjList.get(e) == null)
                adjList.put(e, new ArrayList<>());

            adjList.get(s).add(e);
            adjList.get(e).add(s);
        }
    }

    public static void printAdjList(Map<Integer, ArrayList<Integer>> adjList) {
        for(int k : adjList.keySet()) {
            System.out.print(k+"--> ");
            for(int e : adjList.get(k)) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

    }
}
