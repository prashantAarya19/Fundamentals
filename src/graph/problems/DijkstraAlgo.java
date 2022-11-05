package graph.problems;

import java.util.*;

public class DijkstraAlgo {
    public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
        Map<Integer, List<Pair>> adjList = new HashMap<>();
        createAdjList(adjList, edges, vec);
        printAdjacencyList(adjList);
        Queue<Pair> pq = new PriorityQueue<>((e1, e2) -> e1.wattage - e2.wattage);
        int[] dist = new int[vertices];
        ArrayList<Integer> resultList = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;
        pq.add(new Pair(source, 0));

        while(!pq.isEmpty()) {
            Pair top = pq.remove();
            int topNode = top.node;
            int topDistance = top.wattage;
            // 0 4 1 2 5
            //adjList.computeIfAbsent(topNode, k -> new ArrayList<>());
            for(Pair p : adjList.get(topNode)) {
                if(topDistance + p.wattage < dist[p.node]) {
                    Pair nodeToRemove = null;
                    Optional<Pair> opt = pq.stream().filter(e -> e.node == p.node && e.wattage > p.wattage).findFirst();
                    if(opt.isPresent())
                        nodeToRemove = opt.get();
                    if(nodeToRemove != null)
                        pq.remove(nodeToRemove);
                    dist[p.node] = topDistance + p.wattage;
                    pq.add(new Pair(p.node, topDistance+p.wattage));
                }
            }
        }
        for(int i = 0; i < vertices; i++) {
            resultList.add(dist[i]);
        }
        return resultList;

    }

    public static void createAdjList(Map<Integer, List<Pair>> adjList, int edges, ArrayList< ArrayList < Integer > > vec) {
        for(int i = 0; i < edges; i++) {
            ArrayList<Integer> neighbour = vec.get(i);
            int u = neighbour.get(0);
            int v = neighbour.get(1);
            int dist = neighbour.get(2);

            adjList.computeIfAbsent(u, k -> new ArrayList<>());
            adjList.computeIfAbsent(v, k -> new ArrayList<>());

            adjList.get(u).add(new Pair(v, dist));
            adjList.get(v).add(new Pair(u, dist));
        }
    }

    public static void printAdjacencyList(Map<Integer, List<Pair>> adjList) {
        for(int k : adjList.keySet()) {
            System.out.print(k + "---> ");
            for(Pair p : adjList.get(k))
                System.out.print("["+p.node+ ", "+p.wattage+"] ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> vec = new ArrayList<>();

        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(0);
        l1.add(1);
        l1.add(7);
        vec.add(l1);

        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(2);
        l2.add(1);
        vec.add(l2);

        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(3);
        l3.add(2);
        vec.add(l3);

        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(1);
        l4.add(2);
        l4.add(3);
        vec.add(l4);

        ArrayList<Integer> l5 = new ArrayList<>();
        l5.add(1);
        l5.add(3);
        l5.add(5);
        vec.add(l5);

        ArrayList<Integer> l6 = new ArrayList<>();
        l6.add(1);
        l6.add(4);
        l6.add(1);
        vec.add(l6);

        ArrayList<Integer> l7 = new ArrayList<>();
        l7.add(3);
        l7.add(4);
        l7.add(7);
        vec.add(l7);

        // 0 4 1 2 5
        int vertices = 5;
        int edges = 7;
        int source = 0;
        ArrayList<Integer> dijkstra = dijkstra(vec, vertices, edges, source);
        System.out.println(dijkstra);

    }
}
