package graph.problems;

import java.util.*;

public class KruskalsAlgo {

    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        sortEdges(edges);
        int[] parent = new int[n];
        int[] rank = new int[n];
        initialize(parent, rank, n);
        int minWeight = 0;
        for(int i = 0; i < edges.size(); i++) {
            int u = findParent(edges.get(i).get(0), parent);
            int v = findParent(edges.get(i).get(1), parent);
            int weight = edges.get(i).get(2);

            if(u != v) {
                minWeight += weight;
                unionSet(u, v, parent, rank);
            }
        }
        return minWeight;

    }

    private static void initialize(int[] parent, int[] rank, int n) {
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    private static void unionSet(int u, int v, int[] parent, int[] rank) {
        u = parent[u];
        v = parent[v];

        if(rank[u] < rank[v]) {
            parent[u] = v;
        } else if(rank[u] > rank[v]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u] += 1;
        }
    }

    private static int findParent(int node, int[] parent) {
        if(node == parent[node])
            return node;
        return parent[node] = findParent(parent[node], parent);
    }

    private static void sortEdges(ArrayList<ArrayList<Integer>> edges) {
        //edges.forEach(Collections::sort);
        Collections.sort(edges, (e1, e2) -> e1.get(2) - e2.get(2));
    }
}
