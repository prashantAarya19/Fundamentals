package graph.problems;

import util.Utility;

import java.util.*;
import java.util.stream.Stream;

public class ShortestPathInDAG {
    static Map<Integer, List<Pair>> adjList = new HashMap<>();
    public static void addNode(int u, int v, int wattage) {
        Pair p = new Pair(v, wattage);
        adjList.computeIfAbsent(u, k -> new ArrayList<>());
        adjList.get(u).add(p);
    }

    public static void printGraph(Map<Integer, List<Pair>> adjList) {
        for(int k : adjList.keySet()) {
            System.out.print(k +"--->");
            for(Pair p : adjList.get(k)) {
                System.out.print("["+ p.node+", "+p.wattage+"]");
            }
            System.out.println();
        }
    }

    public static void getTopologicalSort(int node, Map<Integer, List<Pair>> adjList, boolean[] visited, Stack<Integer> topologicalStack) {
        visited[node] = true;
        adjList.computeIfAbsent(node, v -> new ArrayList<>());
        for(Pair neighbour : adjList.get(node)) {
            if(!visited[neighbour.node]) {
                getTopologicalSort(neighbour.node, adjList, visited, topologicalStack);
            }
        }
        topologicalStack.push(node);
    }
    public static void main(String[] args) {
        addNode(0, 1, 5);
        addNode(0, 2, 3);
        addNode(1, 2, 2);
        addNode(1, 3, 6);
        addNode(2, 3, 7);
        addNode(2, 4, 4);
        addNode(2, 5, 2);
        addNode(3, 4, -1);
        addNode(3, 4, -1);
        addNode(4, 5, -2);
        //addNode(5, 5, 0);

        int numberOfNodes = 6;
        boolean[] visited = new boolean[numberOfNodes];
        Stack<Integer> topologicalStack = new Stack<>();

        for(int i = 0; i < numberOfNodes; i++) {
            if(!visited[i]) {
                getTopologicalSort(i, adjList, visited, topologicalStack);
            }
        }
        printGraph(adjList);
        System.out.println("<=== Topological sort ===>");
        System.out.println(topologicalStack);

        int[] distance = new int[numberOfNodes];
        setDefaultValue(distance, Integer.MAX_VALUE);

        // Get the shortest path
        int src = 1;
        distance[src] = 0;
        getShortestPath(distance, topologicalStack, adjList);
        Utility.printArray(distance);

        Queue<Pair> p = new PriorityQueue<>((e1, e2) -> e1.wattage - e2.wattage);
        p.add(new Pair(2, 3));
        System.out.println(p);
        Optional<Pair> first = p.stream().filter(e -> e.node == 1).findFirst();
        Pair t = null;
        if(first.isPresent())
            t = first.get();



        System.out.println(t);

    }

    private static void getShortestPath(int[] distance, Stack<Integer> topologicalStack, Map<Integer, List<Pair>> adjList) {
        while(!topologicalStack.isEmpty()) {
            int top = topologicalStack.pop();
            if(distance[top] != Integer.MAX_VALUE) {
                for(Pair p : adjList.get(top)) {
                    if(distance[top] + p.wattage < distance[p.node]) {
                        distance[p.node] = distance[top] + p.wattage;
                    }
                }
            }
        }
    }

    public static void setDefaultValue(int[] arr, int defaultValue) {
        Arrays.fill(arr, defaultValue);
    }
}
