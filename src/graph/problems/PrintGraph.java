package graph.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintGraph {
    public static int[][] printAdjacency(int n, int m, int[][] edges) {
        ArrayList[] neighbours = new ArrayList[n];

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if(neighbours[u] == null) {
                neighbours[u] = new ArrayList<>();
            }

            if(neighbours[v] == null) {
                neighbours[v] = new ArrayList<>();
            }
            neighbours[u].add(v);
            neighbours[v].add(u);
        }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            graph.get(i).add(i);
            for(int j = 0; neighbours[i] != null && j < neighbours[i].size(); j++) {
                graph.get(i).add((int)neighbours[i].get(j));
            }
        }
        return graph.stream().map(e -> e.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 3;
        int[][] edges = {{1, 2},
                        {0, 3},
                        {2, 3}};
        int[][] graph = printAdjacency(n, m, edges);
//        for(int i = 0; i < graph.length; i++) {
//            for(int j = 0; j < graph[i].length; j++) {
//                System.out.print(graph[i][j]+" ");
//            }
//            System.out.println();
//        }

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        al.add(new ArrayList<>());
        al.add(new ArrayList<>());
        al.add(new ArrayList<>());
        al.add(new ArrayList<>());
        al.get(0).add(0);
        al.get(0).add(3);
        al.get(1).add(1);
        al.get(1).add(2);
        al.get(2).add(2);
        al.get(2).add(1);
        al.get(2).add(3);
        al.get(3).add(3);
        al.get(3).add(0);
        al.get(3).add(2);
        int[][] objects = al.stream().map(  u  ->  u.stream().mapToInt(i->i).toArray()  ).toArray(int[][]::new);
        for(int i = 0; i < objects.length; i++) {
            for(int j = 0; j < objects[i].length; j++) {
                System.out.print(objects[i][j]+" ");
            }
            System.out.println();
        }
        /*
        0 3
        1 2
        2 1 3
        3 0 2
         */
    }
}
