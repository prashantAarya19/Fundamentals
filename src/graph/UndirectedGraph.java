package graph;

import java.util.*;

public class UndirectedGraph<T> {
    Map<T, List<T>> adj;
    public UndirectedGraph() {
        this.adj = new HashMap<>();
    }
    public void addEdge(T n1, T n2) {
        if(adj.get(n1) == null) {
            List<T> n1To = new ArrayList<>();
            n1To.add(n2);
            adj.put(n1, n1To);
        } else {
            List<T> list = adj.get(n1);
            list.add(n2);
        }
        if(adj.get(n2) == null) {
            List<T> n2To = new ArrayList<>();
            n2To.add(n1);
            adj.put(n2, n2To);
        } else {
            List<T> list = adj.get(n2);
            list.add(n1);
        }
    }

    public void printAdjList() {
        for(T t : adj.keySet()) {
            System.out.print(t +" ---> ");
            for(T l : adj.get(t)) {
                System.out.print(l+" ");
            }
            System.out.println();
        }
    }

    public void buildInterGraph(UndirectedGraph<Integer> graph) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of edges : ");
        int edges = s.nextInt();

        for(int i = 0; i < edges; i++) {
            int n = s.nextInt();
            int e = s.nextInt();
            graph.addEdge(n, e);
        }
    }

    public static void main(String[] args) {
//        UndirectedGraph<Integer> root = new UndirectedGraph<>();
//        root.buildInterGraph(root);
//        root.printAdjList();

        Object object = getObject();
        if(object instanceof Map) {
            Map<String, Object> object1 = (Map<String, Object>) object;
            System.out.println();
        }
/*
6
0 1
1 2
2 3
3 1
3 4
4 0
 */
    }

    public static Object getObject() {
        Map<String, String> map = new HashMap<>();
        map.put("test", "test_val");
        return map;
    }
}
